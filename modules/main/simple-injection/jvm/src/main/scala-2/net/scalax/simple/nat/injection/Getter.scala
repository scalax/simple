package net.scalax.simple.nat.injection

trait Getter[M[_], T] {
  def get(model: M[T]): T
  def lift(m: T): M[T]
}

object Getter {

  def gen[M[_], T](from: T => M[T], to: M[T] => T): Getter[M, T] = new Getter[M, T] {
    override def get(model: M[T]): T = to(model)
    override def lift(m: T): M[T]    = from(m)
  }

  private val innerIdentityGetter: Getter[cats.Id, Any] = gen[cats.Id, Any](identity, identity)
  implicit def identityGetter[T]: Getter[cats.Id, T]    = innerIdentityGetter.asInstanceOf[Getter[cats.Id, T]]

}
