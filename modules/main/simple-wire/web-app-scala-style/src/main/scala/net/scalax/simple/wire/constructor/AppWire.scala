package net.scalax.simple.wire
package constructor

import service._
import routes.NatHttpRoutes
import org.http4s.HttpRoutes
import cats.effect._
import resource._
import cats._

object AppWire {

  private class ServiceAImpl(implicit initPrinter: InitPrinter, serviceBFunc: () => ServiceB) {
    def build(dbDao: DBDao): ServiceA = new ServiceA()(initPrinter = implicitly, serviceBFunc = implicitly, dbDao = dbDao)
  }

  private class ServiceBImpl(implicit serviceAFunc: () => ServiceA) {
    def build(dbDao: DBDao): ServiceB = new ServiceB()(serviceAFunc = implicitly, dbDao = dbDao)
  }

  val golbalRoutes: Resource[IO, HttpRoutes[IO]] = (new WireConfig).getResource[IO].flatMap { implicit simpleConfig =>
    (new EnvAH2Doobie).resource[IO].flatMap { rA =>
      (new EnvBH2Doobie).resource[IO].map { rB =>
        implicit lazy val initPrinter: InitPrinter = new InitPrinter
        lazy val dbDaoEnvA: DBDao                  = DBDao(xa = rA)
        lazy val dbDaoEnvB: DBDao                  = DBDao(xa = rB)

        implicit lazy val serviceB: () => ServiceB = () => serviceBImplB
        lazy val serviceAImpl: ServiceAImpl        = new ServiceAImpl
        implicit lazy val serviceAImplA: ServiceA  = serviceAImpl.build(dbDao = dbDaoEnvA)
        implicit lazy val serviceA: () => ServiceA = () => implicitly
        lazy val serviceBImpl: ServiceBImpl        = new ServiceBImpl
        lazy val serviceBImplB: ServiceB           = serviceBImpl.build(dbDao = dbDaoEnvB)

        lazy val natRoutesInstances: NatHttpRoutes = new NatHttpRoutes

        natRoutesInstances.route
      }
    }
  }

}
