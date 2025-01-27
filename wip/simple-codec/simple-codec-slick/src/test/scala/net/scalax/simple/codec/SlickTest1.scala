package net.scalax.simple.codec
package aa

import net.scalax.simple.codec.generic.SimpleFromProduct
import net.scalax.simple.codec.to_list_generic.{AppenderFromSize, SimpleProduct1, SimpleProductX}
import slick.ast.{ColumnOption, TypedType}
import slick.jdbc.JdbcProfile
import slick.lifted.ProvenShape
import net.scalax.slickless.compat._

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
    UserAbs[TypedType, U](implicitly, implicitly, implicitly)

  val simpleGen1 = SimpleFromProduct[F1Alias].derived

  implicit val deco1_2: AppenderFromSize[F1Alias]          = AppenderFromSize[F1Alias].derived(implicitly)
  implicit val namedLabel: CompatLabelled[F1Alias]         = CompatLabelled[F1Alias].derived(implicitly)
  implicit val modelSize: ModelSize[F1Alias]               = ModelSize[F1Alias].derived(implicitly)
  implicit val appender: SimpleProductX[F1Alias]           = SimpleProductX[F1Alias].derived(implicitly, implicitly)
  implicit val appender1: SimpleProduct1.Appender[F1Alias] = SimpleProduct1[F1Alias].derived(implicitly)
  implicit val fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[F1Alias] =
    FromListByTheSameTypeGeneric[F1Alias].derived(implicitly)
  implicit val userNamed: ModelLabelled[F1Alias] = ModelLabelled[F1Alias].derived(implicitly, implicitly)

  def userOptImpl: UserAbs[OptsFromCol, U] = SlickUtils[F1Alias](appender).build(slickProfile).userOptImpl

  def userOpt: UserAbs[OptsFromCol, U] = {
    val impl                      = userOptImpl
    val list: OptsFromCol[U[Int]] = addElem(impl.id, _.AutoInc, _.PrimaryKey)
    impl.copy[OptsFromCol, U](id = list)
  }

  def userRep(implicit tt12: TypedType[U[Int]]): slickProfile.Table[_] => UserAbs[Rep, U] =
    SlickUtils[F1Alias](appender).build(slickProfile).userRep(userNamed, userOpt, userTypedTypeGeneric)

  class TableUserAbs(tag: Tag)(implicit tt: TypedType[U[Int]], s: ShapeF[U[Int]]) extends slickProfile.Table[UserAbs[Id, U]](tag, "users") {
    self =>
    private val repModel: slickProfile.Table[_] => UserAbs[Rep, U] = userRep
    private def __tableInnserRep: UserAbs[Rep, U]                  = repModel(self)

    override def * : ProvenShape[UserAbs[Id, U]] =
      (__tableInnserRep.id, __tableInnserRep.first, __tableInnserRep.last) <> ((UserAbs.apply[Id, U] _).tupled, UserAbs.unapply[Id, U] _)
  }

  object TableUserAbs {
    import scala.language.implicitConversions
    implicit def TableUserAbsTableImpl(tb: TableUserAbs): UserAbs[Rep, U] = tb.__tableInnserRep
  }

}

object Runner1 {
  type Id[T] = T

  def main(arr: Array[String]): Unit = {
    val p = slick.jdbc.MySQLProfile

    val newModel: Model2[Id]   = new Model2[Id](p)
    val newOpt: Model2[Option] = new Model2[Option](p)
    val modelInt: IndexModel[({ type F1[U[_]] = UserAbs[U, Id] })#F1] =
      IndexModel[({ type F1[U[_]] = UserAbs[U, Id] })#F1].derived(newModel.fromListByTheSameTypeGeneric)

    import p.api._

    object Query1 extends TableQuery(cons => new newOpt.TableUserAbs(cons)) {
      object forInsert extends TableQuery(cons => new newModel.TableUserAbs(cons))
    }

    println(Query1.forInsert.result.statements)
    println(Query1.result.statements)
    println(modelInt.model)
  }

}
