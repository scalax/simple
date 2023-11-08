package net.scalax.simple.codec
package aa

import net.scalax.simple.codec.generic.SimpleFromProduct
import slick.ast.{ColumnOption, TypedType}
import slick.jdbc.MySQLProfile.api._
import slick.lifted.ProvenShape
import slickless._

object Model2 {
  val compatAlias = SlickCompatAlias.build(slickProfile)

  def addElem[T](seq: Seq[T], t: T*): Seq[T] = t ++: seq
  def colN[T](
    name: String,
    func: OptsFromCol[T],
    tt: TypedType[T]
  ): slickProfile.Table[_] => Rep[T] = { tb =>
    val colsFunc = for (n <- func) yield n(tb.O)
    tb.column(name, colsFunc: _*)(tt)
  }

  case class UserAbs[F[_], U[_]](id: F[U[Int]], first: F[String], last: F[String])

  type Id[T]           = T
  type StrAny[T]       = String
  type ShapeF[T]       = Shape[_ <: FlatShapeLevel, Rep[T], T, _]
  type RepFromTable[T] = slickProfile.Table[_] => Rep[T]
  type OptsFromCol[T]  = Seq[compatAlias.ColumnOptions => ColumnOption[T]]

  def userTypedTypeGeneric[U[_]](implicit tt12: TypedType[U[Int]]): FillIdentity[UserAbsAlias[U]#F1, TypedType] =
    FillIdentity[UserAbsAlias[U]#F1, TypedType].derived1(simpleGen1[U, TypedType].generic)
  def userTypedType[U[_]](implicit tt12: TypedType[U[Int]]): UserAbs[TypedType, U] = userTypedTypeGeneric[U].model

  class UserAbsAlias[U[_]] {
    type F1[E1[_]] = UserAbs[E1, U]
  }

  def simpleGen1[U[_], I[_]] = SimpleFromProduct[UserAbsAlias[U]#F1, I].law[UserAbs[I, U]].derived

  implicit def userNamedGeneric1[U[_]]: LabelledInstalled[UserAbsAlias[U]#F1] =
    LabelledInstalled[UserAbsAlias[U]#F1].derived(simpleGen1[U, LabelledInstalled.ToNamed].generic)

  // def userNamed[U[_]]: UserAbs[StrAny, U] = UserAbs[StrAny, U](id = "id", first = "first", last = "last")
  def userNamed[U[_]]: UserAbs[StrAny, U] = userNamedGeneric1[U].model

  def userOptImpl[U[_]]: UserAbs[OptsFromCol, U] = UserAbs[OptsFromCol, U](Seq.empty, Seq.empty, Seq.empty)
  def userOpt[U[_]]: UserAbs[OptsFromCol, U] = {
    val impl                      = userOptImpl[U]
    val list: OptsFromCol[U[Int]] = addElem(impl.id, _.AutoInc, _.PrimaryKey)
    impl.copy[OptsFromCol, U](id = list)
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

  def userRep[U[_]](implicit tt: TypedType[U[Int]]): slickProfile.Table[_] => UserAbs[Rep, U] = { tb =>
    val impl = userRepImpl[U]
    UserAbs[Rep, U](id = impl.id(tb), first = impl.first(tb), last = impl.last(tb))
  }

  class TableUserAbs[U[_]](tag: Tag)(implicit tt: TypedType[U[Int]], s: ShapeF[U[Int]])
      extends slickProfile.Table[UserAbs[Id, U]](tag, "users") {
    self =>
    private val repModel: slickProfile.Table[_] => UserAbs[Rep, U] = userRep[U]
    private def __tableInnserRep: UserAbs[Rep, U]                  = repModel(self)

    private val generic1 = TypedHelper[UserAbs[Rep, U]].build
    private val generic2 = TypedHelper[UserAbs[Id, U]].build

    override def * : ProvenShape[UserAbs[Id, U]] = generic1.to(__tableInnserRep) <> (generic2.from, generic2.to.opt)
  }

  object TableUserAbs {
    implicit class TableUserAbsTableImpl[U[_]](tb: TableUserAbs[U])
        extends UserAbs[Rep, U](id = tb.__tableInnserRep.id, first = tb.__tableInnserRep.first, last = tb.__tableInnserRep.last)
  }

  object TableUserAbsQuery extends TableQuery[TableUserAbs[Id]](cons => new TableUserAbs[Id](cons)) {
    object forInsert extends TableQuery[TableUserAbs[Option]](cons => new TableUserAbs[Option](cons))
  }

  val query1: Query[Rep[Option[Int]], Option[Int], Seq] = for (q <- TableUserAbsQuery.forInsert) yield q.id
  val query2: Query[Rep[Int], Int, Seq]                 = for (q <- TableUserAbsQuery) yield q.id

}
