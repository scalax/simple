package net.scalax.simple.wire
package constructor

import service._
import routes.NatHttpRoutes
import org.http4s.HttpRoutes
import cats.effect._
import resource._
import cats._

object AppWire {

  val golbalRoutes: Resource[IO, HttpRoutes[IO]] = (new WireConfig)
    .getResource[IO]
    .flatMap(implicit simpleConfig =>
      (new EnvAH2Doobie)
        .resource[IO]
        .flatMap(rA =>
          (new EnvBH2Doobie).resource[IO].map { rB =>
            implicit lazy val initPrinter: InitPrinter = new InitPrinter
            lazy val dbDaoEnvA: DBDao                  = DBDao(xa = rA)
            lazy val dbDaoEnvB: DBDao                  = DBDao(xa = rB)

            implicit lazy val serviceB: () => ServiceB = () => implicitly
            implicit lazy val serviceAImplA: ServiceA =
              new ServiceA()(initPrinter = implicitly, serviceBFunc = implicitly, dbDao = dbDaoEnvA)
            implicit lazy val serviceA: () => ServiceA = () => implicitly
            implicit lazy val serviceBImplB: ServiceB  = new ServiceB()(serviceAFunc = implicitly, dbDao = dbDaoEnvB)

            lazy val natRoutesInstances: NatHttpRoutes = new NatHttpRoutes

            natRoutesInstances.route
          }
        )
    )

}
