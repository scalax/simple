package net.scalax.simple.wire
package routes

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import service.ServiceA
import doobie._
import service._

trait NatHttpRoutes(serviceA: ServiceA, countService: CountService):
  def route: HttpRoutes[IO] = HttpRoutes.of[IO] { case GET -> Root / "hello" / name =>
    Ok(serviceA.getByName(name))
  }
end NatHttpRoutes

class NatHttpRoutesImpl[Env1[_]: Wire, Env2[_]: Wire](using Env1[ServiceA], Env2[CountService])
    extends NatHttpRoutes(serviceA = Wire[Env1].to(summon), countService = Wire[Env2].to(summon))
