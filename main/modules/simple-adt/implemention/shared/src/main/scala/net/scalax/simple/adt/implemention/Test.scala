package net.scalax.simple.adt.implemention

trait CoProductContext[Result] {

  trait NatFunc
  trait NatFuncPositive[Data, T <: NatFunc] extends NatFunc {
    def foldImpl(d: Data => Result): T
  }
  trait NatFuncZero extends NatFunc {
    def default(d: => Result): Result
    def option: Option[Result]
  }

  trait InputFunc[T <: NatFunc] {
    def input(r: Result): T
  }
  case class InputPositive[Data, T <: NatFunc](tail: InputFunc[T]) extends InputFunc[NatFuncPositive[Data, T]] {
    override def input(r: Result): NatFuncPositive[Data, T] = utils.EndFunc(r, tail)
  }
  case object InputZero extends InputFunc[NatFuncZero] {
    override def input(r: Result): ZeroSuccessed = ZeroSuccessed(r)
  }

  case class LeftFunc[Data, T <: NatFunc](val tail: T) extends NatFuncPositive[Data, T] {
    override def foldImpl(d: Data => Result): T = tail
  }
  case class RightFunc[Data, T <: NatFunc](data: Data, tail: InputFunc[T]) extends NatFuncPositive[Data, T] {
    override def foldImpl(d: Data => Result): T = tail.input(d(data))
  }
  case object ZeroFailed extends NatFuncZero {
    override def default(d: => Result): Result = d
    override val option: None.type             = None
  }
  case class ZeroSuccessed(resultData: Result) extends NatFuncZero {
    override def default(d: => Result): Result = resultData
    override val option: Some[Result]          = Some(resultData)
  }

  private object utils {
    case class EndFunc[Data, T <: NatFunc](result: Result, tail: InputFunc[T]) extends NatFuncPositive[Data, T] {
      override def foldImpl(d: Data => Result): T = tail.input(result)
    }
  }

}

object CoProductContext {
  class Co[T] extends CoProductContext[T]
  def build[T]: CoProductContext[T] = new Co[T]
}

object Test extends App {

  val c = CoProductContext.build[List[Int]]

  type Ux1 =
    c.NatFuncPositive[Int, c.NatFuncPositive[
      List[String],
      c.NatFuncPositive[List[Long], c.NatFuncPositive[List[String], c.NatFuncPositive[String, c.NatFuncZero]]]
    ]]
  type Ux2 =
    c.NatFuncPositive[Int, c.NatFuncPositive[List[String], c.NatFuncPositive[List[Long], c.NatFuncPositive[List[String], c.NatFuncZero]]]]
  type Ux3 = c.NatFuncPositive[Int, c.NatFuncPositive[List[String], c.NatFuncPositive[List[Long], c.NatFuncZero]]]

  val p1: Ux1 = c.LeftFunc(c.LeftFunc(c.RightFunc(List(2L, 3L, 5L, 8L), c.InputPositive(c.InputPositive(c.InputZero)))))
  val p2: Ux2 = c.LeftFunc(c.LeftFunc(c.RightFunc(List(2L, 3L, 5L, 8L), c.InputPositive(c.InputZero))))
  val p3: Ux3 = c.LeftFunc(c.LeftFunc(c.RightFunc(List(2L, 3L, 5L, 8L), c.InputZero)))
  val p4: Ux2 = c.LeftFunc(c.LeftFunc(c.LeftFunc(c.LeftFunc(c.ZeroFailed))))

  val t1 =
    p1.foldImpl(t => List(t))
      .foldImpl(t => t.map(_.size + 1))
      .foldImpl(t => t.map(_.toInt * 2))
      .foldImpl(t => t.map(_.size * 5))
      .foldImpl(t => t.to(List).map(_.toInt * 2))
      .option
  val t2 =
    p2.foldImpl(t => List(t)).foldImpl(t => t.map(_.size + 1)).foldImpl(t => t.map(_.toInt * 2)).foldImpl(t => t.map(_.size * 5)).option
  val t3 = p3.foldImpl(t => List(t)).foldImpl(t => t.map(_.size + 1)).foldImpl(t => t.map(_.toInt * 2)).option
  val t4 =
    p4.foldImpl(t => List(t)).foldImpl(t => t.map(_.size + 1)).foldImpl(t => t.map(_.toInt * 2)).foldImpl(t => t.map(_.size * 5)).option

  println(t1) // Some(List(4, 6, 10, 16))
  println(t2) // Some(List(4, 6, 10, 16))
  println(t3) // Some(List(4, 6, 10, 16))
  println(t4) // None

}
