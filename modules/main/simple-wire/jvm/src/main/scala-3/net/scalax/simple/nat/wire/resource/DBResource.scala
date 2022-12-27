package net.scalax.simple.wire
package resource

import doobie._
import doobie.implicits._
import cats.effect.{IO, Resource}
import doobie.hikari._

trait H2Doobie(dbName: String):

  private val transactor: Resource[IO, HikariTransactor[IO]] = for
    ce <- ExecutionContexts.fixedThreadPool[IO](32) // our connect EC
    xa <- HikariTransactor.newHikariTransactor[IO](
      "org.h2.Driver",                          // driver classname
      s"jdbc:h2:mem:$dbName;DB_CLOSE_DELAY=-1", // connect URL
      "sa",                                     // username
      "",                                       // password
      ce                                        // await connection here
    )
  yield xa

  def executeUpdate: ConnectionIO[Int] =
    val sql1 = sql"DROP TABLE IF EXISTS cats".update
    val sql2 = sql"CREATE TABLE cats(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), age INT)".update

    for
      a: Int <- sql1.run
      b: Int <- sql2.run
    yield a + b
  end executeUpdate

  private val initAction = for
    xa <- transactor
    updateAction = executeUpdate.transact(xa)
    _: Int <- Resource.eval(updateAction)
  yield xa

  val resource: Resource[IO, Transactor[IO]] = initAction
end H2Doobie

class EnvAH2Doobie extends H2Doobie("EnvA")

class EnvBH2Doobie extends H2Doobie("EnvB")
