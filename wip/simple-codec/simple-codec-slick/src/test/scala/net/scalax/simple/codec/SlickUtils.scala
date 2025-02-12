package net.scalax.simple.codec
package aa

import net.scalax.simple.codec.to_list_generic.{ModelLink, SimpleProduct1, SimpleProduct2, SimpleProduct3, SimpleProduct4, SimpleProductX}
import slick.ast.{ColumnOption, TypedType}
import slick.jdbc.JdbcProfile

class SlickUtils[F[_[_]], V <: JdbcProfile](val slickProfile: V, appender: ModelLink[F, F[({ type U1[T] = T })#U1]]) {
  import slickProfile.api._

  val commonAlias: SlickCompatAlias[slickProfile.type] = SlickCompatAlias.build(slickProfile)
  val appender1: SimpleProduct1.Appender[F]            = appender.simpleProduct1
  val appender2: SimpleProduct2.Appender[F]            = SimpleProduct2[F].derived(appender.basedInstalled)
  val appender3: SimpleProduct3.Appender[F]            = SimpleProduct3[F].derived(appender.basedInstalled)
  val appender4: SimpleProduct4.Appender[F]            = SimpleProduct4[F].derived(appender.basedInstalled)
  val zip3Generic: Zip3Generic[F]                      = Zip3Generic[F].derived(appender4)
  val mapGeneric: MapGenerc[F]                         = MapGenerc[F].derived(appender2)

  def colN[T](name: String, func: OptsFromCol[T], tt: TypedType[T]): Table[_] => Rep[T] = { tb =>
    val colsFunc = for (n <- func) yield n(tb.O)
    tb.column(name, colsFunc: _*)(tt)
  }

  type OptsFromCol[T] = Seq[commonAlias.SqlColumnOptions => ColumnOption[T]]

  def userOptImpl: F[OptsFromCol] = SimpleFill[F]
    .derived(appender1)
    .fill[OptsFromCol](new SimpleFill.FillI[OptsFromCol] {
      override def fill[T]: Seq[commonAlias.SqlColumnOptions => ColumnOption[T]] = Seq.empty
    })

  def userRep(labelled: ModelLabelled[F], opt: F[OptsFromCol], typedType: F[TypedType]): slickProfile.Table[_] => F[Rep] = { tb =>
    val l1 = labelled.modelLabelled
    val l2 = opt
    val l3 = typedType

    val zipResult1 = zip3Generic.zip[({ type M1[_] = String })#M1, OptsFromCol, TypedType](l1, l2, l3)

    val mapFunction: MapGenerc.MapFunction[({ type F1[T] = (String, OptsFromCol[T], TypedType[T]) })#F1, Rep] =
      new MapGenerc.MapFunction[({ type F1[T] = (String, OptsFromCol[T], TypedType[T]) })#F1, Rep] {
        override def map[X1](t: (String, OptsFromCol[X1], TypedType[X1])): Rep[X1] = colN(t._1, t._2, t._3)(tb)
      }

    val mapResult = mapGeneric.map[({ type F1[T] = (String, OptsFromCol[T], TypedType[T]) })#F1, Rep](mapFunction)

    mapResult(zipResult1)
  }

}

object SlickUtils {
  def apply[F[_[_]]](appender: ModelLink[F, F[({ type U1[T] = T })#U1]]): SlickUtilsApply[F] = new SlickUtilsApply[F](appender)

  class SlickUtilsApply[F[_[_]]](appender: ModelLink[F, F[({ type U1[T] = T })#U1]]) {
    def build[V <: JdbcProfile](slickProfile: V): SlickUtils[F, slickProfile.type] =
      new SlickUtils[F, slickProfile.type](slickProfile, appender)
  }
}
