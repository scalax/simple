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
    println(namedModel.model) // Model(name,str,name11)
    val tableName     = "a"
    val tableFragment = Fragment.const(tableName)
    val namedModel1   = namedModel.map(_ => tableName + ".")
    println(namedModel1.model) // Model(a.,a.,a.)
    val namedModel2 = namedModel.map(_ => " as ")
    println(namedModel2.model) // Model( as , as , as )
    val namedModel3 = namedModel.map(t => s"r_$t")
    println(namedModel3.model) // Model(r_name,r_str,r_name11)
    val namedModel4 = namedModel1.concat(namedModel.model).concat(namedModel2.model).concat(namedModel3.model)
    println(namedModel4.model) // Model(a.name as r_name,a.str as r_str,a.name11 as r_name11)
    val namedModel5: LabelledNames[UModel] = LabelledNames[UModel].build(namedModel4)
    println(namedModel5.names: List[String]) // List(a.name as r_name, a.str as r_str, a.name11 as r_name11)
    val str6: String = namedModel5.names.intercalate(", ")
    println(str6) // a.name as r_name, a.str as r_str, a.name11 as r_name11
    val namedModel6 = Fragment.const(str6)
    val sql5        = sql"""select $namedModel6 from tableA as $tableFragment"""
    println(sql5.toString())          // Fragment("select a.name as r_name, a.str as r_str, a.name11 as r_name11  from tableA as a ")
    println(namedModel3.model.name11) // r_name11
    val modelRead1: UModel[Read] = TypeParameterBuilder[UModel].build[Read].generic
    // 因为用了Generic这个Reader直接免了，拼接字符串就完事了
    implicit val modelRead2: Read[ContextO[UModel]#IdF] =
      Traverse[List].sequence(modelListGetter.output(modelRead1).asInstanceOf[List[Read[Any]]]).map(u => setter.input[ContextI#IdF](u))
    val action: ConnectionIO[List[UModel[ContextI#IdF]]] = sql5.query[UModel[ContextI#IdF]].to[List]
  }

}
