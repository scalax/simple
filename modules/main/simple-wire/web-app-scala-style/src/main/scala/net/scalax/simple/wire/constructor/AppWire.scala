package net.scalax.simple.wire
package constructor

import service._
import routes.NatHttpRoutes
import org.http4s.HttpRoutes
import cats.effect._
import resource._
import cats._

object AppWire {

  val golbalRoutes: Resource[IO, HttpRoutes[IO]] = EnvAH2Doobie.build.resource[IO].flatMap { rA =>
    EnvBH2Doobie.build.resource[IO].flatMap { rB =>
      InitPrinter.build[IO].map { implicit initPrinter =>
        lazy val dbDaoEnvA: DBDao = DBDao.build(doobieTransactor = rA)
        lazy val dbDaoEnvB: DBDao = DBDao.build(doobieTransactor = rB)

        implicit lazy val serviceA: ServiceA = ServiceA.build(initPrinter = implicitly, serviceBFunc = implicitly, dbDao = dbDaoEnvA)
        implicit lazy val serviceB: ServiceB = ServiceB.build(serviceAFunc = implicitly, dbDao = dbDaoEnvB)

        lazy val natRoutesInstances: NatHttpRoutes = NatHttpRoutes.build

        natRoutesInstances.route
      }
    }
  }

}
