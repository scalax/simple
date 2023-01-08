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

class AppWire(txa: EnvA[Transactor[IO]], txb: EnvB[Transactor[IO]]) {

  private lazy val serviceA: Id[ServiceA] = wire[ServiceAImpl[Id, EnvA]]
  private lazy val serviceB: ServiceB     = wire[ServiceBImpl[Id, EnvB]]

  private lazy val serviceAImpl: () => Id[ServiceA] = () => serviceA
  private lazy val serviceBImpl: () => Id[ServiceB] = () => serviceB

  private lazy val natRoutesInstances: NatHttpRoutes = wire[NatHttpRoutesImpl[Id]]

  lazy val routes: HttpRoutes[IO] = natRoutesInstances.route

}

object AppWire {

  val build: Resource[IO, HttpRoutes[IO]] = {
    val xa1 = for (xaImpl <- (new EnvAH2Doobie).resource) yield EnvA(xaImpl)
    val xa2 = for (xaImpl <- (new EnvBH2Doobie).resource) yield EnvB(xaImpl)

    for {
      evaXa <- xa1
      evbXa <- xa2
    } yield wire[AppWire].routes
  }

}
