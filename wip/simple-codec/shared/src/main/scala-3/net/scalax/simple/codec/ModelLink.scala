package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.SimpleProductContextX

trait ModelLink[F[_[_]], Model]
    extends BasedInstalledSimpleProduct[F]
    with BasedInstalledLabelled[F]
    with BasedInstalledModelSized[F]
    with ModelGet[F, Model]
    with ModelSet[F, Model]

object ModelLink {

  import scala.deriving.Mirror

  def buildUtilImplCommonF[FMM[_[_]]](cNamed: Any, fromTuple: Any => FMM[[_] =>> Any]): ModelLinkCommonF[FMM] = new ModelLinkCommonF[FMM] {
    override val compatNamed: Any                    = cNamed
    override def FToInstance[T[_]](x: FMM[T]): Any   = Tuple.fromProduct(x.asInstanceOf)
    override def FFromInstance[T[_]](x: Any): FMM[T] = fromTuple(x).asInstanceOf[FMM[T]]
  }

  class BuilderCommonF[FMM[_[_]]] {
    inline def implicitly(using x: ModelLink[FMM, FMM[({ type IDF[T] = T })#IDF]]): ModelLink[FMM, FMM[({ type IDF[T] = T })#IDF]] = x

    inline def derived(using g: Mirror.ProductOf[FMM[({ type U1[_] = Any })#U1]]): ModelLink.F[FMM] = {
      val namedModel = scala.compiletime.constValueTuple[g.MirroredElemLabels]
      buildUtilImplCommonF(namedModel, g.fromTuple.asInstanceOf[Any => FMM[[_] =>> Any]])
    }
  }

  object F {
    def apply[FMM[_[_]]]: BuilderCommonF[FMM] = new BuilderCommonF[FMM]
  }
  type F[FModel[_[_]]] = ModelLink[FModel, FModel[({ type IDF[T] = T })#IDF]]

}
