package net.scalax.simple.codec
package to_list_generic

object AppenderFromSize {

  def tran[F[_[_]]](from: GenericAuxFrom[F], to: GenericAuxTo[F], modelSize: ModelSize[F]): SimpleProductX[F] =
    ??? /*new SimpleProductX[F] {
    override val model: SimpleProductXImpl2.NotHList.Appender[F] = new SimpleProductXImpl2.NotHList.FromOtherAppender[GetAppender.F1, F] {
      override def fromModel[X[_]](f: GetAppender.F1[X]): F[X] = from.fromModel(f).asInstanceOf[F[X]]
      override def toModel[X[_]](g: F[X]): GetAppender.F1[X] =
        to.toModel(g.asInstanceOf[F[({ type FX[_] = Any })#FX]]).asInstanceOf[GetAppender.F1[X]]
      override def appenderF: SimpleProductXImpl.NotHList.Appender[GetAppender.F1] = GetAppender.get(modelSize.modelSize)
    }
  }*/

  val appender: SimpleProductXImpl2.AppendContext[Tuple, EmptyTuple, ({ type Ad[Head, TU <: Tuple] = Head *: TU })#Ad] =
    new SimpleProductXImpl2.AppendContext[Tuple, EmptyTuple, ({ type Ad[Head, TU <: Tuple] = Head *: TU })#Ad] {
      override def append[H, T <: Tuple](h: H, t: T): H *: T = h *: t
      override def unappendHead[H, T <: Tuple](a: H *: T): H = a.head
      override def unappendTail[H, T <: Tuple](a: H *: T): T = a.tail
      override def zero: EmptyTuple                          = EmptyTuple
    }

  object GetAppender {
    type F1[_[_]] = Tuple

    def get(i: Int): SimpleProductXImpl2.NotHList.Appender[F1] = {
      /*if (i >= appenderList.size) {
        this.synchronized {
          while (i >= appenderList.size) {
            if (appenderList.headOption.isDefined) {
              val cutHead = appenderList.head
                .asInstanceOf[appender.HListLikeAppender[appender.ColType.TakeTail[appender.AppendColType[Any, appender.ColType]]]]

              val newItem = new appender.PositiveHListLikeAppender[Any, appender.ColType] {
                override val tailHListLikeAppender
                  : appender.HListLikeAppender[appender.ColType.TakeTail[appender.AppendColType[Any, appender.ColType]]] = cutHead
              }

              appenderList = newItem.asInstanceOf[SimpleProductXImpl.NotHList.Appender[F1]] :: appenderList
            } else {
              appenderList = List(appender.ZeroHListLikeAppender.value.asInstanceOf[SimpleProductXImpl.NotHList.Appender[F1]])
            }
          }

          appenderArray = appenderList.reverse.to(Array)
        }
      }*/

      appenderArray(i)
    }

    private var appenderList: List[SimpleProductXImpl2.NotHList.Appender[F1]]   = List.empty
    private var appenderArray: Array[SimpleProductXImpl2.NotHList.Appender[F1]] = Array.empty
  }

}
