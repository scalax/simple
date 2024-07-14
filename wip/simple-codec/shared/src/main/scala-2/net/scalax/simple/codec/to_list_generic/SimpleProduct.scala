package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.codec.generic.SimpleNamed
import shapeless._
import utils._

import scala.collection.compat._

object SimpleProduct {

  trait AppendMonad[M[_, _, _]] {
    def zip[A, B, C, S, T, U](ma: M[A, B, C], ms: M[S, T, U]): M[(A, S), (B, T), (C, U)]
    def to[A, B, C, S, T, U](m1: M[A, B, C])(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M[S, T, U]
    def zero: M[Unit, Unit, Unit]
  }

  trait TypeGen[M1[_, _, _], M2[_], M3[_], M4[_]] {
    def apply[T]: M1[M2[T], M3[T], M4[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2, M3, M4]): M1[F[M2], F[M3], F[M4]]
  }

  trait AppenderImpl[F[_[_]]] extends Appender[F] with CompatLabelled[F] with ModelSize[F] {
    override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2, M3, M4]): M1[F[M2], F[M3], F[M4]]
    override def modelLabelled: F[CompatLabelled.CompatNamed]
    override def modelSize: Int
  }

  object Appender {

    trait HighTran[F[_[_]], G[_[_]]] {
      def io[In[_]]: SimpleFrom[F[In], G[In]] with SimpleTo[F[In], G[In]]
    }

    object HighTran {
      def tran[F[_[_]], G[_[_]]](h: HighTran[F, G]): (Appender[G], CompatLabelled[F], ModelSize[F]) => AppenderImpl[F] =
        (appenderF, comF, modelF) =>
          new AppenderImpl[F] {
            override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: AppendMonad[M1])(
              func: TypeGen[M1, M2, M3, M4]
            ): M1[F[M2], F[M3], F[M4]] =
              monad.to[G[M2], G[M3], G[M4], F[M2], F[M3], F[M4]](appenderF.toHList(monad)(func))(
                h.io[M2].from,
                h.io[M3].from,
                h.io[M4].from
              )(
                h.io[M2].to,
                h.io[M3].to,
                h.io[M4].to
              )
            override val modelLabelled: F[CompatLabelled.CompatNamed] = comF.modelLabelled
            override val modelSize: Int                               = modelF.modelSize
          }
    }

    val appender: HListUtils2[HList, ({ type Ad[Head, TU <: HList] = Head :: TU })#Ad, HNil] =
      new HListUtils2[HList, ({ type Ad[Head, TU <: HList] = Head :: TU })#Ad, HNil] {
        override def appendData[Head, Tail <: HList](h: Head, t: Tail): Head :: Tail = h :: t
        override def takeHead[Head, Tail <: HList](dataList: Head :: Tail): Head     = dataList.head
        override def takeTail[Head, Tail <: HList](dataList: Head :: Tail): Tail     = dataList.tail
        override val takeZero: HNil                                                  = HNil
      }

    object GetAppender {
      type F1[_[_]] <: HList

      def get(i: Int): Appender[F1] = {
        if (i >= appenderList.size) {
          this.synchronized {
            while (i >= appenderList.size) {
              if (appenderList.headOption.isDefined) {
                appenderList = appender.append(appenderList.head).asInstanceOf[Appender[F1]] :: appenderList
              } else {
                appenderList = List(appender.zero.asInstanceOf[Appender[F1]])
              }
            }

            appenderArray = appenderList.reverse.to(Array)
          }
        }

        appenderArray(i)
      }

      private var appenderList: List[Appender[F1]]   = List.empty
      private var appenderArray: Array[Appender[F1]] = Array.empty

    }

    trait FuncInnerApply1[F[_[_]] <: Product] {
      def derived(
        simpleTo: SimpleTo[F[({ type AnyF[_] = Any })#AnyF], _ <: HList]
          with SimpleFrom[F[({ type AnyF[_] = Any })#AnyF], _ <: HList]
          with SimpleNamed[F[({ type AnyF[_] = Any })#AnyF]]
      ): AppenderImpl[F] = {
        type H1[_[_]] = HList

        val compatLabelled = CompatLabelled[F].derived(simpleTo)
        val modelSize      = ModelSize[F].derived(compatLabelled.modelLabelled.productArity)

        Appender.HighTran.tran(new HighTran[F, H1] {
          override def io[In[_]]: SimpleFrom[F[In], HList] with SimpleTo[F[In], HList] = simpleTo.asInstanceOf[SimpleFrom[F[In], HList]
            with SimpleTo[F[In], HList]]
        })(GetAppender.get(modelSize.modelSize).asInstanceOf[Appender[H1]], compatLabelled, modelSize)
      }
    }

    def apply[F[_[_]] <: Product]: FuncInnerApply1[F] = new FuncInnerApply1[F] {
      //
    }
  }

}
