package net.scalax.simple.nat.wire

trait Getter[M[_], T]:
  def get(model: M[T]): T
  def lift(m: T): M[T]
end Getter

object Getter:

  def gen[M[_], T](from: T => M[T], to: M[T] => T): Getter[M, T] =
    new Getter[M, T]:
      override def get(model: M[T]): T = to(model)
      override def lift(m: T): M[T]    = from(m)
  end gen

  private val innerIdentityGetter: Getter[cats.Id, Any] = gen[cats.Id, Any](identity, identity)
  inline given [T]: Getter[cats.Id, T]                  = innerIdentityGetter.asInstanceOf[Getter[cats.Id, T]]

end Getter