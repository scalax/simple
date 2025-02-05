package net.scalax.simple.codec
package to_list_generic

trait BasedInstalled[F[_[_]]] {
  def basedInstalled: SimpleProductX[F]
  def labelled: ModelLabelled[F]
  def size: ModelSize[F]
  def simpleProduct1: SimpleProduct1.Appender[F]                    = SimpleProduct1[F].derived(basedInstalled)
  def fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[F] = FromListByTheSameTypeGeneric[F].derived(simpleProduct1)
}
