package net.scalax.simple.wire
package service

import cats.effect._
import cats._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._
import model._

import com.softwaremill.macwire._

trait ServiceA {
  serviceA: ServiceA =>
  protected def serviceB: ServiceB
  protected def dbDao: DBDao

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

object ServiceA {
  def build(sb: => ServiceB)(implicit xa: Transactor[IO]): ServiceA = new ServiceA {
    override protected def serviceB: ServiceB = sb
    override protected val dbDao: DBDao       = DBDao.build
  }
}
