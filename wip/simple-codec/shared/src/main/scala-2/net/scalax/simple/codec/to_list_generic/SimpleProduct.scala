package net.scalax.simple.codec
package to_list_generic

import shapeless._
import utils._

import scala.collection.compat._

trait AppenderFromSize[F[_[_]]] {
  self =>

  def inputModelSize(modelSize: Int): SimpleP.Appender[F]
  def inputModelSizeF(modelSize: ModelSize[F]): SimpleP.Appender[F] = self.inputModelSize(modelSize.modelSize)
}

object AppenderFromSize {
  self =>

  private def tran[F[_[_]]](h: SimpleFrom[F[({ type FX[_] = Any })#FX]] with SimpleTo[F[({ type FX[_] = Any })#FX]]): AppenderFromSize[F] =
    new AppenderFromSize[F] {
      override def inputModelSize(i: Int): SimpleP.Appender[F] = new SimpleP.Appender[F] {
        override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: SimpleP.AppendMonad[M1])(
          func: SimpleP.TypeGen[M1, M2, M3, M4]
        ): M1[F[M2], F[M3], F[M4]] =
          monad.to[HList, HList, HList, F[M2], F[M3], F[M4]](
            (GetAppender.get(i): SimpleP.Appender[GetAppender.F1]).toHList(monad)(func)
          )(
            (h.from _).asInstanceOf[HList => F[M2]],
            (h.from _).asInstanceOf[HList => F[M3]],
            (h.from _).asInstanceOf[HList => F[M4]]
          )(
            (h.to _).asInstanceOf[F[M2] => HList],
            (h.to _).asInstanceOf[F[M3] => HList],
            (h.to _).asInstanceOf[F[M4] => HList]
          )

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
    type F1[_[_]] = HList

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
      simpleTo: SimpleTo[F[({ type AnyF[_] = Any })#AnyF]] with SimpleFrom[F[({ type AnyF[_] = Any })#AnyF]]
    ): AppenderFromSize[F] = self.tran(simpleTo)
  }

  def apply[F[_[_]] <: Product]: FuncInnerApply1[F] = new FuncInnerApply1[F] {
    //
  }

}
