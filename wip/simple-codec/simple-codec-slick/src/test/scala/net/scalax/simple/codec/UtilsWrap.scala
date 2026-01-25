package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{
  BasedInstalledLabelled,
  BasedInstalledSimpleProduct,
  Fold1FGenerc,
  ToListByTheSameTypeGeneric
}
import slick.ast.TypedType
import slick.jdbc.JdbcProfile
import slick.lifted.ShapedValue

abstract class UtilsWrap[F[_[_]], Model, V <: JdbcProfile](
  val slickProfile: V,
  bi: BasedInstalledSimpleProduct[F],
  named: BasedInstalledLabelled[F]
) {
  import slickProfile.api._

  val tb: Table[Model]

  private val zip3Generic: Zip3Generic[F]                  = Zip3Generic[F].derived(bi.basedInstalled.simpleProduct4)
  private val mapGeneric: MapGenerc[F]                     = MapGenerc[F].derived(bi.basedInstalled.simpleProduct2)
  private val folderGeneric: Fold1FGenerc[F]               = Fold1FGenerc[F].derived(bi.basedInstalled.simpleProduct1)
  private val toListGeneric: ToListByTheSameTypeGeneric[F] = ToListByTheSameTypeGeneric[F].derived(folderGeneric)
  private val fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[F] =
    FromListByTheSameTypeGeneric[F].derived(bi.basedInstalled.simpleProduct1)
  private val indexOfPropertyName: IndexOfPropertyName[F] = IndexOfPropertyName[F].derived(bi.basedInstalled.simpleProduct1)

  type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]]

  def getIndexByName1(n: String)(implicit bi: BasedInstalledSimpleProduct[F]): Int =
    indexOfPropertyName.ofName(n, named.labelled.modelLabelled)

  private def helperUtil: helperUtils[slickProfile.type, F] = new helperUtils[slickProfile.type, F](
    slickProfile = slickProfile
  )(
    toListGeneric = toListGeneric,
    fromListByTheSameTypeGeneric = fromListByTheSameTypeGeneric
  )

  def mapShape(
    shapeModel: F[({ type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]] })#ShapeF],
    repModel: F[Rep],
    cst: scala.reflect.ClassTag[Model],
    modelGet: ModelGet[F, Model],
    modelSet: ModelSet[F, Model]
  ): slick.lifted.MappedProjection[Model] = {
    import slick.collection.heterogeneous.{HList => SlickHList}
    val shapedValue: ShapedValue[SlickHList, SlickHList] =
      anyToShapedValue(helperUtil.toRep(repModel))(helperUtil.toShape(shapeModel))

    val from1: F[({ type IDF[T] = T })#IDF] => SlickHList = helperUtil.fromModel
    val to1: SlickHList => F[({ type IDF[T] = T })#IDF]   = helperUtil.toModel

    ShapedValueCompat.mapToPro[SlickHList, SlickHList, Model](
      shapedValue,
      from1.compose(modelGet.toIdentity),
      to1.andThen(modelSet.fromIdentity),
      modelClassTag = cst
    )
  }

  private def colN[T](name: String, func: ColumnOpt[T], tt: TypedType[T]): Rep[T] = {
    val columnName = func.name.getOrElse(name)
    val tpToUse    = func.typedType.getOrElse(tt)
    tb.column(columnName, func.opts: _*)(tpToUse)
  }

  def userRep(
    labelled: BasedInstalledSimpleProduct[F],
    opt: F[ColumnOpt],
    typedType: F[TypedType]
  ): F[Rep] = {
    val l1 = named.labelled.modelLabelled
    val l2 = opt
    val l3 = typedType

    val zipResult1 = zip3Generic.zip[({ type M1[_] = String })#M1, ColumnOpt, TypedType](l1, l2, l3)

    val mapFunction: MapGenerc.MapFunction[({ type F1[T] = (String, ColumnOpt[T], TypedType[T]) })#F1, Rep] =
      new MapGenerc.MapFunction[({ type F1[T] = (String, ColumnOpt[T], TypedType[T]) })#F1, Rep] {
        override def map[X1](t: (String, ColumnOpt[X1], TypedType[X1])): Rep[X1] = colN(t._1, t._2, t._3)
      }

    val mapResult = mapGeneric.map[({ type F1[T] = (String, ColumnOpt[T], TypedType[T]) })#F1, Rep](mapFunction)

    mapResult(zipResult1)
  }

}

import slick.collection.heterogeneous.HList.{HListShape => SlickHListShape}
import slick.collection.heterogeneous.{HCons => SlickHCons, HList => SlickHList, HNil => SlickHNil}

private class helperUtils[V <: JdbcProfile, ModelF[_[_]]](val slickProfile: V)(
  toListGeneric: ToListByTheSameTypeGeneric[ModelF],
  fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[ModelF]
) {
  import slickProfile.api._

  type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]]

  def toShape(t1: ModelF[ShapeF]): SlickHListShape[FlatShapeLevel, SlickHList, SlickHList, SlickHList] = {
    val toListFunc = toListGeneric.toListByTheSameType[ShapeF[Any], SlickHListShape[
      FlatShapeLevel,
      SlickHList,
      SlickHList,
      SlickHList
    ]](
      SlickHList.hnilShape.asInstanceOf[SlickHListShape[
        FlatShapeLevel,
        SlickHList,
        SlickHList,
        SlickHList
      ]],
      (sum, each) =>
        SlickHList
          .hconsShape(each, sum)
          .asInstanceOf[SlickHListShape[
            FlatShapeLevel,
            SlickHList,
            SlickHList,
            SlickHList
          ]]
    )

    val model2: ModelF[({ type X1[_] = Shape[_ <: FlatShapeLevel, Rep[Any], Any, Rep[Any]] })#X1] =
      t1.asInstanceOf[ModelF[({ type X1[_] = Shape[_ <: FlatShapeLevel, Rep[Any], Any, Rep[Any]] })#X1]]

    toListFunc(model2)
  }

  def toRep(t1: ModelF[Rep]): SlickHList = {
    val toListFunc = toListGeneric.toListByTheSameType[Rep[Any], SlickHList](
      SlickHNil,
      (sum, each) => each :: sum
    )

    val model2: ModelF[({ type X1[_] = Rep[Any] })#X1] = t1.asInstanceOf[ModelF[({ type X1[_] = Rep[Any] })#X1]]

    toListFunc(model2)
  }

  def fromModel(m: ModelF[({ type IdImpl[T] = T })#IdImpl]): SlickHList = {
    val toListFunc = toListGeneric.toListByTheSameType[Any, SlickHList](
      SlickHNil,
      (sum, each) => each :: sum
    )

    val model2: ModelF[({ type X1[_] = Any })#X1] = m.asInstanceOf[ModelF[({ type X1[_] = Any })#X1]]
    toListFunc(model2)
  }

  def toModel(m: SlickHList): ModelF[({ type IdImpl[T] = T })#IdImpl] = {
    val fromListFunc = fromListByTheSameTypeGeneric.fromListByTheSameType[Any, SlickHList](
      t => t.asInstanceOf[SlickHCons[Any, SlickHList]].head,
      t => t.asInstanceOf[SlickHCons[Any, SlickHList]].tail
    )

    fromListFunc(m).asInstanceOf[ModelF[({ type IdImpl[T] = T })#IdImpl]]
  }
}
