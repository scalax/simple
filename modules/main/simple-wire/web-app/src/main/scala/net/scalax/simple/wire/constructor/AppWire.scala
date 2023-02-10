package net.scalax.simple.wire
package constructor

import service._
import routes.NatHttpRoutes
import org.http4s.HttpRoutes
import cats.effect._
import doobie._
import resource._
import cats._

class AppWire(xa1: Transactor[IO], xa2: Transactor[IO]) {

  private implicit lazy val serviceA: ServiceA = ServiceA.build(serviceB)(xa = xa1)
  private lazy val serviceB: ServiceB          = ServiceB.build(serviceA)(xa = xa2)

  private lazy val natRoutesInstances: NatHttpRoutes = NatHttpRoutes.build

  lazy val routes: HttpRoutes[IO] = natRoutesInstances.route

}

object AppWire {

  def build(implicit xa1: Transactor[IO], xa2: Transactor[IO]) = new AppWire(xa1 = xa1, xa2 = xa2)

  val app: Resource[IO, HttpRoutes[IO]] = for {
    xa1 <- H2Doobie.build("EnvA")
    xa2 <- H2Doobie.build("EnvB")
  } yield build(xa1 = xa1, xa2 = xa2).routes

}
