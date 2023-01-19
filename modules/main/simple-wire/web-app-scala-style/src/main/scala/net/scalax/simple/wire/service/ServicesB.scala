package net.scalax.simple.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._
import model._

class ServiceB(serviceAFunc: () => ServiceA, dbDao: DBDao) {

  def serviceA: ServiceA        = serviceAFunc()
  def selectData: IO[List[Cat]] = dbDao.select

  def insertNameB(list: List[(String, Int)]): IO[List[Cat]] = list match {
    case head :: tail =>
      val catModel = Cat(id = -1, name = head._1, age = head._2)
      for (model <- dbDao.insert(catModel); listTail <- serviceA.insertName(tail)) yield model :: listTail
    case Nil => IO(List.empty)
  }

}

object ServiceB {
  def build(implicit serviceAFunc: => ServiceA, dbDao: DBDao): ServiceB =
    new ServiceB(serviceAFunc = () => serviceAFunc, dbDao = implicitly)
}
