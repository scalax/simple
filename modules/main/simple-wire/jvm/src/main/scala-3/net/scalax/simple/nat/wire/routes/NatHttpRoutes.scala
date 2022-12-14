package net.scalax.simple.wire
package routes

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import service.ServiceA
import doobie._
import service._
import org.http4s.twirl._

trait NatHttpRoutes(serviceA: ServiceA):
  def route: HttpRoutes[IO] = HttpRoutes.of[IO] { case GET -> Root / "api" / name =>
    val action = serviceA.insertName(for i <- (1 to 20).to(List) yield (s"$name$i", i + 2))

    val view = for
      a       <- action
      dataCol <- serviceA.dataCol
    yield
      val (dataA, dataB) = dataCol
      net.scalax.simple.views.html.View1(models = a)(dataA = dataA, dataB = dataB)

    Ok(view)
  }
end NatHttpRoutes

class NatHttpRoutesImpl[Env1[_]: Wire](using Env1[ServiceA]) extends NatHttpRoutes(serviceA = Wire[Env1].unlift(summon))
