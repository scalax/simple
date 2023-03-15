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

  val golbalRoutes: Resource[IO, HttpRoutes[IO]] = wire[WireConfig].getResource[IO].flatMap { simpleConfig =>
    wire[EnvAH2Doobie].resource[IO].flatMap { rA =>
      wire[EnvBH2Doobie].resource[IO].map { rB =>
        implicit lazy val initPrinter = wire[InitPrinter]
        lazy val dbDaoEnvA: DBDao     = DBDao(xa = rA)
        lazy val dbDaoEnvB: DBDao     = DBDao(xa = rB)

        implicit lazy val serviceA: ServiceA = ServiceA(initPrinter = implicitly, serviceBFunc = () => implicitly, dbDao = dbDaoEnvA)
        implicit lazy val serviceB: ServiceB = ServiceB(serviceAFunc = () => implicitly, dbDao = dbDaoEnvB)

        lazy val natRoutesInstances: NatHttpRoutes = wire[NatHttpRoutes]

        natRoutesInstances.route
      }
    }
  }

}
