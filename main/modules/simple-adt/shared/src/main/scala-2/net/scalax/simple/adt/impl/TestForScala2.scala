package net.scalax.simple.adt.impl

trait TestForScala2 {

  trait Abc[PI, Append[_, _ <: PI] <: PI, Zero <: PI] {
    type AB[I1, I2, I3, I4] = Append[I1, Append[I2, Append[I3, Append[I4, Zero]]]]
    def abc[I1, I2, I3, I4]: AB[I1, I2, I3, I4] = ???
  }

  trait PPAP1

  trait Positive2[Data, Tail[_] <: Any, Result] extends PPAP1 {
    def apply[TD >: Result](f: Data => TD): Tail[TD]
  }

  trait Func {
    type U[A] <: Any
    def instance: U[Nothing]
  }
  trait Append11[Data, Tail <: Func] extends Func {
    override type U[A] = Positive2[Data, Tail#U, A]
  }
  trait Zero extends Func {
    override type U[A] = A
  }

  val CC: Abc[Func, ({ type AP[A, B <: Func] = Append11[A, B] })#AP, Zero] = ???

  val dd = CC.abc[List[String], Long, Option[Int], BigDecimal].instance

  locally {
    val ee      = dd(t => t.map(_.size).sum)(t => t.toInt + 1)(t => t.getOrElse(55))(t => t.toInt)
    val ff: Int = ee
  }

}
