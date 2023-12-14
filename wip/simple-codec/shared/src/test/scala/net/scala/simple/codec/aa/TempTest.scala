package net.scalax.simple
package codec11

import io.circe._
import io.circe.syntax._
import cats.effect._
import cats.~>
import net.scalax.simple.codec.{CompatLabelledInstalled, FillIdentity, IOApp1, LabelledInstalled}
import net.scalax.simple.codec.function_generic.{FuncIndex1, FuncIndex2, FunctionKCol}
import net.scalax.simple.codec.generic.SimpleFromProduct
import net.scalax.simple.codec.unzip_generic.{Func2Generic, ZipCommonGen}

case class CatNameScala11[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object TempTest11 extends IOApp {

  type UFAliasF[T11[_]] = CatNameScala11[({ type U1[_] = T11[String] })#U1]

  def simpleGen1[I[_]] = SimpleFromProduct[CatNameScala11, I].derived

  implicit val im111: Func2Generic[CatNameScala11] = new Func2Generic.Impl[CatNameScala11] {
    override def impl1[In1[_]] =
      _.derived2(simpleGen1[cats.Id].generic)(_.generic)(simpleGen1[In1].generic)
    override def impl2[In1[_], In2[_], In3[_]] = _.derived2(simpleGen1[cats.Id].generic)(_.generic)(
      simpleGen1[In1].generic,
      simpleGen1[In2].generic,
      simpleGen1[In3].generic
    )
  }

  implicit val im1: CompatLabelledInstalled[CatNameScala11] =
    CompatLabelledInstalled[CatNameScala11].derived(simpleGen1[CompatLabelledInstalled.ToNamed].generic)
  implicit val userNamedGeneric1: LabelledInstalled[CatNameScala11] = LabelledInstalled[CatNameScala11].derived
  implicit val im3: FillIdentity[CatNameScala11, Encoder] =
    FillIdentity[CatNameScala11, Encoder].derived2(simpleGen1[Encoder].generic)(_.generic)
  /*implicit val im4: CirceEncoderImplicit[CatNameScala2]  = CirceEncoderImplicit[CatNameScala2].derived
  implicit val im7: FillIdentity[CatNameScala2, IdentityGetter] =
    FillIdentity[CatNameScala2, IdentityGetter].derived1(simpleGen1[IdentityGetter].generic)
  implicit val im8: FillFuncInstance[CatNameScala2] = new FillFuncInstance.Impl1[CatNameScala2] {
    override def gen[I[_]] = _.derived4(_.generic)(simpleGen1[IdentityGetter].generic)(_.generic)(simpleGen1[I].generic)
  }
  implicit val im9: FuncTyped[CatNameScala2] = new FuncTyped.Impl1[CatNameScala2] {
    override def setter[In[_], Out[_]](set1: Set1[In, Out]): Set2[In, Out] = {
      type IO1[T] = FuncTyped.IOModel[In[T], Out[T]]
      set1.law[CatNameScala2[In], CatNameScala2[Out], CatNameScala2[IO1]].derived
    }
  }
  type JsonPaire[T] = (String, Json)
  implicit val im10: OutputBySameType[CatNameScala2, (String, Json), JsonPaire] =
    OutputBySameType[CatNameScala2, (String, Json), JsonPaire].derived */
  implicit val im11: FuncIndex1[CatNameScala11] = new FuncIndex1[CatNameScala11] {
    override def input[In1[_], In2[_], Out[_]](
      func3k: CatNameScala11[FunctionKCol.Func3K[In1, In2, Out]#Input]
    ): (CatNameScala11[In1], CatNameScala11[In2]) => CatNameScala11[Out] = FuncIndex1[CatNameScala11, In1, In2, Out].derived2(
      simpleGen1[FunctionKCol.Func3K[In1, In2, Out]#Input].generic
    )(_.generic)(simpleGen1[In1].generic, simpleGen1[In2].generic, simpleGen1[Out].generic)(func3k)
  }
  implicit val im12: FuncIndex2[CatNameScala11] = FuncIndex2[CatNameScala11].derived(implicitly)
  implicit val im112: ZipCommonGen[CatNameScala11] = new ZipCommonGen.Impl[CatNameScala11] {
    override def impl[In1[_], In2[_]] =
      _.derived2(simpleGen1[FuncImpl[In1, In2]#Zip].generic)(_.generic)(simpleGen1[In1].generic, simpleGen1[In2].generic)
  }
  /*implicit val im13: FuncIndex3[CatNameScala2] = new FuncIndex3[CatNameScala2] {
    override def input[In1[_]](func3k: FunctionKCol.Func1K[In1]): CatNameScala2[In1] =
      FuncIndex3[CatNameScala2, In1].derived2(simpleGen1[In1].generic)(_.generic)(func3k)
  }
  implicit val im14: FuncIndex4[CatNameScala2] = FuncIndex4[CatNameScala2].derived2(implicitly)(implicitly)
  implicit val im15: FuncIndex5[CatNameScala2] = FuncIndex5[CatNameScala2].derived2(implicitly)(implicitly)

  type U1[_] = Encoder[String]
  type U2[_] = String
  type U4[_] = IdentityGetter[String]
  implicit val uuj2: LabelledInstalled[UFAliasF] = LabelledInstalled[UFAliasF].instance(LabelledInstalled[CatNameScala2].summon.model)
  implicit val uuj3: FillIdentity[UFAliasF, Encoder] =
    FillIdentity[UFAliasF, Encoder].derived1(simpleGen1[({ type U1[_] = Encoder[String] })#U1].generic)
  implicit val uuj4: CirceEncoderImplicit[UFAliasF] =
    CirceEncoderImplicit[UFAliasF].law[CatNameScala2[LabelledInstalled.ToNamed], CatNameScala2[U1], CatNameScala2[U2]].derived
  implicit val uuj6: FillIdentity[UFAliasF, cats.Id] =
    FillIdentity[UFAliasF, cats.Id].instance(LabelledInstalled[CatNameScala2].summon.model)

  implicit val uuj8: FillFuncInstance[UFAliasF] = new FillFuncInstance[UFAliasF] {
    override def fill[I[_]](i: IdentityGetter.FGen[I]): UFAliasF[I] = {
      implicitly[FillFuncInstance[CatNameScala2]]
        .fill[({ type F1[T] = I[String] })#F1](new IdentityGetter.FGen[({ type F1[T] = I[String] })#F1] {
          override def gen[T]: I[String] = i.gen[String]
        })
    }
  }
  implicit val uuj9: FuncTyped[UFAliasF] = new FuncTyped[UFAliasF] {
    override def fill[In[_], Out[_]](func: In ~> Out): UFAliasF[In] => UFAliasF[Out] = {
      val funcInstance: ({ type F1[T] = In[String] })#F1 ~> ({ type F2[T] = Out[String] })#F2 = new (({ type F1[T] = In[String] })#F1 ~>
        ({ type F2[T] = Out[String] })#F2) {
        override def apply[T](t: In[String]): Out[String] = func(t)
      }
      implicitly[FuncTyped[CatNameScala2]].fill[({ type F1[T] = In[String] })#F1, ({ type F2[T] = Out[String] })#F2](funcInstance)
    }
  }
  implicit val uuj10: OutputBySameType[UFAliasF, (String, Json), JsonPaire] = new OutputBySameType[UFAliasF, (String, Json), JsonPaire] {
    override def model(input: CatNameScala2[JsonPaire]): List[(String, Json)] =
      implicitly[OutputBySameType[CatNameScala2, (String, Json), JsonPaire]].model(input)
  }

  val modelNameProperty: CatNameScala2[U2] = uuj2.model
  val modelInstance: CatNameScala2[cats.Id] = CatNameScala2[cats.Id](
    name = 8594,
    str = Option("sdfwerwfweher迷雾日哦"),
    uClass = Option.empty,
    name11 = "xxiwerwjkl",
    namexu = "jerokwjoe收代理费加沃尔"
  )

  implicit val im5: Encoder[CatNameScala2[cats.Id]] = im4.model
  implicit val uuj5: Encoder[CatNameScala2[U2]]     = uuj4.model*/

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(im1.model))
      // _ <- IO(println(modelInstance.asJson.spaces2))
      // _ <- IO(println(modelNameProperty.asJson.spaces2))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
