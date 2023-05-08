package net.scalax.simple.adt.implemention

trait CoProductContext[Result] {

  sealed trait Func

  sealed trait Positive[Data, +T <: Func] extends Func {
    def foldImpl(d: Data => Result): T
  }

  sealed trait Zero extends Func {
    def default(d: => Result): Result
    def option: Option[Result]
  }

  class LeftFunc[Data, +T <: Func](val tail: T) extends Positive[Data, T] {
    override def foldImpl(d: Data => Result): T = tail
  }

  class RightFunc[Data, Data2, +T <: Func](val data: Data) extends Positive[Data, Positive[Data2, T] with Zero] {
    override def foldImpl(d: Data => Result): Positive[Data2, T] with Zero = new EndFunc[Data2, T](d(data))
  }

  class EndFunc[Data, +T <: Func](val result: Result) extends Positive[Data, T] with Zero {
    override def foldImpl(d: Data => Result): T = this.asInstanceOf[T]
    override def default(d: => Result): Result  = result
    override def option: Some[Result]           = Some(result)
  }

  class EmptyEnd extends Zero {
    override def default(d: => Result): Result = d
    override def option: None.type             = None
  }

  object builder {
    def appendSuccess[Data, Data2, T <: Func](data: Data): Positive[Data, Positive[Data2, T]] with Positive[Data, Zero] =
      new RightFunc[Data, Data2, T](data)
    def appendFailed[Data, T <: Func](tail: T): Positive[Data, T] = new LeftFunc[Data, T](tail)
    def end: Func                                                 = new EmptyEnd
  }

}

object CoProductContext {
  private object CoProductContext extends CoProductContext[Any]
  def build[T]: CoProductContext[T] = CoProductContext.asInstanceOf[CoProductContext[T]]
}

object Test extends App {

  val c = CoProductContext.build[List[Int]]

  type Ux1 = c.Positive[Int, c.Positive[List[String], c.Positive[List[Long], c.Positive[List[String], c.Zero]]]]
  type Ux2 = c.Positive[Int, c.Positive[List[String], c.Positive[List[Long], c.Zero]]]

  val builder = c.builder

  val p: Ux1  = builder.appendFailed(builder.appendFailed(builder.appendSuccess(List(2L, 3L, 5L, 8L))))
  val p2: Ux2 = builder.appendFailed(builder.appendFailed(builder.appendSuccess(List(2L, 3L, 5L, 8L))))

  val t =
    p.foldImpl(t => List(t)).foldImpl(t => t.map(_.size + 1)).foldImpl(t => t.map(_.toInt * 2)).foldImpl(t => t.map(_.size * 5)).option
  val t2 = p2.foldImpl(t => List(t)).foldImpl(t => t.map(_.size + 1)).foldImpl(t => t.map(_.toInt * 2)).option

  println(t)
  println(t2)

}
