package net.scalax.simple.codec
package aa

import slick.ast.{ColumnOption, TypedType}
import slick.jdbc.{JdbcProfile, MySQLProfile}
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{ProvenShape, ShapedValue}

object Model1 {
  case class User(id: Option[Int], first: String, last: String)

  class Users(tag: Tag) extends Table[User](tag, "users") {
    def id                             = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def first                          = column[String]("first")
    def last                           = column[String]("last")
    override def * : ProvenShape[User] = (id.?, first, last) <> ((User.apply _).tupled, User.unapply _)
  }
  val users = TableQuery[Users]
}

class Helper[V <: JdbcProfile](val uAPI: U[V]) {
  type ColumnOptions = uAPI.ColumnOptions
  /*class TableHelper1[Model](tInstance: uAPI.profile.Table[Model]) {
    def apply[T](name: String, columnOption: Seq[ColumnOption[T]], typedType: TypedType[T]): Rep[T] =
      tInstance.column(name, columnOption: _*)(typedType)

    def forOpts[T](h: uAPI.ColumnOptions => T): T = h(tInstance.O)
  }*/
}

object Model2 {

  case class UserAbs[F[_], U[_]](id: F[U[Int]], first: F[String], last: F[String])

  type Id[T]           = T
  type StrAny[T]       = String
  type ShapeF[T]       = Shape[_ <: FlatShapeLevel, Rep[T], T, _]
  type RepFromTable[T] = helper.uAPI.profile.Table[_] => Rep[T]
  type OptsFromCol[T]  = Seq[helper.ColumnOptions => ColumnOption[T]]

  val helper: Helper[MySQLProfile] = new Helper(new U(slickProfile))

  def userTypedType[U[_]](implicit tt12: TypedType[U[Int]]): UserAbs[TypedType, U] =
    UserAbs[TypedType, U](implicitly, implicitly, implicitly)

  def userNamed[U[_]]: UserAbs[StrAny, U] = UserAbs[StrAny, U](id = "id", first = "first", last = "last")

  def userOptImpl[U[_]]: UserAbs[OptsFromCol, U] = UserAbs[OptsFromCol, U](id = Seq.empty, Seq.empty, Seq.empty)
  def userOpt[U[_]]: UserAbs[OptsFromCol, U] = {
    val u1 = userOptImpl[U]
    u1.copy[OptsFromCol, U](id = List(_.PrimaryKey, _.AutoInc))
  }

  def colN[T](
    name: String,
    func: OptsFromCol[T],
    tt: TypedType[T]
  ): helper.uAPI.profile.Table[_] => Rep[T] = { tb =>
    val colsFunc = for (n <- func) yield n(tb.O)
    tb.column(name, colsFunc: _*)(tt)
  }

  def userRepImpl[U[_]](implicit tt12: TypedType[U[Int]]): UserAbs[RepFromTable, U] = {
    val l1 = userNamed[U]
    val l2 = userOpt[U]
    val l3 = userTypedType[U]
    UserAbs[RepFromTable, U](
      id = colN(l1.id, l2.id, l3.id),
      first = colN(l1.first, l2.first, l3.first),
      last = colN(l1.last, l2.last, l3.last)
    )
  }

  def userRep[U[_]](implicit tt: TypedType[U[Int]]): helper.uAPI.profile.Table[_] => UserAbs[Rep, U] = { tb =>
    val impl = userRepImpl[U]
    UserAbs[Rep, U](id = impl.id(tb), first = impl.first(tb), last = impl.last(tb))
  }

  class TableUserAbs[U[_]](tag: Tag)(implicit tt: TypedType[U[Int]], s: ShapeF[U[Int]])
      extends helper.uAPI.profile.Table[UserAbs[Id, U]](tag, "users") {
    self =>
    private def __tableInnserRep: UserAbs[Rep, U] = {
      val repModel = userRep[U]
      repModel(self)
    }
    override def * : ProvenShape[UserAbs[Id, U]] =
      UserAbs.unapply[Rep, U](__tableInnserRep).get <> ((UserAbs.apply[Id, U] _).tupled, UserAbs.unapply[Id, U] _)
  }

  object TableUserAbs {
    implicit class TableUserAbsTableImpl[U[_]](tb: TableUserAbs[U])(implicit tt: TypedType[U[Int]])
        extends UserAbs[Rep, U](id = tb.__tableInnserRep.id, first = tb.__tableInnserRep.first, last = tb.__tableInnserRep.last)
  }

  def TableUserAbsQuery[U[_]](implicit tt: TypedType[U[Int]], s: ShapeF[U[Int]]): TableQuery[TableUserAbs[U]] =
    TableQuery(cons => new TableUserAbs[U](cons))

  val query1: Query[Rep[Option[Int]], Option[Int], Seq] = for (q <- TableUserAbsQuery[Option]) yield q.id
  val query2: Query[Rep[Int], Int, Seq]                 = for (q <- TableUserAbsQuery[Id]) yield q.id

}
