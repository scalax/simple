package net.scalax.simple.adt.impl

trait TestForScala2 {

  trait Abc[PI, Append[_, _ <: PI] <: PI, Zero <: PI] {
    type AB[I1, I2, I3, I4] = Append[I1, Append[I2, Append[I3, Append[I4, Zero]]]]
    def abc[I1, I2, I3, I4]: AB[I1, I2, I3, I4] = ???
  }

  trait PPAP1

  trait Positive2[Data, Tail[_] <: PPAP1, Result] extends PPAP1 {
    def folddd[TD >: Result](f: Data => TD): Tail[TD]
    def apply[TD >: Result](f: Data => TD): Tail[TD]
  }

  trait PZero3[Result] extends PPAP1 {
    def value: Result
  }

  trait Func[U[_] <: PPAP1] {
    def instance: U[Nothing]
  }
  trait Append11[Data, U[_] <: PPAP1] extends Func[[x] =>> Positive2[Data, U, x]]
  trait Zero                          extends Func[[x] =>> PZero3[x]]

  type MatchAppend[Data, f <: Func[_]] = f match {
    case Func[u1] => Append11[Data, u1]
  }

  val CC: Abc[Func[_], [A, B <: Func[_]] =>> MatchAppend[A, B], Zero] = ???

  val dd = CC.abc[List[String], Long, Option[Int], BigDecimal].instance

  locally {
    val ee      = dd(t => t.map(_.size).sum)(t => t.toInt + 1)(t => t.getOrElse(55))(t => t.toInt)
    val ff: Int = ee.value
  }

  locally {
    val ee      = dd.folddd(t => t.map(_.size).sum).folddd(t => t.toInt + 1).folddd(t => t.getOrElse(55)).folddd(t => t.toInt)
    val ff: Int = ee.value
  }

}
