package net.scalax.simple.wire
package constructor

import service._
import routes.{NatHttpRoutes, NatHttpRoutesImpl}
import org.http4s.HttpRoutes
import cats.effect._
import doobie._
import env._
import resource._
import cats._

import com.softwaremill.macwire._

class AppWire[WireEnvA[_]: Wire, WireEnvB[_]: Wire](txa: WireEnvA[Transactor[IO]], txb: WireEnvB[Transactor[IO]]) {

  private lazy val serviceA: Id[ServiceA] = wire[ServiceAImpl[Id, WireEnvA]]
  private lazy val serviceB: Id[ServiceB] = wire[ServiceBImpl[Id, WireEnvB]]

  private def serviceFunc[T](a: => Id[T]): () => Id[T] = () => a

  private lazy val serviceAImpl: () => Id[ServiceA] = wireWith(serviceFunc[ServiceA] _)
  private lazy val serviceBImpl: () => Id[ServiceB] = wireWith(serviceFunc[ServiceB] _)

  private lazy val natRoutesInstances: NatHttpRoutes = wire[NatHttpRoutesImpl[Id]]

  lazy val routes: HttpRoutes[IO] = natRoutesInstances.route

}

object AppWire {

  val build: Resource[IO, HttpRoutes[IO]] = {
    val xa1 = wire[EnvAH2Doobie].resourceEnvA
    val xa2 = wire[EnvBH2Doobie].resourceEnvB

    for {
      evaXa <- xa1
      evbXa <- xa2
    } yield wire[AppWire[EnvA, EnvB]].routes
  }

}
