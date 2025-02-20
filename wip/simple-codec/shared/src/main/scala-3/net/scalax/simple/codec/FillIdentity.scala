package net.scalax.simple.codec
package to_list_generic

trait FillIdentity[T] {
  def value: T
}

object FillIdentity:
  import shapeless3.deriving.*

  given [A1](using a: => A1): FillIdentity[A1] with {
    override def value: A1 = a
  }

  given monoidGen[A2](using inst: K0.ProductInstances[FillIdentity, A2]): FillIdentity[A2] with {
    override def value: A2 = inst.construct([t] => (ma: FillIdentity[t]) => ma.value)
  }

  final class Builder[T] {
    inline def derived(using generic: K0.ProductGeneric[T]): T = {
      val fillIdentity: FillIdentity[T] = monoidGen[T]
      fillIdentity.value
    }
  }

  def apply[T]: Builder[T] = new Builder

end FillIdentity
