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
