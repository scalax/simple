package net.scalax.simple.nat.wire

import cats.effect._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import org.http4s.HttpApp
import org.http4s.server.Server
import org.http4s.implicits._
import org.http4s.ember.server._
import fs2.io.net.Network
import constructor.HttpAppToLocalServer
import constructor.AppWire

object MainApp extends IOApp:

  given AppWire = new AppWire

  given (using route: AppWire): HttpApp[IO] = route.routes.orNotFound

  override def run(args: List[String]): IO[ExitCode] = new HttpAppToLocalServer[IO].server.build.use(_ => IO.never).as(ExitCode.Success)

end MainApp
