package net.scalax.simple.codec
package to_list_generic

trait PojoInstance[U[_], Model] {
  def instance: Any
}

object PojoInstance {
  import scala.deriving.Mirror
  import shapeless3.deriving.*

  def instance[U[_], Model](n: Any): PojoInstance[U, Model] = new PojoInstance[U, Model] {
    override val instance: Any = n
  }

  inline def derived[U[_], Model](using
    g: Mirror.ProductOf[Model],
    inst: K0.ProductInstances[FillIdentity, Tuple.Map[g.MirroredElemTypes, U]]
  ): PojoInstance[U, Model] = {
    val fillIdentity: FillIdentity[Tuple.Map[g.MirroredElemTypes, U]] = FillIdentity.monoidGen[Tuple.Map[g.MirroredElemTypes, U]]

    new PojoInstance[U, Model] {
      override val instance: Any = fillIdentity.value
    }
  }

}
