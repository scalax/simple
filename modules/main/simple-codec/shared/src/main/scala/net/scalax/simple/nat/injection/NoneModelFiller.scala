package net.scalax.simple
package codec

import scala.util.Try

trait NoneModelFiller[F[_[_]]] {
  def instance: F[({ type X[_] = None.type })#X]
}

object NoneModelFiller {
  def fill[F[_[_]]](n: Filler[F]): NoneModelFiller[F] = {
    var tryInstance: Try[F[({ type X[_] = None.type })#X]] = Try {
      n.input[({ type X[_] = None.type })#X](impl.DefaultListGetter.get)
    }
    while (tryInstance.isFailure) {
      tryInstance = Try {
        n.input[({ type X[_] = None.type })#X](impl.DefaultListGetter.getUpdate)
      }
    }
    val model = tryInstance.get
    new NoneModelFiller[F] {
      override val instance: F[({ type X[_] = None.type })#X] = model
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
