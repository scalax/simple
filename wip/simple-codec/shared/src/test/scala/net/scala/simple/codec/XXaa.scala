package net.scalax.simple
package codec

object xxbb {

  case class Model[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Class[_]], name11: F[String])

  type UModel[T[_]] = Model[T]

  def main(arr: Array[String]): Unit = {
    implicit val setter: Setter[UModel]              = Setter.from
    implicit val noneFiller: NoneModelFiller[UModel] = NoneModelFiller.fill
    implicit val length: ModelLength[UModel]         = ModelLength.fill
    val value: ContextO[UModel]#IdF = setter.input[ContextI#IdF](List(2, Option("nnuu"), classOf[String], "sdfjowiejrowehreiowjhrtf"))
    implicit val namesImplicit: LabelledNames[UModel]      = LabelledNames.fill
    implicit val namedModel: LabelledInstance[UModel]      = LabelledInstance.fill
    implicit val modelListGetter: Getter[UModel]           = Getter.get
    implicit val modelGetToMap: GetToMap[UModel]           = GetToMap.get
    implicit val modelSetterFromMap: SetterFromMap[UModel] = SetterFromMap.setter
    println(length.length)
    println(length.length)
    println(namesImplicit.names)
    println(namesImplicit.names)
    println(namedModel.model)
    println(namedModel.model.name: String)
    println(namedModel.model.uClass: String)
    println(namedModel.model.str: String)
    println(namedModel.model.name11: String)
    println(value)
    println(value)
    println(modelListGetter.output[ContextI#IdF](value))
    println(modelListGetter.output[ContextI#IdF](value))
    println(modelListGetter.output[ContextI#NoneF](noneFiller.instance))
    println(modelListGetter.output[ContextI#StringF](namedModel.model))

    val map1 = modelGetToMap.output[ContextI#IdF](value)
    val map2 = modelGetToMap.output[ContextI#NoneF](noneFiller.instance)
    val map3 = modelGetToMap.output[ContextI#StringF](namedModel.model)
    println(map1)
    println(map2)
    println(map3)

    val setResult1 = modelSetterFromMap.set[ContextI#IdF](map1)
    val setResult2 = modelSetterFromMap.set[ContextI#NoneF](map2)
    val setResult3 = modelSetterFromMap.set[ContextI#StringF](map3)

    println(setResult1.str: Option[String])
    val var2: None.type = setResult2.uClass
    println(var2)
    val var3: String = setResult3.uClass
    val var4: String = setResult3.str
    val var5: String = setResult3.name
    println(var3)
    println(var4)
    println(var5)
  }

}
