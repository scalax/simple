package net.scalax.simple.codec
package decode.projection

trait TypeHList {
  type TypeHead[_]
  type TypeTail <: TypeHList
}

trait ZeroInstance
object ZeroInstance {
  val instance: ZeroInstance = new ZeroInstance {
    //
  }
}

trait ZeroTypeHList extends TypeHList {
  override type TypeHead[_] = ZeroInstance
  override type TypeTail    = ZeroTypeHList
}

trait InstanceHList[T <: TypeHList] {
  def typeHead[X]: T#TypeHead[X]
  def typeTail: InstanceHList[T#TypeTail]
}

trait InstanceZeroHList extends InstanceHList[ZeroTypeHList] {
  override def typeHead[X]: ZeroInstance = ZeroInstance.instance
  override def typeTail: InstanceZeroHList
}

object InstanceZeroHList {
  self =>

  lazy val instance: InstanceZeroHList = new InstanceZeroHList {
    override lazy val typeTail: InstanceZeroHList = self.instance
  }
}

trait DeptProjectionM[M1[_ <: TypeHList]] {
  def input[T <: TypeHList](monad: InstanceHList[T]): M1[T]
}
