package net.scalax.simple.wire
package resource

import doobie._
import doobie.implicits._
import cats.effect.{IO, Resource}
import doobie.hikari._
import constructor.env._

abstract class H2Doobie(dbName: String) {

  private val transactor: Resource[IO, HikariTransactor[IO]] = for {
    ce <- ExecutionContexts.fixedThreadPool[IO](32) // our connect EC
    xa <- HikariTransactor.newHikariTransactor[IO](
      "org.h2.Driver",                          // driver classname
      s"jdbc:h2:mem:$dbName;DB_CLOSE_DELAY=-1", // connect URL
      "sa",                                     // username
      "",                                       // password
      ce                                        // await connection here
    )
  } yield xa

  private def executeUpdate: ConnectionIO[Int] = {
    val sql1 = sql"DROP TABLE IF EXISTS cats".update
    val sql2 = sql"CREATE TABLE cats(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), age INT)".update

    for {
      a <- sql1.run
      b <- sql2.run
    } yield (a: Int) + (b: Int)
  }

  private val initAction = for {
    xa <- transactor
    updateAction = executeUpdate.transact(xa)
    r <- Resource.eval(updateAction)
  } yield {
    r: Int
    xa
  }

  protected val resource: Resource[IO, Transactor[IO]] = initAction
}

class EnvAH2Doobie extends H2Doobie("EnvA") {
  val resourceEnvA: Resource[IO, EnvA[Transactor[IO]]] = for (r <- resource) yield EnvA(r)
}

class EnvBH2Doobie extends H2Doobie("EnvB") {
  val resourceEnvB: Resource[IO, EnvB[Transactor[IO]]] = for (r <- resource) yield EnvB(r)
}
