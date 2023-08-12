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
  class TableHelper1[Model](tInstance: uAPI.profile.Table[Model]) {
    def apply[T](name: String, columnOption: Seq[ColumnOption[T]], typedType: TypedType[T]): Rep[T] =
      tInstance.column(name, columnOption: _*)(typedType)

    def forOpts[T](h: uAPI.ColumnOptions => T): T = h(tInstance.O)
  }
}

object Model2 {

  case class UserAbs[F[_], U[_]](id: F[U[Int]], first: F[String], last: F[String])

  type Id[T]          = T
  type StrAny[T]      = String
  type ColOpt[T]      = Seq[ColumnOption[T]]
  type ShapeF[T]      = Shape[_ <: FlatShapeLevel, Rep[T], T, _]
  type ShapeValueF[T] = ShapedValue[Rep[T], T]

  val helper: Helper[MySQLProfile] = new Helper(new U(slickProfile))

  def userTypedType[U[_]](implicit tt12: TypedType[U[Int]]): UserAbs[TypedType, U] =
    UserAbs[TypedType, U](implicitly, implicitly, implicitly)
  def userShape[U[_]](implicit tt12: ShapeF[U[Int]]): UserAbs[ShapeF, U] = UserAbs[ShapeF, U](implicitly, implicitly, implicitly)

  def userNamed[U[_]]: UserAbs[StrAny, U] = UserAbs[StrAny, U](id = "id", first = "first", last = "last")

  def userOptImpl[U[_]]: UserAbs[ColOpt, U] = UserAbs[ColOpt, U](id = Seq.empty, Seq.empty, Seq.empty)
  def userOpt[U[_]]: helper.ColumnOptions => UserAbs[ColOpt, U] = { O =>
    val u1 = userOptImpl[U]
    u1.copy[ColOpt, U](id = List(O.PrimaryKey, O.AutoInc))
  }

  def userRep[U[_]](implicit tt12: TypedType[U[Int]]): helper.TableHelper1[UserAbs[Id, U]] => UserAbs[Rep, U] = { colN =>
    val l1 = userNamed[U]
    val l2 = colN.forOpts(userOpt[U])
    val l3 = userTypedType[U]
    UserAbs[Rep, U](id = colN(l1.id, l2.id, l3.id), first = colN(l1.first, l2.first, l3.first), last = colN(l1.last, l2.last, l3.last))
  }

  def userShapedValue[U[_]](implicit
    tt1: TypedType[U[Int]],
    tt12: ShapeF[U[Int]]
  ): helper.TableHelper1[UserAbs[Id, U]] => UserAbs[ShapeValueF, U] = { colN =>
    val rep1Impl = userRep[U]
    val rep1     = rep1Impl(colN)
    val shape1   = userShape[U]
    UserAbs[ShapeValueF, U](
      id = ShapedValue(rep1.id, shape1.id),
      first = ShapedValue(rep1.first, shape1.first),
      last = ShapedValue(rep1.last, shape1.last)
    )
  }

  class TableUserAbs[F[_], U[_]](tag: Tag)(implicit tt: TypedType[U[Int]], s: ShapeF[U[Int]])
      extends helper.uAPI.profile.Table[UserAbs[Id, U]](tag, "users") {
    self =>
    def tableHelper = new helper.TableHelper1[UserAbs[Id, U]](self)

    def t: UserAbs[Rep, U] = {
      val tImpl = userRep[U]
      tImpl(tableHelper)
    }

    def sv: UserAbs[ShapeValueF, U] = {
      val v = userShapedValue[U]
      v(tableHelper)
    }

    import slick.collection.heterogeneous._
    import slick.collection.heterogeneous.syntax._

    override def * : ProvenShape[UserAbs[Id, U]] =
      (sv.id :: sv.first :: sv.last :: HNil) <> (u => UserAbs.apply[Id, U](u.head, u.tail.head, u.tail.tail.head), (t: UserAbs[Id, U]) =>
        Some(t.id :: t.first :: t.last :: HNil))
  }
}
