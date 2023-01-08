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

class AppWire[WireA[_]: Wire, WireB[_]: Wire](txa: WireA[Transactor[IO]], txb: WireB[Transactor[IO]]) {

  private lazy val serviceA: Id[ServiceA] = wire[ServiceAImpl[Id, WireA]]
  private lazy val serviceB: Id[ServiceB] = wire[ServiceBImpl[Id, WireB]]

  private def serviceAFunc(a: => Id[ServiceA]): () => Id[ServiceA] = () => a
  private def serviceBFunc(b: => Id[ServiceB]): () => Id[ServiceB] = () => b
  private lazy val serviceAImpl: () => Id[ServiceA]                = wireWith(serviceAFunc _)
  private lazy val serviceBImpl: () => Id[ServiceB]                = wireWith(serviceBFunc _)

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
