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

class AppWire(using EnvA[Transactor.Aux[IO, Unit]], EnvB[Transactor.Aux[IO, Unit]]):

  private given ServiceA              = new ServiceAImpl[Id, EnvA](() => serviceB)
  private lazy val serviceB: ServiceB = new ServiceBImpl[Id, EnvB](() => summon)

  private given CountService = new CountServiceImpl[EnvA, EnvB]

  type IdNatHttpRoutes[M[_]] = NatHttpRoutesImpl[M, M]
  private lazy val natRoutesInstances: NatHttpRoutes = new IdNatHttpRoutes[Id]

  lazy val routes: HttpRoutes[IO] = natRoutesInstances.route

end AppWire

object AppWire:

  val build: IO[HttpRoutes[IO]] =
    val xa1 = for xaImpl <- (new EnvAH2Doobie).resource yield Wire[EnvA].from(xaImpl)
    val xa2 = for xaImpl <- (new EnvBH2Doobie).resource yield Wire[EnvB].from(xaImpl)

    for
      xaA <- xa1
      xaB <- xa2
    yield
      given EnvA[Transactor.Aux[IO, Unit]] = xaA
      given EnvB[Transactor.Aux[IO, Unit]] = xaB
      (new AppWire).routes
  end build

end AppWire
