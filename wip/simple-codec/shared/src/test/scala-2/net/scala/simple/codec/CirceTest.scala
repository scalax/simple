package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import cats.effect._
import cats.~>

case class CatNameScala2[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object scala2xbb11 extends IOApp {

  type UFAliasF[T11[_]] = CatNameScala2[({ type U1[_] = T11[String] })#U1]

  implicit val im1: SymbolLabelledInstalled[CatNameScala2]      = SymbolLabelledInstalled[CatNameScala2].derived2(_.generic)(_.generic)
  implicit val im2: LabelledInstalled[CatNameScala2]            = LabelledInstalled[CatNameScala2].derived
  implicit val im3: FillIdentity[CatNameScala2, Encoder]        = FillIdentity[CatNameScala2, Encoder].derived
  implicit val im4: CirceEncoderImplicit[CatNameScala2]         = CirceEncoderImplicit[CatNameScala2].derived
  implicit val im7: FillIdentity[CatNameScala2, IdentityGetter] = FillIdentity[CatNameScala2, IdentityGetter].derived
  implicit val im8: FillFuncInstance[CatNameScala2] = new FillFuncInstance.Impl1[CatNameScala2] {
    override def gen[I[_]] = _.derived4(_.generic)(_.generic)(_.generic)(_.generic)
  }
  implicit val im9: FuncTyped[CatNameScala2] = new FuncTyped.Impl1[CatNameScala2] {
    override def setter[In[_], Out[_]](set1: Set1[In, Out]): Set2[In, Out] = {
      type IO1[T] = FuncTyped.IOModel[In[T], Out[T]]
      set1.law[CatNameScala2[In], CatNameScala2[Out], CatNameScala2[IO1]].derived
    }
  }
  type JsonPaire[T] = (String, Json)
  implicit val im10: OutputBySameType[CatNameScala2, (String, Json), JsonPaire] =
    OutputBySameType[CatNameScala2, (String, Json), JsonPaire].derived

  type U1[_] = Encoder[String]
  type U2[_] = String
  type U4[_] = IdentityGetter[String]
  implicit val uuj2: LabelledInstalled[UFAliasF]     = LabelledInstalled[UFAliasF].instance(LabelledInstalled[CatNameScala2].summon.model)
  implicit val uuj3: FillIdentity[UFAliasF, Encoder] = FillIdentity[UFAliasF, Encoder].law[CatNameScala2[U1]].derived
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
  implicit val uuj5: Encoder[CatNameScala2[U2]]     = uuj4.model

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(modelInstance.asJson.spaces2))
      _ <- IO(println(modelNameProperty.asJson.spaces2))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
