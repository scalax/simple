package net.scalax.simple.nat.wire
package resource

import doobie._
import doobie.implicits._
import cats.effect.IO

trait H2Doobie(dbName: String):
  private val xa: Transactor.Aux[IO, Unit] = Transactor.fromDriverManager[IO](
    "org.h2.Driver",
    s"jdbc:h2:mem:$dbName;DB_CLOSE_DELAY=-1"
  )

  val y = xa.yolo
  import y._

  private val sql1 = sql"DROP TABLE IF EXISTS cats".update
  private val sql2 = sql"CREATE TABLE cats(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), age INT)".update

  private val initAction = for
    _: Int <- sql1.run
    _: Int <- sql2.run
  yield xa

  val resource: IO[Transactor.Aux[IO, Unit]] = initAction.transact(xa)
end H2Doobie

class EnvAH2Doobie extends H2Doobie("EnvA")

class EnvBH2Doobie extends H2Doobie("EnvB")
