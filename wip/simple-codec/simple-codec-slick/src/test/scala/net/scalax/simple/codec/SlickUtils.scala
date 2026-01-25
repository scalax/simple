package net.scalax.simple.codec
package aa

import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance}
import slick.ast.TypedType
import slick.jdbc.JdbcProfile

trait SlickUtils[V <: JdbcProfile] {
  val slickProfile: V

  import slickProfile.api._

  abstract class CommonTable[F[_[_]], Model](_tableTag: Tag, _schemaName: Option[String], _tableName: String)(implicit
    typedType: F[TypedType],
    userShapeGeneric: F[({ type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]] })#ShapeF],
    classTag: scala.reflect.ClassTag[Model],
    modelGet: ModelGet[F, Model],
    modelSet: ModelSet[F, Model],
    basedInstalled: BasedInstalledSimpleProduct[F],
    basedInstalledlabelled: BasedInstalledLabelled[F]
  ) extends Table[Model](_tableTag = _tableTag, _schemaName = _schemaName, _tableName = _tableName) {
    CommonTableSelf =>

    def this(_tableTag: Tag, _tableName: String)(implicit
      typedType: F[TypedType],
      userShapeGeneric: F[({ type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]] })#ShapeF],
      classTag: scala.reflect.ClassTag[Model],
      modelGet: ModelGet[F, Model],
      modelSet: ModelSet[F, Model],
      basedInstalled: BasedInstalledSimpleProduct[F],
      basedInstalledlabelled: BasedInstalledLabelled[F]
    ) = this(_tableTag = _tableTag, _schemaName = None, _tableName = _tableName)

    type Columns = F[Rep]
    type ColOpt  = F[ColumnOpt]

    private def colOpt: F[ColumnOpt] = SimpleFill[F]
      .derived(basedInstalled.basedInstalled.simpleProduct1)
      .fill[ColumnOpt](new SimpleFill.FillI[ColumnOpt] {
        override def fill[T]: ColumnOpt[T] = ColumnOpt.default[T]
      })

    def columnOption: ColOpt => ColOpt

    private val utilsWrap: UtilsWrap[F, Model, slickProfile.type] =
      new UtilsWrap[F, Model, slickProfile.type](slickProfile, basedInstalled, basedInstalledlabelled) {
        override val tb: Table[Model] = CommonTableSelf
      }

    val repModel: Columns = utilsWrap.userRep(basedInstalled, columnOption(colOpt), typedType)

    override def * : slick.lifted.ProvenShape[Model] = utilsWrap.mapShape(userShapeGeneric, repModel, classTag, modelGet, modelSet)
  }

  abstract class CommonTableF[F[_[_]]](_tableTag: Tag, _schemaName: Option[String], _tableName: String)(implicit
    typedType: F[TypedType],
    userShapeGeneric: F[({ type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]] })#ShapeF],
    classTag: scala.reflect.ClassTag[F[({ type IDF[XU] = XU })#IDF]],
    basedInstalled: BasedInstalledSimpleProduct[F],
    basedInstalledlabelled: BasedInstalledLabelled[F]
  ) extends CommonTable[F, F[({ type IDF[XU] = XU })#IDF]](_tableTag = _tableTag, _schemaName = _schemaName, _tableName = _tableName)(
        typedType = typedType,
        userShapeGeneric = userShapeGeneric,
        classTag = classTag,
        basedInstalled = basedInstalled,
        basedInstalledlabelled = basedInstalledlabelled,
        modelGet = identity[F[({ type IDF[XU] = XU })#IDF]],
        modelSet = identity[F[({ type IDF[XU] = XU })#IDF]]
      ) {
    CommonTableSelf =>

    def this(_tableTag: Tag, _tableName: String)(implicit
      typedType: F[TypedType],
      userShapeGeneric: F[({ type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]] })#ShapeF],
      classTag: scala.reflect.ClassTag[F[({ type IDF[XU] = XU })#IDF]],
      basedInstalled: BasedInstalledSimpleProduct[F],
      basedInstalledlabelled: BasedInstalledLabelled[F]
    ) = this(_tableTag = _tableTag, _schemaName = None, _tableName = _tableName)

  }

  abstract class CommonTablePojo[Model](_tableTag: Tag, _schemaName: Option[String], _tableName: String)(implicit
    typedType: PojoInstance[TypedType, Model],
    userShapeGeneric: PojoInstance[({ type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]] })#ShapeF, Model],
    classTag: scala.reflect.ClassTag[Model],
    modelGet: ModelGet[({ type PojoF[XU[_]] = PojoInstance[XU, Model] })#PojoF, Model],
    modelSet: ModelSet[({ type PojoF[XU[_]] = PojoInstance[XU, Model] })#PojoF, Model],
    basedInstalled: BasedInstalledSimpleProduct[({ type TypeF[UX[_]] = PojoInstance[UX, Model] })#TypeF],
    basedInstalledlabelled: BasedInstalledLabelled[({ type TypeF[UX[_]] = PojoInstance[UX, Model] })#TypeF]
  ) extends CommonTable[({ type PojoF[XU[_]] = PojoInstance[XU, Model] })#PojoF, Model](
        _tableTag = _tableTag,
        _schemaName = _schemaName,
        _tableName = _tableName
      )
      with PojoInstance[Rep, Model] {
    CommonTableSelf =>

    def this(_tableTag: Tag, _tableName: String)(implicit
      typedType: PojoInstance[TypedType, Model],
      userShapeGeneric: PojoInstance[({ type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]] })#ShapeF, Model],
      classTag: scala.reflect.ClassTag[Model],
      modelGet: ModelGet[({ type PojoF[XU[_]] = PojoInstance[XU, Model] })#PojoF, Model],
      modelSet: ModelSet[({ type PojoF[XU[_]] = PojoInstance[XU, Model] })#PojoF, Model],
      basedInstalled: BasedInstalledSimpleProduct[({ type TypeF[UX[_]] = PojoInstance[UX, Model] })#TypeF],
      basedInstalledlabelled: BasedInstalledLabelled[({ type TypeF[UX[_]] = PojoInstance[UX, Model] })#TypeF]
    ) = this(_tableTag = _tableTag, _schemaName = None, _tableName = _tableName)

    override def instance: Any = CommonTableSelf.repModel.instance

  }

}
