package net.scalax.simple.nat.wire
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

class NatHttpRoutesImpl[Env1[_]: Getter, Env2[_]: Getter](using Env1[ServiceA], Env2[CountService])
    extends NatHttpRoutes(serviceA = Getter.instance[Env1].get(summon), countService = Getter.instance[Env2].get(summon))
