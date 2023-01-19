package net.scalax.simple.wire
package resource

import doobie._
import doobie.implicits._
import cats.effect._
import doobie.hikari._

abstract class H2Doobie(dbName: String) {

  private def transactor[F[_]: Async]: Resource[F, HikariTransactor[F]] = for {
    ce <- ExecutionContexts.fixedThreadPool[F](32) // our connect EC
    xa <- HikariTransactor.newHikariTransactor[F](
      "org.h2.Driver",                          // driver classname
      s"jdbc:h2:mem:$dbName;DB_CLOSE_DELAY=-1", // connect URL
      "sa",                                     // username
      "",                                       // password
      ce                                        // await connection here
    )
  } yield xa

  private val executeUpdate: ConnectionIO[Int] = {
    val sql1 = sql"DROP TABLE IF EXISTS cats".update
    val sql2 = sql"CREATE TABLE cats(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), age INT)".update

    for {
      a <- sql1.run
      b <- sql2.run
    } yield (a: Int) + (b: Int)
  }

  private def initAction[F[_]: MonadCancelThrow](xa: Transactor[F]): Resource[F, Int] = Resource.eval(executeUpdate.transact(xa))

  def resource[F[_]: Async]: Resource[F, Transactor[F]] = for (xa <- transactor; _ <- initAction(xa)) yield xa
}

class EnvAH2Doobie extends H2Doobie("EnvA")
object EnvAH2Doobie {
  def build: EnvAH2Doobie = new EnvAH2Doobie
}

class EnvBH2Doobie extends H2Doobie("EnvB")

object EnvBH2Doobie {
  def build: EnvBH2Doobie = new EnvBH2Doobie
}
