package net.scalax.simple.wire
package service

import cats.effect._
import cats._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._
import model._

class ServiceA(implicit initPrinter: InitPrinter, serviceBFunc: () => ServiceB, dbDao: DBDao) {
  serviceA: ServiceA =>

  initPrinter.printAction()

  def serviceB: ServiceB        = serviceBFunc()
  def selectData: IO[List[Cat]] = dbDao.select

  def dataCol: IO[(List[Cat], List[Cat])] = for (dataA <- serviceA.selectData; dataB <- serviceB.selectData) yield (dataA, dataB)

  def insertName(list: List[(String, Int)]): IO[List[Cat]] = list match {
    case head :: tail =>
      val catModel = Cat(id = -1, name = head._1, age = head._2)
      for (model <- dbDao.insert(catModel); listTail <- serviceB.insertNameB(tail)) yield model :: listTail
    case Nil => IO(List.empty)
  }

  def getByName(name: String): IO[String] = IO(println(serviceB.toString)) *> IO(s"Hello, $name.")

}
