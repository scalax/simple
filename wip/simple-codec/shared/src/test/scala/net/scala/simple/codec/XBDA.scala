package net.scalax.simple
package codec

object SlickTest {

  case class Model[F[_]](name: F[Int], str: F[Option[String]],  name11: F[String])

  type UModel[T[_]] = Model[T]

  def main(arr: Array[String]): Unit = {
    val tModel: ContextO[UModel]#TagF                      = TypeParameterBuilder[UModel].build[ContextI#Tag].generic
    implicit val noneFiller: EmptyTagModelFiller[UModel]   = EmptyTagModelFiller[UModel].build(tModel)
    implicit val length: ModelLength[UModel]               = ModelLength[UModel].generic
    implicit val setter: Setter[UModel]                    = Setter[UModel].generic
    implicit val namesImplicit: LabelledNames[UModel]      = LabelledNames[UModel].generic
    implicit val namedModel: LabelledInstance[UModel]      = LabelledInstance[UModel].generic
    implicit val modelListGetter: Getter[UModel]           = Getter[UModel].generic
    implicit val modelGetToMap: GetToMap[UModel]           = GetToMap[UModel].generic
    implicit val modelSetterFromMap: SetterFromMap[UModel] = SetterFromMap[UModel].generic
    implicit val zeroBasedIndex: XBasedIndex[UModel]       = XBasedIndex[UModel].generic

    11
  }

}
