package net.scalax.simple.codec
package aa

import slick.jdbc.MySQLProfile.api._

object Model1 {
  case class User(id: Option[Int], first: String, last: String)

  class Users(tag: Tag) extends Table[User](tag, "users") {
    def id    = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def first = column[String]("first")
    def last  = column[String]("last")
    def *     = (id.?, first, last) <> ((User.apply _).tupled, User.unapply _)
  }
  val users = TableQuery[Users]
}

object Model2 {
  case class UserAbs[F[_], U[_]](id: F[U[Int]], first: F[String], last: F[String])
  type UserTableForInsert = UserAbs[RepCol, Option]
  type UserTableForSelect = UserAbs[RepCol, Id]
  type UserModelForInsert = UserAbs[Id, Option]
  type UserModelForSelect = UserAbs[Id, Id]
  type RepCol[T]          = Rep[T]
  type Id[T]              = T

  val userTable1: Table[_] => UserTableForSelect = { table =>
    UserAbs[RepCol, Id](
      id = table.column[Int]("id", table.O.PrimaryKey, table.O.AutoInc),
      first = table.column[String]("first"),
      last = table.column[String]("last")
    )
  }

  val userTable2: Table[_] => UserTableForInsert = { table =>
    val t = userTable1(table)
    t.copy(id = t.id.?)
  }
}
