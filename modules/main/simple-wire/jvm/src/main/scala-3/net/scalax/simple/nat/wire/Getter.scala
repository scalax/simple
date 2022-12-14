package net.scalax.simple.nat.wire

trait Getter[M[_]]:
  def get[T](model: M[T]): T
  def lift[T](m: T): M[T]
end Getter

object Getter:

  def apply[M[_]: Getter]: Getter[M] = summon

  private val innerIdentityGetter: Getter[cats.Id] = new Getter[cats.Id]:
    override def get[T](model: T): T = model
    override def lift[T](m: T): T    = m
  end innerIdentityGetter

  inline given Getter[cats.Id] = innerIdentityGetter

end Getter
