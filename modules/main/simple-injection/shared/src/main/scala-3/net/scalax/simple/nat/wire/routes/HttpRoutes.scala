package net.scalax.simple.nat.wire
package routes

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import service.ServiceA

trait NatHttpRoutes:
  def serviceA: ServiceA

  def route: HttpRoutes[IO] = HttpRoutes.of[IO] { case GET -> Root / "hello" / name =>
    Ok(serviceA.getByName(name))
  }
end NatHttpRoutes

class NatHttpRoutesImpl(using override val serviceA: ServiceA) extends NatHttpRoutes
