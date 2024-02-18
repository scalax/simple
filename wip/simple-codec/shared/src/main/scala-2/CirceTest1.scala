package net.scalax.simple.codec
package aa

import io.circe._
import net.scalax.simple.codec.aa.Model2.{simpleGen1, UserAbsAlias}
import net.scalax.simple.codec.generic.SimpleFromProduct
import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric1, ToDecoderGeneric2222, ToListGeneric}
import net.scalax.simple.codec.unzip_generic.Func50Generic

object CirceModelSample {

  case class UserAbs[F[_], U[_]](id: F[U[Int]], first: F[String], last: F[String])

  type Id[T]           = T
  type JsonAny[T]      = Json
  type NamedJsonAny[T] = (String, Json)

  class UserAbsAlias[U[_]] {
    type F1[E1[_]] = UserAbs[E1, U]
  }

  def simpleGen1[U[_], I[_]] = SimpleFromProduct[UserAbsAlias[U]#F1, I].law[UserAbs[I, U]].derived

  /*def im111[U[_]]: Function50Generic[UserAbsAlias[U]#F1] = new Func50Generic.Impl[UserAbsAlias[U]#F1] {
    override def impl1[In1[_]] = _.derived2(simpleGen1[U, cats.Id].generic, simpleGen1[U, In1].generic)(_.generic)
    override def impl2[In1[_], In2[_], In3[_]] =
      _.derived2(simpleGen1[U, cats.Id].generic, simpleGen1[U, In1].generic, simpleGen1[U, In2].generic, simpleGen1[U, In3].generic)(
        _.generic
      )
  }*/
  def deco1_1[U[_]]: ToDecoderGeneric[UserAbsAlias[U]#F1] = new ToDecoderGeneric.Impl[UserAbsAlias[U]#F1] {
    override def impl[M1[_, _], M2[_], M3[_]] =
      _.derived2(simpleGen1[U, cats.Id].generic, simpleGen1[U, M2].generic, simpleGen1[U, M3].generic)(
        _.generic
      )
  }
  def deco1_2[U[_]]: ToDecoderGeneric2222[UserAbsAlias[U]#F1] = new ToDecoderGeneric2222.Impl[UserAbsAlias[U]#F1] {
    override def impl[M1[_, _, _], M2[_], M3[_], M4[_]] =
      _.derived2(simpleGen1[U, cats.Id].generic, simpleGen1[U, M2].generic, simpleGen1[U, M3].generic, simpleGen1[U, M4].generic)(_.generic)
  }

  def namedPrepare[U[_]]: CompatLabelledInstalled[UserAbsAlias[U]#F1] =
    CompatLabelledInstalled[UserAbsAlias[U]#F1].derived(simpleGen1[U, CompatLabelledInstalled.ToNamed].generic)

  implicit def basedInstalled1[U[_]]: BasedInstalled[UserAbsAlias[U]#F1] =
    BasedInstalled[UserAbsAlias[U]#F1].derived(namedPrepare[U], deco1_1[U], deco1_2[U])

  implicit def encoderProps[U1[_]](implicit u: Encoder[U1[Int]]): FillIdentity[UserAbsAlias[U1]#F1, Encoder] =
    FillIdentity[UserAbsAlias[U1]#F1, Encoder].derived2(simpleGen1[U1, Encoder].generic)(_.generic)

  def encoder[U[_]](implicit typeEncoder: Encoder[U[Int]], basedInstalled: BasedInstalled[UserAbsAlias[U]#F1]): Encoder[UserAbs[Id, U]] = {
    val nameProp   = basedInstalled.labelled.model
    val enProps    = implicitly[FillIdentity[UserAbsAlias[U]#F1, Encoder]].model
    val toListFunc = ToListGeneric[UserAbsAlias[U]#F1].derived(basedInstalled)

    Encoder.instance { u =>
      /*val tempModel = funcAction.function3(new Function3Apply[Id, LabelledInstalled.ToNamed, Encoder, NamedJsonAny] {
        override def apply[X](i1: X, i2: String, i3: Encoder[X]): (String, Json) = i2 -> i3(i1)
      })(u, nameProp, enProps)

      val modelCol = toListFunc.toList[(String, Json)](tempModel)

      Json.fromJsonObject(JsonObject.fromIterable(modelCol))*/
      ???
    }
  }

}
