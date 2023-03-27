package net.scalax.simple
package codec

object SlickTest {

  case class Model[F[_]](name: F[Int], str: F[Option[String]], name11: F[String])

  type UModel[T[_]] = Model[T]

  def main(arr: Array[String]): Unit = {
    val tModel: ContextO[UModel]#EmptyTagF                 = TypeParameterBuilder[UModel].build[ContextI#EmptyTagF].generic
    implicit val noneFiller: EmptyTagModelFiller[UModel]   = EmptyTagModelFiller[UModel].build(tModel)
    implicit val length: ModelLength[UModel]               = ModelLength[UModel].generic
    implicit val setter: Setter[UModel]                    = Setter[UModel].generic
    implicit val modelListGetter: Getter[UModel]           = Getter[UModel].generic
    implicit val namesImplicit: LabelledNames[UModel]      = LabelledNames[UModel].generic
    implicit val namedModel: LabelledInstance[UModel]      = LabelledInstance[UModel].generic
    implicit val modelGetToMap: GetToMap[UModel]           = GetToMap[UModel].generic
    implicit val modelSetterFromMap: SetterFromMap[UModel] = SetterFromMap[UModel].generic
    implicit val zeroBasedIndex: XBasedIndex[UModel]       = XBasedIndex[UModel].generic

    import doobie._
    import doobie.implicits._
    import scala.concurrent.ExecutionContext
    import cats._
    import cats.data._
    import cats.effect._
    import cats.implicits._
    println(namedModel.model)
    val tableName = Fragment.const("a")
    println(namedModel.model)
    val namedModel1 = modelListGetter.output(namedModel.model).asInstanceOf[List[String]]
    val namedModel2 = namedModel1.map(t => Fragment.const(t))
    println(namedModel2)
    val namedModel3 = namedModel2.map(t => fr"$tableName.$t")
    val namedModel4 = namedModel3.intercalate(fr",")
    val sql5        = sql"""select $namedModel4 from tableA as a"""
    println(sql5.toString())
    val modelRead1: UModel[Read] = TypeParameterBuilder[UModel].build[Read].generic
    // 因为用了Generic这个Reader直接免了，拼接字符串就完事了
    val modelRead2: Read[ContextO[UModel]#IdF] =
      Traverse[List].sequence(modelListGetter.output(modelRead1).asInstanceOf[List[Read[Any]]]).map(u => setter.input[ContextI#IdF](u))
    println(modelRead1)
    println(modelRead2)
    val action: ConnectionIO[List[UModel[ContextI#IdF]]] = sql5.query[UModel[ContextI#IdF]].to[List]

  }

}
