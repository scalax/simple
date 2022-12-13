package net.scalax.simple.nat.wire.constructor

import cats.effect._
import org.http4s.HttpApp
import org.http4s.ember.server.EmberServerBuilder
import fs2.io.net.Network

trait HttpAppToServer[F[_]: Async: Network](using HttpApp[F]):
  val httpApp: HttpApp[F]           = summon
  def server: EmberServerBuilder[F] = EmberServerBuilder.default[F].withHttpApp(httpApp)
end HttpAppToServer

import com.comcast.ip4s._

class HttpAppToLocalServer[F[_]: Async: Network](using HttpApp[F]) extends HttpAppToServer[F]:
  override def server: EmberServerBuilder[F] = super.server.withHost(ipv4"0.0.0.0").withPort(port"8080")
end HttpAppToLocalServer
