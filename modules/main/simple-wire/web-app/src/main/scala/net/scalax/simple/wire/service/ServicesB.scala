package net.scalax.simple.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._
import model._
import com.softwaremill.macwire._

trait ServiceB {
  protected def serviceA: ServiceA
  protected def dbDao: DBDao

  def selectData: IO[List[Cat]] = dbDao.select

  def insertNameB(list: List[(String, Int)]): IO[List[Cat]] = list match {
    case head :: tail =>
      val catModel = Cat(id = -1, name = head._1, age = head._2)
      for (model <- dbDao.insert(catModel); listTail <- serviceA.insertName(tail)) yield model :: listTail
    case Nil => IO(List.empty)
  }

}

object ServiceB {
  def build(sa: => ServiceA)(implicit xa: Transactor[IO]): ServiceB = new ServiceB {
    override protected def serviceA: ServiceA = sa
    override protected val dbDao: DBDao       = DBDao.build
  }
}
