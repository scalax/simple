package net.scalax.simple.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._

trait CountService(countXA: Transactor.Aux[IO, Unit], dataXA: Transactor.Aux[IO, Unit]):

  val y1 = countXA.yolo
  val y2 = dataXA.yolo

end CountService

class CountServiceImpl[CountEnv[_]: Wire, DataEnv[_]: Wire](using CountEnv[Transactor.Aux[IO, Unit]], DataEnv[Transactor.Aux[IO, Unit]])
    extends CountService(countXA = Wire[CountEnv].to(summon), dataXA = Wire[DataEnv].to(summon))
