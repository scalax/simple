package net.scalax.simple.codec
package aa

import slick.ast.{ColumnOption, TypedType}
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
  type Id[T]     = T
  type StrAny[T] = String
  type ColOpt[T] = Seq[ColumnOption[T]]

  val uAPI = new U(slickProfile)

  def userRep[U[_]](implicit tt12: TypedType[U[Int]]): UserAbs[TypedType, U] = UserAbs[TypedType, U](implicitly, implicitly, implicitly)
  def userNamed[U[_]]: UserAbs[StrAny, U]                                    = UserAbs[StrAny, U](id = "id", first = "first", last = "last")
  def userOpt[U[_]]: uAPI.ColumnOptions => UserAbs[ColOpt, U] = O =>
    UserAbs[ColOpt, U](id = List(O.PrimaryKey, O.AutoInc), Seq.empty, Seq.empty)

  def modelSetter[F[_], U[_]]: ModelSetter[UserAbs[F, U]] = ModelSetter[UserAbs[F, U]](x => UserAbs[F, U](x.get, x.get, x.get))
  def modelGetter[F[_], U[_]]: ModelGetter[UserAbs[F, U]] = ModelGetter.generic[UserAbs[F, U]]

  def userTable[U[_]](implicit tt12: TypedType[U[Int]]): Table[UserAbs[Id, U]] => UserAbs[Rep, U] = { table =>
    val l1 = modelGetter[StrAny, U].data(userNamed).asInstanceOf[List[String]]
    val l2 = modelGetter[ColOpt, U].data(userOpt(table.O)).asInstanceOf[List[List[ColumnOption[Any]]]]
    val l3 = modelGetter[TypedType, U].data(userRep).asInstanceOf[List[TypedType[Any]]]
    val columnInstance: List[Rep[Any]] =
      for (((name, colOpt), typedType) <- l1.zip(l2).zip(l3)) yield table.column(name, colOpt: _*)(typedType)
    modelSetter[Rep, U].inputList(columnInstance)
  }
}
