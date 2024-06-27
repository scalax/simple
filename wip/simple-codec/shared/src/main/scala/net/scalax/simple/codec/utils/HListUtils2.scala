package net.scalax.simple.codec.utils

import net.scalax.simple.codec.to_list_generic.SimpleProduct

trait HListUtils2[Appendable, AppendablePositive[_, _ <: Appendable] <: Appendable, AppendZero <: Appendable] {
  def appendData[Head, Tail <: Appendable](h: Head, t: Tail): AppendablePositive[Head, Tail]
  def takeHead[Head, Tail <: Appendable](dataList: AppendablePositive[Head, Tail]): Head
  def takeTail[Head, Tail <: Appendable](dataList: AppendablePositive[Head, Tail]): Tail
  def takeZero: AppendZero

  def append[T1, Source1 <: Appendable, HL1[_[_]] <: Appendable](
    tail: SimpleProduct.Appender.HighFuncMapGeneric[Source1, HL1]
  ): SimpleProduct.Appender.HighFuncMapGeneric[AppendablePositive[
    T1,
    Source1
  ], ({ type HA[UA[_]] = AppendablePositive[UA[T1], HL1[UA]] })#HA] =
    new SimpleProduct.Appender.HighFuncMapGeneric[AppendablePositive[
      T1,
      Source1
    ], ({ type HA[UA[_]] = AppendablePositive[UA[T1], HL1[UA]] })#HA] {
      override val size: Int = tail.size + 1

      override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](o: SimpleProduct.AppendMonad[M1])(
        func: SimpleProduct.TypeGen[M1, M2, M3, M4]
      ): M1[AppendablePositive[M2[T1], HL1[M2]], AppendablePositive[M3[T1], HL1[M3]], AppendablePositive[M4[T1], HL1[M4]]] = {
        val tailM1: M1[HL1[M2], HL1[M3], HL1[M4]]                             = tail.toHList(o)(func)
        val headM1: M1[M2[T1], M3[T1], M4[T1]]                                = func[T1]
        val zipM: M1[(HL1[M2], M2[T1]), (HL1[M3], M3[T1]), (HL1[M4], M4[T1])] = o.zip(tailM1, headM1)

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

  val zero: SimpleProduct.Appender.HighFuncMapGeneric[AppendZero, ({ type HA[_[_]] = AppendZero })#HA] =
    new SimpleProduct.Appender.HighFuncMapGeneric[AppendZero, ({ type HA[_[_]] = AppendZero })#HA] {
      override val size: Int = 0

      override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](
        o: SimpleProduct.AppendMonad[M1]
      )(func: SimpleProduct.TypeGen[M1, M2, M3, M4]): M1[AppendZero, AppendZero, AppendZero] =
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
