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

  private val httpAppIO                            = for app <- AppWire.build yield app.orNotFound
  private val serverIO                             = for given HttpApp[IO] <- httpAppIO yield new HttpAppToLocalServer[IO].server.build
  private val serverResource: Resource[IO, Server] = for i1 <- Resource.eval(serverIO); i2 <- i1 yield i2

  override def run(args: List[String]): IO[ExitCode] = serverResource.use(_ => IO.never).as(ExitCode.Success)

end MainApp
