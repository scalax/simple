package net.scalax.simple.codec
package utils

import net.scalax.simple.codec.to_list_generic.ToDecoderGeneric2222
import ToDecoderGeneric2222.HListFuncMapGeneric

trait HListUtils[Appendable, AppendablePositive[_, _ <: Appendable] <: Appendable, AppendZero <: Appendable] {
  def appendData[Head, Tail <: Appendable](h: Head, t: Tail): AppendablePositive[Head, Tail]
  def takeHead[Head, Tail <: Appendable](dataList: AppendablePositive[Head, Tail]): Head
  def takeTail[Head, Tail <: Appendable](dataList: AppendablePositive[Head, Tail]): Tail
  def takeZero: AppendZero

  def append[T1, Source1 <: Appendable, HL1 <: Appendable, HL2 <: Appendable, HL3 <: Appendable, M1[_, _, _], M2[_], M3[_], M4[_]](
    tail: HListFuncMapGeneric[Source1, HL1, HL2, HL3, M1, M2, M3, M4]
  ): HListFuncMapGeneric[AppendablePositive[T1, Source1], AppendablePositive[M2[T1], HL1], AppendablePositive[
    M3[T1],
    HL2
  ], AppendablePositive[M4[T1], HL3], M1, M2, M3, M4] =
    new HListFuncMapGeneric[
      AppendablePositive[T1, Source1],
      AppendablePositive[M2[T1], HL1],
      AppendablePositive[M3[T1], HL2],
      AppendablePositive[M4[T1], HL3],
      M1,
      M2,
      M3,
      M4
    ] {
      override def size: Int = tail.size + 1

      override def output(o: MonadAdd[M1])(
        func: ToDecoderGeneric2222.FuncImpl[M1, M2, M3, M4]
      ): M1[AppendablePositive[M2[T1], HL1], AppendablePositive[M3[T1], HL2], AppendablePositive[M4[T1], HL3]] = {
        val tailM1: M1[HL1, HL2, HL3]                             = tail.output(o)(func)
        val headM1: M1[M2[T1], M3[T1], M4[T1]]                    = func[T1]
        val zipM: M1[(HL1, M2[T1]), (HL2, M3[T1]), (HL3, M4[T1])] = o.zip(tailM1, headM1)

        o.to(zipM)(
          in1 = t => appendData(t._2, t._1),
          in2 = t => appendData(t._2, t._1),
          in3 = t => appendData(t._2, t._1)
        )(
          in4 = t => (takeTail(t), takeHead(t)),
          in5 = t => (takeTail(t), takeHead(t)),
          in6 = t => (takeTail(t), takeHead(t))
        )
      }
    }

  def zero[M1[_, _, _], M2[_], M3[_], M4[_]]: HListFuncMapGeneric[AppendZero, AppendZero, AppendZero, AppendZero, M1, M2, M3, M4] =
    new HListFuncMapGeneric[AppendZero, AppendZero, AppendZero, AppendZero, M1, M2, M3, M4] {
      override def size: Int = 0

      override def output(o: MonadAdd[M1])(func: ToDecoderGeneric2222.FuncImpl[M1, M2, M3, M4]): M1[AppendZero, AppendZero, AppendZero] =
        o.to(o.zero)(
          _ => takeZero: AppendZero,
          _ => takeZero: AppendZero,
          _ => takeZero: AppendZero
        )(
          (_: AppendZero) => (),
          (_: AppendZero) => (),
          (_: AppendZero) => ()
        )
    }
}

object HListUtilsImpl {
  type X2[P1 <: Any, P2 <: Any]            = Any
  type X3[P1 <: Any, P2 <: Any, P3 <: Any] = Any
  type X1[P1 <: Any]                       = Any

  type AnyFuncGeneric = HListFuncMapGeneric[Any, Any, Any, Any, X3, X1, X1, X1]
  type Utils          = HListUtils[Any, X2, Any]

  private var list: List[AnyFuncGeneric] = List.empty

  def get(i: Int): AnyFuncGeneric = {
    val appender = HListFuncMapGeneric.appender.asInstanceOf[Utils]

    if (list.size <= i) {
      this.synchronized {
        while (list.size <= i) {
          if (list.isEmpty) {
            list = List(appender.zero)
          } else {
            val newModel: AnyFuncGeneric = appender.append(list.last)
            list = list ::: newModel :: List.empty
          }
        }
      }
    }

    list(i)
  }

}
