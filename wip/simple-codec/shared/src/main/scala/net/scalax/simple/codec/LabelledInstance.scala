package net.scalax.simple
package codec

trait LabelledInstance[F[_[_]]] {
  def model: ContextO[F]#StringF
}

object LabelledInstance {
  def apply[F[_[_]]]: LabelledInstanceImpl[F] = new LabelledInstanceImpl[F]

  class LabelledInstanceImpl[F[_[_]]] {
    def generic(implicit l: LabelledNames[F], u: Setter[F]): LabelledInstance[F] = new LabelledInstance[F] {
      override val model: ContextO[F]#StringF = u.input[ContextI#StringF](l.names)
    }
  }
}
