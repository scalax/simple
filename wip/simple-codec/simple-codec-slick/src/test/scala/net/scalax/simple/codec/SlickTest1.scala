package net.scalax.simple.codec
package aa

import net.scalax.simple.codec.generic.SimpleFromProduct
import net.scalax.simple.codec.to_list_generic.SimpleProduct
import slick.ast.{ColumnOption, TypedType}
import slick.jdbc.JdbcProfile
import slick.lifted.ProvenShape
import slickless._

case class UserAbs[F[_], U[_]](id: F[U[Int]], first: F[String], last: F[String])

class Model2[U[_]](val slickProfile: JdbcProfile) {
  type F1Alias[E1[_]] = UserAbs[E1, U]

  import slickProfile.api._

  val commonAlias = SlickCompatAlias.build(slickProfile)

  def addElem[T](seq: Seq[T], t: T*): Seq[T] = t ++: seq
  def colN[T](
    name: String,
    func: OptsFromCol[T],
    tt: TypedType[T]
  ): Table[_] => Rep[T] = { tb =>
    val colsFunc = for (n <- func) yield n(tb.O)
    tb.column(name, colsFunc: _*)(tt)
  }

  type Id[T]           = T
  type StrAny[T]       = String
  type ShapeF[T]       = Shape[_ <: FlatShapeLevel, Rep[T], T, _]
  type RepFromTable[T] = slickProfile.Table[_] => Rep[T]
  type OptsFromCol[T]  = Seq[commonAlias.SqlColumnOptions => ColumnOption[T]]

  def userTypedTypeGeneric(implicit tt12: TypedType[U[Int]]): UserAbs[TypedType, U] =
    FillIdentity[F1Alias, TypedType].derived2(simpleGen1[TypedType].generic)(_.generic)

  def simpleGen1[I[_]] = SimpleFromProduct[F1Alias, I].derived

  implicit def deco1_2: SimpleProduct.Appender[F1Alias] = new SimpleProduct.Appender.Impl[F1Alias] {
    override def impl[M1[_, _, _], M2[_], M3[_], M4[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[M2].generic, simpleGen1[M3].generic, simpleGen1[M4].generic)(_.generic)
  }

  def userNamed: LabelledInstalled[F1Alias] = LabelledInstalled[F1Alias].derived(deco1_2, implicitly)

  def userOptImpl: UserAbs[OptsFromCol, U] = SlickUtils[F1Alias](deco1_2).build(slickProfile).userOptImpl

  def userOpt: UserAbs[OptsFromCol, U] = {
    val impl                      = userOptImpl
    val list: OptsFromCol[U[Int]] = addElem(impl.id, _.AutoInc, _.PrimaryKey)
    impl.copy[OptsFromCol, U](id = list)
  }

  def userRep(implicit tt12: TypedType[U[Int]]): slickProfile.Table[_] => UserAbs[Rep, U] =
    SlickUtils[F1Alias](deco1_2).build(slickProfile).userRep(userNamed, userOpt, userTypedTypeGeneric)

  class TableUserAbs(tag: Tag)(implicit tt: TypedType[U[Int]], s: ShapeF[U[Int]]) extends slickProfile.Table[UserAbs[Id, U]](tag, "users") {
    self =>
    private val repModel: slickProfile.Table[_] => UserAbs[Rep, U] = userRep
    private def __tableInnserRep: UserAbs[Rep, U]                  = repModel(self)

    private val generic1 = simpleGen1[Rep].generic
    private val generic2 = simpleGen1[Id].generic

    override def * : ProvenShape[UserAbs[Id, U]] = generic1.to(__tableInnserRep) <> (generic2.from, generic2.to _ andThen Some.apply)
  }

  object TableUserAbs {
    import scala.language.implicitConversions
    implicit def TableUserAbsTableImpl(tb: TableUserAbs): UserAbs[Rep, U] = tb.__tableInnserRep
  }

}

object Runner1 {

  def main(arr: Array[String]): Unit = {
    val p = slick.jdbc.MySQLProfile

    val newModel: Model2[cats.Id] = new Model2[cats.Id](p)
    val newOpt: Model2[Option]    = new Model2[Option](p)

    import p.api._

    object Query1 extends TableQuery(cons => new newModel.TableUserAbs(cons))
    object Query2 extends TableQuery(cons => new newOpt.TableUserAbs(cons))

    println(Query1.result.statements)
    println(Query2.result.statements)
  }

}
