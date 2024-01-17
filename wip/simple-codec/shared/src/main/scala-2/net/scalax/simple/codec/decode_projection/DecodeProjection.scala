package net.scalax.simple.codec
package decode.projection

trait TypeHList[F[_[_]]] {
  type Head[_]
  type Tail <: TypeHList[F]
}

trait ZeroInstance
object ZeroInstance {
  val instance: ZeroInstance = new ZeroInstance {
    //
  }
}

trait ZeroTypeHList[F[_[_]]] extends TypeHList[F] {
  override type Head[_] = ZeroInstance
  override type Tail    = ZeroTypeHList[F]
}

trait InstanceHList[F[_[_]], T <: TypeHList[F]] {
  def head[X]: T#Head[X]
  def tail: InstanceHList[F, T#Tail]
}

trait InstanceZeroHList[F[_[_]]] extends InstanceHList[F, ZeroTypeHList[F]] {
  override def head[X]: ZeroInstance = ZeroInstance.instance
  override def tail: InstanceZeroHList[F]
}

object InstanceZeroHList {
  self =>

  def instance[F[_[_]]]: InstanceZeroHList[F] = new InstanceZeroHList[F] {
    override def tail: InstanceZeroHList[F] = self.instance[F]
  }
}

trait DeptProjectionM[M1[_ <: TypeHList[F]], F[_[_]]] {
  def input[T <: TypeHList[F]](monad: InstanceHList[F, T]): M1[T]
}
