package net.scalax.simple
package codec

import fill.error.FillErrorCompat

trait NoneModelFiller[F[_[_]]] {
  def instance: ContextO[F]#NoneF
}

object NoneModelFiller {
  def fill[F[_[_]]](implicit n: Setter[F]): NoneModelFiller[F] = {
    def tryInstanceUpdate: ContextO[F]#NoneF = FillErrorCompat.fillerWithError {
      n.input[ContextI#NoneF](impl.DefaultListGetter.getUpdate)
    } match {
      case Left(e)            => throw e
      case Right(Some(model)) => model
      case Right(None)        => tryInstanceUpdate
    }

    val tryInstance: ContextO[F]#NoneF = FillErrorCompat.fillerWithError {
      n.input[ContextI#NoneF](impl.DefaultListGetter.get)
    } match {
      case Left(e)            => throw e
      case Right(Some(model)) => model
      case Right(None)        => tryInstanceUpdate
    }

    new NoneModelFiller[F] {
      override val instance: ContextO[F]#NoneF = tryInstance
    }
  }
}

package impl {
  trait ListGetter {
    def getUpdate: List[None.type]

    def get: List[None.type]
  }

  object DefaultListGetter extends ListGetter {
    private var temp: List[None.type] = List.empty

    private def update: Unit = this.synchronized {
      temp = None :: temp
    }

    override def getUpdate: List[None.type] = {
      update
      get
    }

    override def get: List[None.type] = temp
  }
}
