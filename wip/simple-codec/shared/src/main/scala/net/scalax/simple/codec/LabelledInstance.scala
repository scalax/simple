package net.scalax.simple
package codec

import cats._

trait LabelledInstance[F[_[_]]] {
  def model: ContextO[F]#StringF
  def map(s: String => String): LabelledInstance[F]
}

object LabelledInstance {
  def apply[F[_[_]]]: LabelledInstanceInstanceImpl[F] = new LabelledInstanceInstanceImpl[F]

  class LabelledInstanceInstanceImpl[F[_[_]]] {
    def generic(implicit l: LabelledNames[F], u: Setter[F], g: Getter[F]): LabelledInstance[F] = new LabelledInstanceImpl[F](u, g) {
      override val model: ContextO[F]#StringF = u.input[ContextI#StringF](l.names)
    }
  }

  abstract class LabelledInstanceImpl[F[_[_]]](u: Setter[F], g: Getter[F]) extends LabelledInstance[F] {
    self1 =>
    override def model: ContextO[F]#StringF
    override def map(s: String => String): LabelledInstance[F] = new LabelledInstanceImpl[F](u, g) {
      override val model: ContextO[F]#StringF = u.input[ContextI#StringF](g.output(self1.model).asInstanceOf[List[String]].map(s))
    }
  }
}
