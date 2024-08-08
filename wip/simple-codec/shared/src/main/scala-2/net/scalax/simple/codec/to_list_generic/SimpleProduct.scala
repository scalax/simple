package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.codec.generic.SimpleNamed
import shapeless._
import utils._

import scala.collection.compat._

object SimpleProduct {

  trait AppenderImpl[F[_[_]]] extends SimpleP.Appender[F] with CompatLabelled[F] with ModelSize[F] {
    override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: SimpleP.AppendMonad[M1])(
      func: SimpleP.TypeGen[M1, M2, M3, M4]
    ): M1[F[M2], F[M3], F[M4]]
    override def modelLabelled: F[CompatLabelled.CompatNamed]
    override def modelSize: Int

    def modelSizeF: ModelSize[F]                = this
    def modelCompatLabelledF: CompatLabelled[F] = this
    def appenderF: SimpleP.Appender[F]          = this
    def modelLabelledF: ModelLabelled[F]        = CompatLabelled.toLabelled[F](this, this)
  }

  object Appender {

    trait HighTran[F[_[_]], G[_[_]]] {
      def io[In[_]]: SimpleFrom[F[In]] with SimpleTo[F[In]]
    }

    object HighTran {
      def tran[F[_[_]]](
        h: HighTran[F, ({ type GG[_[_]] = HList })#GG]
      ): (SimpleP.Appender[({ type GG[_[_]] = HList })#GG], CompatLabelled[F], ModelSize[F]) => AppenderImpl[F] =
        (appenderFImpl, comF, modelF) =>
          new AppenderImpl[F] {
            override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: SimpleP.AppendMonad[M1])(
              func: SimpleP.TypeGen[M1, M2, M3, M4]
            ): M1[F[M2], F[M3], F[M4]] =
              monad.to[HList, HList, HList, F[M2], F[M3], F[M4]](appenderFImpl.toHList(monad)(func))(
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

      def get(i: Int): SimpleP.Appender[F1] = {
        if (i >= appenderList.size) {
          this.synchronized {
            while (i >= appenderList.size) {
              if (appenderList.headOption.isDefined) {
                appenderList = appender.append(appenderList.head).asInstanceOf[SimpleP.Appender[F1]] :: appenderList
              } else {
                appenderList = List(appender.zero.asInstanceOf[SimpleP.Appender[F1]])
              }
            }

            appenderArray = appenderList.reverse.to(Array)
          }
        }

        appenderArray(i)
      }

      private var appenderList: List[SimpleP.Appender[F1]]   = List.empty
      private var appenderArray: Array[SimpleP.Appender[F1]] = Array.empty

    }

    trait FuncInnerApply1[F[_[_]] <: Product] {
      def derived(
        simpleTo: SimpleTo[F[({ type AnyF[_] = Any })#AnyF]]
          with SimpleFrom[F[({ type AnyF[_] = Any })#AnyF]]
          with SimpleNamed[F[({ type AnyF[_] = Any })#AnyF]]
      ): AppenderImpl[F] = {
        type H1[_[_]] = HList

        val compatLabelled = CompatLabelled[F].derived(simpleTo)
        val modelSize      = ModelSize[F].caseClass(compatLabelled.modelLabelled)

        Appender.HighTran.tran(new HighTran[F, H1] {
          override def io[In[_]]: SimpleFrom[F[In]] with SimpleTo[F[In]] = simpleTo.asInstanceOf[SimpleFrom[F[In]] with SimpleTo[F[In]]]
        })(GetAppender.get(modelSize.modelSize).asInstanceOf[SimpleP.Appender[H1]], compatLabelled, modelSize)
      }
    }

    def apply[F[_[_]] <: Product]: FuncInnerApply1[F] = new FuncInnerApply1[F] {
      //
    }
  }

}
