package net.scalax.simple.wire
package service

import cats.effect._
import cats._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._
import model._

trait ServiceA:
  serviceA: ServiceA =>
  def serviceB: ServiceB
  def dbDao: DBDao

  def selectData: IO[List[Cat]] = dbDao.select

  def dataCol: IO[(List[Cat], List[Cat])] = for dataA <- serviceA.selectData; dataB <- serviceB.selectData yield (dataA, dataB)

  def insertName(list: List[(String, Int)]): IO[List[Cat]] = list.match
    case head :: tail =>
      val catModel = Cat(id = -1, name = head._1, age = head._2)
      for model <- dbDao.insert(catModel); listTail <- serviceB.insertNameB(tail) yield model :: listTail
    case Nil => IO(List.empty)
  end insertName

  def getByName(name: String): IO[String] = IO(println(serviceB.toString)) *> IO(s"Hello, $name.")

end ServiceA

class ServiceAImpl[ServiceBEnv[_]: Wire, DBEnv[_]: Wire](sb: () => ServiceBEnv[ServiceB])(using DBEnv[Transactor.Aux[IO, Unit]])
    extends ServiceA:
  override lazy val serviceB: ServiceB = Wire[ServiceBEnv].unlift(sb())
  override val dbDao: DBDao            = new DBDaoImpl[DBEnv]
end ServiceAImpl
