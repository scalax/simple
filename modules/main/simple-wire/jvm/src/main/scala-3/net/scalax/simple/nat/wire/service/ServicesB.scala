package net.scalax.simple.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._
import model._

trait ServiceB:
  def serviceA: ServiceA
  def dbDao: DBDao

  def selectData: IO[List[Cat]] = dbDao.select

  def insertNameB(list: List[(String, Int)]): IO[List[Cat]] = list.match
    case head :: tail =>
      val catModel = Cat(id = -1, name = head._1, age = head._2)
      for model <- dbDao.insert(catModel); listTail <- serviceA.insertName(tail) yield model :: listTail
    case Nil => IO(List.empty)
  end insertNameB

end ServiceB

class ServiceBImpl[ServiceAEnv[_]: Wire, DBEnv[_]: Wire](sa: () => ServiceAEnv[ServiceA])(using DBEnv[Transactor.Aux[IO, Unit]])
    extends ServiceB:
  override lazy val serviceA: ServiceA = Wire[ServiceAEnv].unlift(sa())
  override val dbDao: DBDao            = new DBDaoImpl[DBEnv]
end ServiceBImpl
