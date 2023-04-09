package net.scalax.simple
package codec

trait LabelledInstance[F[_[_]]] {
  def model: ContextO[F]#StringF
  def map(s: String => String): LabelledInstance[F]
  def concat(other: ContextO[F]#StringF): LabelledInstance[F]
}

object LabelledInstance {
  def apply[F[_[_]]]: LabelledInstanceInstanceImpl[F] = new LabelledInstanceInstanceImpl[F]

  class LabelledInstanceInstanceImpl[F[_[_]]] {
    def generic(implicit l: LabelledNames[F], u: Setter[F], g: Getter[F]): LabelledInstance[F] = {
      val model = u.input[ContextI#StringF](l.names)
      new LabelledInstanceImpl[F](u, g, model)
    }
  }

  class LabelledInstanceImpl[F[_[_]]](u: Setter[F], g: Getter[F], override val model: ContextO[F]#StringF) extends LabelledInstance[F] {
    override def map(s: String => String): LabelledInstance[F] = {
      val list1                         = g.output[ContextI#StringF](model).asInstanceOf[List[String]]
      val list2                         = list1.map(s)
      val newModel: ContextO[F]#StringF = u.input[ContextI#StringF](list2)
      new LabelledInstanceImpl[F](u, g, newModel)
    }
    override def concat(other: ContextO[F]#StringF): LabelledInstance[F] = {
      val list1                         = g.output[ContextI#StringF](model).asInstanceOf[List[String]]
      val list2                         = g.output[ContextI#StringF](other).asInstanceOf[List[String]]
      val list3                         = list1.zip(list2).map(t => t._1 + t._2)
      val newModel: ContextO[F]#StringF = u.input[ContextI#StringF](list3)
      new LabelledInstanceImpl[F](u, g, newModel)
    }
  }
}
