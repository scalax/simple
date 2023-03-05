package net.scalax.simple
package codec

// import shapeless._

trait LabelledNames[F[_[_]]] {
  def names: List[String]
}
object LabelledNames {
  def apply[F[_[_]]](i: Int): ModelLength[F] = new ModelLength[F] {
    override val length: Int = i
  }

  /*def init[F[_[_]]](implicit u: impl.LabelledNamesImpl[ContextO[F]#NoneF]): LabelledNames[F] = new LabelledNames[F] {
    override def names: List[String] = u.names
  }*/
}

/*package impl {

  import shapeless.labelled.FieldType

  trait LabelledNamesImpl[T] {
    def names: List[String]
  }

  object LabelledNamesImpl {

    implicit val showHNil: LabelledNamesImpl[HNil] = new LabelledNamesImpl[HNil] {
      override def names: List[String] = List.empty
    }

    implicit def showHCons[K <: Symbol, V, T <: HList](implicit
      key: Witness.Aux[K],
      tail: LabelledNamesImpl[T]
    ): LabelledNamesImpl[FieldType[K, V] :: T] = new LabelledNamesImpl[FieldType[K, V] :: T] {
      override def names: List[String] = key.value.name :: tail.names
    }

    implicit def get[T, H](implicit x: LabelledGeneric.Aux[T, H], t: LabelledNamesImpl[H]): LabelledNamesImpl[T] = {

      new LabelledNamesImpl[T] {
        override def names: List[String] = t.names
      }
    }

  }
}*/
