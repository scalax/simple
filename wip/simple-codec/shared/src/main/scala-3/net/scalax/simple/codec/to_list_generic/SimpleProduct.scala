package net.scalax.simple.codec
package to_list_generic

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

  object Appender {

    trait HighTran[F[_[_]], G[_[_]]] {
      def io[In[_]]: SimpleFrom[F[In], G[In]] with SimpleTo[F[In], G[In]]
    }

    object HighTran {
      def tran[F[_[_]], G[_[_]]](h: HighTran[F, G]): Appender[G] => Appender[F] = appenderF =>
        new Appender[F] {
          override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: AppendMonad[M1])(
            func: TypeGen[M1, M2, M3, M4]
          ): M1[F[M2], F[M3], F[M4]] =
            monad.to[G[M2], G[M3], G[M4], F[M2], F[M3], F[M4]](appenderF.toHList(monad)(func))(h.io[M2].from, h.io[M3].from, h.io[M4].from)(
              h.io[M2].to,
              h.io[M3].to,
              h.io[M4].to
            )
        }
    }

    val appender: HListUtils2[Tuple, ({ type Ad[Head, TU <: Tuple] = Head *: TU })#Ad, EmptyTuple] =
      new HListUtils2[Tuple, ({ type Ad[Head, TU <: Tuple] = Head *: TU })#Ad, EmptyTuple] {
        override def appendData[Head, Tail <: Tuple](h: Head, t: Tail): Head *: Tail = h *: t
        override def takeHead[Head, Tail <: Tuple](dataList: Head *: Tail): Head     = dataList.head
        override def takeTail[Head, Tail <: Tuple](dataList: Head *: Tail): Tail     = dataList.tail
        override val takeZero: EmptyTuple                                            = EmptyTuple
      }

    object GetAppender {
      type F1[_[_]] <: Tuple

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

    trait FuncInnerApply1[F[_[_]]] {
      def derived[HList](
        simpleTo: SimpleTo[F[({ type AnyF[_] = Any })#AnyF], HList] with SimpleFrom[F[({ type AnyF[_] = Any })#AnyF], HList]
      )(implicit labelled: ModelSize[F]): Appender[F] = {
        type H1[_[_]] = HList

        Appender.HighTran.tran(new HighTran[F, H1] {
          override def io[In[_]]: SimpleFrom[F[In], HList] with SimpleTo[F[In], HList] = simpleTo.asInstanceOf[SimpleFrom[F[In], HList]
            with SimpleTo[F[In], HList]]
        })(GetAppender.get(labelled.modelSize).asInstanceOf[Appender[H1]])
      }
    }

    def apply[F[_[_]]]: FuncInnerApply1[F] = new FuncInnerApply1[F] {
      //
    }
  }

}
