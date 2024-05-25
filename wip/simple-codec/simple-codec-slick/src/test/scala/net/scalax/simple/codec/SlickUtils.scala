package net.scalax.simple.codec
package aa

import net.scalax.simple.codec.to_list_generic.SimpleProduct
import slick.ast.{ColumnOption, TypedType}
import slick.jdbc.JdbcProfile

class SlickUtils[F[_[_]], V <: JdbcProfile](val slickProfile: V, appender: SimpleProduct.Appender[F]) {
  import slickProfile.api._

  val commonAlias: SlickCompatAlias[slickProfile.type] = SlickCompatAlias.build(slickProfile)

  def colN[T](
    name: String,
    func: OptsFromCol[T],
    tt: TypedType[T]
  ): Table[_] => Rep[T] = { tb =>
    val colsFunc = for (n <- func) yield n(tb.O)
    tb.column(name, colsFunc: _*)(tt)
  }

  type OptsFromCol[T] = Seq[commonAlias.SqlColumnOptions => ColumnOption[T]]

  def userOptImpl: F[OptsFromCol] = SimpleFill[F]
    .derived(appender)
    .fill[OptsFromCol](new SimpleFill.FillI[OptsFromCol] {
      override def fill[T]: Seq[commonAlias.SqlColumnOptions => ColumnOption[T]] = Seq.empty
    })

  def userRep(labelled: LabelledInstalled[F], opt: F[OptsFromCol], typedType: F[TypedType]): slickProfile.Table[_] => F[Rep] = { tb =>
    val l1 = labelled.labelled
    val l2 = opt
    val l3 = typedType

    val zipGeneric: ZipGeneric[F] = ZipGeneric[F].derived(appender)
    val mapGeneric: MapGenerc[F]  = MapGenerc[F].derived(appender)

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

}

object SlickUtils {
  def apply[F[_[_]]](appender: SimpleProduct.Appender[F]): SlickUtilsApply[F] = new SlickUtilsApply[F](appender)

  class SlickUtilsApply[F[_[_]]](appender: SimpleProduct.Appender[F]) {
    def build[V <: JdbcProfile](slickProfile: V): SlickUtils[F, slickProfile.type] =
      new SlickUtils[F, slickProfile.type](slickProfile, appender)
  }
}
