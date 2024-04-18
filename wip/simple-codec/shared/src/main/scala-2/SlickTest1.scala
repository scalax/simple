package net.scalax.simple.codec
package aa

import net.scalax.simple.codec.generic.SimpleFromProduct
import net.scalax.simple.codec.to_list_generic.SimpleProduct
import slick.ast.{ColumnOption, TypedType}
import slick.jdbc.JdbcProfile
import slick.lifted.ProvenShape
import slickless._

class Model2(val slickProfile: JdbcProfile) {
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

  case class UserAbs[F[_], U[_]](id: F[U[Int]], first: F[String], last: F[String])

  type Id[T]           = T
  type StrAny[T]       = String
  type ShapeF[T]       = Shape[_ <: FlatShapeLevel, Rep[T], T, _]
  type RepFromTable[T] = slickProfile.Table[_] => Rep[T]
  type OptsFromCol[T]  = Seq[commonAlias.SqlColumnOptions => ColumnOption[T]]

  def userTypedTypeGeneric[U[_]](implicit tt12: TypedType[U[Int]]): UserAbs[TypedType, U] =
    FillIdentity[UserAbsAlias[U]#F1, TypedType].derived2(simpleGen1[U, TypedType].generic)(_.generic)

  class UserAbsAlias[U[_]] {
    type F1[E1[_]] = UserAbs[E1, U]
  }

  def simpleGen1[U[_], I[_]] = SimpleFromProduct[UserAbsAlias[U]#F1, I].derived

  implicit def deco1_2[U[_]]: SimpleProduct.Appender[UserAbsAlias[U]#F1] = new SimpleProduct.Appender.Impl[UserAbsAlias[U]#F1] {
    override def impl[M1[_, _, _], M2[_], M3[_], M4[_]] =
      _.derived2(simpleGen1[U, cats.Id].generic, simpleGen1[U, M2].generic, simpleGen1[U, M3].generic, simpleGen1[U, M4].generic)(_.generic)
  }

  def userNamed[U[_]]: LabelledInstalled[UserAbsAlias[U]#F1] = LabelledInstalled[UserAbsAlias[U]#F1].derived(deco1_2[U], implicitly)

  def userOptImpl[U[_]]: UserAbs[OptsFromCol, U] = SimpleFill[UserAbsAlias[U]#F1]
    .derived(deco1_2[U])
    .fill[OptsFromCol](new SimpleFill.FillI[OptsFromCol] {
      override def fill[T]: Seq[commonAlias.SqlColumnOptions => ColumnOption[T]] = Seq.empty
    })
  def userOpt[U[_]]: UserAbs[OptsFromCol, U] = {
    val impl                      = userOptImpl[U]
    val list: OptsFromCol[U[Int]] = addElem(impl.id, _.AutoInc, _.PrimaryKey)
    impl.copy[OptsFromCol, U](id = list)
  }

  def userRep[U[_]](implicit tt12: TypedType[U[Int]]): slickProfile.Table[_] => UserAbs[Rep, U] = { tb =>
    val l1 = userNamed[U].labelled
    val l2 = userOpt[U]
    val l3 = userTypedTypeGeneric[U]

    val zipGeneric: ZipGeneric[UserAbsAlias[U]#F1] = ZipGeneric[UserAbsAlias[U]#F1].derived(deco1_2[U])
    val mapGeneric: MapGenerc[UserAbsAlias[U]#F1]  = MapGenerc[UserAbsAlias[U]#F1].derived(deco1_2[U])

    val zipResult1 = zipGeneric.zip[LabelledInstalled.Named, OptsFromCol](l1, l2)
    val zipResult2 =
      zipGeneric.zip[({ type F1[T] = (String, Seq[commonAlias.SqlColumnOptions => ColumnOption[T]]) })#F1, TypedType](zipResult1, l3)

    val mapResult = mapGeneric.map[({ type F1[T] = ((String, OptsFromCol[T]), TypedType[T]) })#F1, Rep](
      new MapGenerc.MapFunction[({ type F1[T] = ((String, OptsFromCol[T]), TypedType[T]) })#F1, Rep] {
        override def map[X1]: (((String, OptsFromCol[X1]), TypedType[X1])) => Rep[X1] = t => colN(t._1._1, t._1._2, t._2)(tb)
      }
    )

    mapResult(zipResult2)
  }

  class TableUserAbs[U[_]](tag: Tag)(implicit tt: TypedType[U[Int]], s: ShapeF[U[Int]])
      extends slickProfile.Table[UserAbs[Id, U]](tag, "users") {
    self =>
    private val repModel: slickProfile.Table[_] => UserAbs[Rep, U] = userRep[U]
    private def __tableInnserRep: UserAbs[Rep, U]                  = repModel(self)

    private val generic1 = simpleGen1[U, Rep].generic
    private val generic2 = simpleGen1[U, Id].generic

    override def * : ProvenShape[UserAbs[Id, U]] = generic1.to(__tableInnserRep) <> (generic2.from, generic2.to _ andThen Some.apply)
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

object Runner1 {

  def main(arr: Array[String]): Unit = {
    val p = slick.jdbc.MySQLProfile

    val newM: Model2 = new Model2(p)

    import p.api._
    println(newM.query1.result.statements)
    println(newM.query2.result.statements)
  }

}
