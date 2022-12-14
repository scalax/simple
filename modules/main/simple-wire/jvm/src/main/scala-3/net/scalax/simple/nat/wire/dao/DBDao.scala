package net.scalax.simple.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._
import doobie.implicits._
import model._

trait DBDao(xa: Transactor.Aux[IO, Unit]):

  val y = xa.yolo
  import y._
  def insertImpl(model: Cat): ConnectionIO[Cat] =
    val action = sql"insert into cats (name, age) values (${model.name}, ${model.age})".update.withUniqueGeneratedKeys[Int]("id")
    for id <- action yield model.copy(id = id)
  end insertImpl
  def insert(model: Cat): IO[Cat] = insertImpl(model).transact(xa)

  def selectImpl: ConnectionIO[List[Cat]] = sql"select id, name, age from cats".query[Cat].to[List]
  def select: IO[List[Cat]]               = selectImpl.transact(xa)

end DBDao

class DBDaoImpl[XaEnv[_]: Wire](using XaEnv[Transactor.Aux[IO, Unit]]) extends DBDao(xa = Wire[XaEnv].unlift(summon))