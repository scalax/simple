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
import scala.collection.compat._

class NatHttpRoutes(serviceA: ServiceA) {
  def route: HttpRoutes[IO] = HttpRoutes.of[IO] { case GET -> Root / "api" / name =>
    val action = serviceA.insertName(for (i <- (1 to 20).to(List)) yield (s"$name$i", i + 2))

    val view = for {
      a       <- action
      dataCol <- serviceA.dataCol
    } yield {
      val (dataA, dataB) = dataCol
      net.scalax.simple.wire.views.html.View1(models = a)(dataA = dataA, dataB = dataB)
    }

    Ok(view)
  }
}

object NatHttpRoutes {
  def build(implicit serviceA: ServiceA): NatHttpRoutes = new NatHttpRoutes(serviceA)
}
