package net.scalax.simple.wire

import cats.effect._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import org.http4s.HttpApp
import org.http4s.server.Server
import org.http4s.implicits._
import org.http4s.ember.server._
import com.comcast.ip4s._
import fs2.io.net.Network
import constructor.AppWire

object MainApp extends IOApp:

  private val serverResource: Resource[IO, Server] = for
    app    <- AppWire.build
    server <- EmberServerBuilder.default[IO].withHttpApp(app.orNotFound).withHost(ipv4"0.0.0.0").withPort(port"8080").build
  yield server
  end serverResource

  override def run(args: List[String]): IO[ExitCode] = serverResource.use(_ => IO.never).as(ExitCode.Success)

end MainApp
