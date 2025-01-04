package net.scalax.simple.codec
package to_list_generic

import shapeless._
import utils._

import scala.collection.compat._

trait AppenderFromSize[F[_[_]]] {
  self =>

  def inputModelSize(modelSize: Int): SimpleProduct3.NotHList.Appender[F]
  def inputModelSizeF(modelSize: ModelSize[F]): SimpleProduct3.NotHList.Appender[F] = self.inputModelSize(modelSize.modelSize)
}

object AppenderFromSize {
  self =>

  private def tran[F[_[_]]](h: SimpleFrom[F[({ type FX[_] = Any })#FX]] with SimpleTo[F[({ type FX[_] = Any })#FX]]): AppenderFromSize[F] =
    new AppenderFromSize[F] {
      override def inputModelSize(i: Int): SimpleProduct3.NotHList.FromOtherAppender[GetAppender.F1, F] =
        new SimpleProduct3.NotHList.FromOtherAppender[GetAppender.F1, F] {
          override def fromModel[X[_]](f: GetAppender.F1[X]): F[X]                 = h.from(f).asInstanceOf[F[X]]
          override def toModel[X[_]](g: F[X]): GetAppender.F1[X]                   = h.to(g.asInstanceOf[F[({ type FX[_] = Any })#FX]])
          override def appenderF: SimpleProduct3.NotHList.Appender[GetAppender.F1] = GetAppender.get(i)
        }
    }

  val appender: SimpleProduct3.AppendContext[HList, HNil, ({ type Ad[Head, TU <: HList] = Head :: TU })#Ad] =
    new SimpleProduct3.AppendContext[HList, HNil, ({ type Ad[Head, TU <: HList] = Head :: TU })#Ad] {
      override def append[Head, Tail <: HList](h: Head, t: Tail): Head :: Tail = h :: t
      override def takeHead[Head, Tail <: HList](dataList: Head :: Tail): Head = dataList.head
      override def takeTail[Head, Tail <: HList](dataList: Head :: Tail): Tail = dataList.tail
      override val zero: HNil                                                  = HNil
    }

  object GetAppender {
    type F1[_[_]] = HList

    def get(i: Int): SimpleProduct3.NotHList.Appender[F1] = {
      if (i >= appenderList.size) {
        this.synchronized {
          while (i >= appenderList.size) {
            if (appenderList.headOption.isDefined) {
              val cutHead = appenderList.head.asInstanceOf[appender.HListLikeAppender[appender.ColType]]

              val newItem = new appender.PositiveHListLikeAppender[Any, appender.ColType] {
                override def tailHListLikeAppender: appender.HListLikeAppender[appender.ColType] = cutHead
              }

              appenderList = newItem.asInstanceOf[SimpleProduct3.NotHList.Appender[F1]] :: appenderList
            } else {
              appenderList = List(appender.ZeroHListLikeAppender.asInstanceOf[SimpleProduct3.NotHList.Appender[F1]])
            }
          }

          appenderArray = appenderList.reverse.to(Array)
        }
      }

      appenderArray(i)
    }

    private var appenderList: List[SimpleProduct3.NotHList.Appender[F1]]   = List.empty
    private var appenderArray: Array[SimpleProduct3.NotHList.Appender[F1]] = Array.empty
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
