package net.scalax.simple
package codec

import scala.util.Try

trait NoneModelFiller[F[_[_]]] {
  def instance: ContextO[F]#NoneF
}

object NoneModelFiller {
  def fill[F[_[_]]](implicit n: Setter[F]): NoneModelFiller[F] = {
    def tryInstanceUpdate: ContextO[F]#NoneF = try {
      n.input[ContextI#NoneF](impl.DefaultListGetter.getUpdate)
    } catch {
      case e: Throwable => tryInstanceUpdate
    }
    val tryInstance =
      try {
        n.input[ContextI#NoneF](impl.DefaultListGetter.get)
      } catch {
        case e: Throwable => tryInstanceUpdate
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
