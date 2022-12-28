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

class AppWire(implicit txa: EnvA[Transactor[IO]], txb: EnvB[Transactor[IO]]) {

  private implicit val sa: ServiceA   = new ServiceAImpl[Id, EnvA](() => serviceB)
  private lazy val serviceB: ServiceB = new ServiceBImpl[Id, EnvB](() => implicitly)

  private lazy val natRoutesInstances: NatHttpRoutes = new NatHttpRoutesImpl[Id]

  lazy val routes: HttpRoutes[IO] = natRoutesInstances.route

}

object AppWire {

  val build: Resource[IO, HttpRoutes[IO]] = {
    val xa1 = for (xaImpl <- (new EnvAH2Doobie).resource) yield EnvA(xaImpl)
    val xa2 = for (xaImpl <- (new EnvBH2Doobie).resource) yield EnvB(xaImpl)

    for {
      evaXa <- xa1
      evbXa <- xa2
    } yield {
      implicit val i1 = evaXa
      implicit val i2 = evbXa
      (new AppWire).routes
    }
  }

}
