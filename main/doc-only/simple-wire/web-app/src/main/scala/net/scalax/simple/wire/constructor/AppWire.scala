package net.scalax.simple.wire
package constructor

import service._
import routes.NatHttpRoutes
import org.http4s.HttpRoutes
import cats.effect._
import resource._
import cats._
import net.scalax.simple.wire.model.SimpleProjectConfig

object AppWire {

  val golbalRoutes: Resource[IO, HttpRoutes[IO]] = for {
    implicit0(simpleConfig: SimpleProjectConfig) <- new WireConfig().getResource[IO]
    rA                                           <- new EnvAH2Doobie(implicitly).resource[IO]
    rB                                           <- new EnvBH2Doobie(implicitly).resource[IO]
  } yield {
    implicit lazy val initPrinter: InitPrinter = new InitPrinter

    lazy val dbDaoEnvA: DBDao = DBDao(xa = rA)
    lazy val dbDaoEnvB: DBDao = DBDao(xa = rB)

    implicit lazy val serviceAImplA: ServiceA = new ServiceA(implicitly, serviceBFunc = () => implicitly, dbDao = dbDaoEnvA)
    implicit lazy val serviceBImplB: ServiceB = new ServiceB(serviceAFunc = () => implicitly, dbDao = dbDaoEnvB)

    lazy val natRoutesInstances: NatHttpRoutes = new NatHttpRoutes(implicitly)

    natRoutesInstances.route
  }

}
