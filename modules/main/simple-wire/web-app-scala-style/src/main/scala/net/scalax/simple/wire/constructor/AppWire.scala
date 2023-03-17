package net.scalax.simple.wire
package constructor

import service._
import routes.NatHttpRoutes
import org.http4s.HttpRoutes
import cats.effect._
import resource._
import cats._
import com.softwaremill.macwire._

object AppWire {

  private case class ServiceAImpl(initPrinter: InitPrinter, serviceBFunc: () => ServiceB) {
    def build(dbDao: DBDao): ServiceA = ServiceA(initPrinter = initPrinter, serviceBFunc = serviceBFunc, dbDao = dbDao)
  }

  private case class ServiceBImpl(serviceAFunc: () => ServiceA) {
    def build(dbDao: DBDao): ServiceB = ServiceB(serviceAFunc = serviceAFunc, dbDao = dbDao)
  }

  val golbalRoutes: Resource[IO, HttpRoutes[IO]] = wire[WireConfig].getResource[IO].flatMap { simpleConfig =>
    wire[EnvAH2Doobie].resource[IO].flatMap { rA =>
      wire[EnvBH2Doobie].resource[IO].map { rB =>
        lazy val initPrinter: InitPrinter = wire[InitPrinter]
        lazy val dbDaoEnvA: DBDao         = DBDao(xa = rA)
        lazy val dbDaoEnvB: DBDao         = DBDao(xa = rB)

        lazy val serviceB: () => ServiceB   = () => serviceBImplB
        lazy val serviceAImpl: ServiceAImpl = wire[ServiceAImpl]
        lazy val serviceAImplA: ServiceA    = serviceAImpl.build(dbDao = dbDaoEnvA)
        lazy val serviceA: () => ServiceA   = () => serviceAImplA
        lazy val serviceBImpl: ServiceBImpl = wire[ServiceBImpl]
        lazy val serviceBImplB: ServiceB    = serviceBImpl.build(dbDao = dbDaoEnvB)

        lazy val natRoutesInstances: NatHttpRoutes = wire[NatHttpRoutes]

        natRoutesInstances.route
      }
    }
  }

}
