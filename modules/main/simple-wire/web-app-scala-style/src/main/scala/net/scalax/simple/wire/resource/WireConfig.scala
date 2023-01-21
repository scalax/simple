package net.scalax.simple.wire
package resource

import doobie._
import doobie.implicits._
import cats.effect._
import doobie.hikari._
import model._

class WireConfig {

  import zio.config.magnolia.descriptor
  import zio.config.typesafe.TypesafeConfig
  import zio.{Runtime, Unsafe, ZIO}

  private val desuConfigAutomatic = descriptor[SimpleProjectConfig]
  private val layer               = TypesafeConfig.fromResourcePath(desuConfigAutomatic)
  private val desuConfigZIO       = ZIO.service[SimpleProjectConfig].provide(layer)

  private def getEffect[F[_]: Async]: F[SimpleProjectConfig] =
    Async[F].fromFuture(Sync[F].delay(Unsafe.unsafe(implicit unsafe => Runtime.default.unsafe.runToFuture(desuConfigZIO))))

  def getResource[F[_]: Async]: Resource[F, SimpleProjectConfig] = Resource.eval(getEffect)
}

object WireConfig {
  def build: WireConfig = new WireConfig
}
