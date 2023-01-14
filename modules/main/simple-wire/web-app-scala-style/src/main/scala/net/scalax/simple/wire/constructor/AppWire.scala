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

class AppWire(doobieTransactorA: Transactor[IO], doobieTransactorB: Transactor[IO]) {

  implicit private lazy val dbDaoEnvA: DBDao         = DBDao.build(doobieTransactor = doobieTransactorA)
  implicit private lazy val dbDaoEnvB: DBDao         = DBDao.build(doobieTransactor = doobieTransactorB)
  implicit private lazy val initPrinter: InitPrinter = InitPrinter.build

  implicit private lazy val serviceA: ServiceA = ServiceA.build(initPrinter = implicitly, serviceBFunc = () => serviceB, dbDao = dbDaoEnvA)
  implicit private lazy val serviceB: ServiceB = ServiceB.build(serviceAFunc = () => serviceA, dbDao = dbDaoEnvB)

  implicit private lazy val natRoutesInstances: NatHttpRoutes = NatHttpRoutes.build

  lazy val routes: HttpRoutes[IO] = natRoutesInstances.route

}

object AppWire {
  def build(implicit doobieTransactorA: Transactor[IO], doobieTransactorB: Transactor[IO]): AppWire =
    new AppWire(doobieTransactorA = doobieTransactorA, doobieTransactorB = doobieTransactorB)

  val buildGlobal: Resource[IO, AppWire] = {
    val resourceA = (new EnvAH2Doobie).resource
    val resourceB = (new EnvBH2Doobie).resource
    for {
      rA <- resourceA
      rB <- resourceB
    } yield AppWire.build(doobieTransactorA = rA, doobieTransactorB = rB)
  }

}
