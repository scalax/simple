package net.scalax.simple.codec
package aa

import io.circe._

object CirceModelSample {

  case class UserAbs[F[_], U[_]](id: F[U[Int]], first: F[String], last: F[String])

  type Id[T]           = T
  type JsonAny[T]      = Json
  type NamedJsonAny[T] = (String, Json)

  class UserAbsAlias[U[_]] {
    type F1[E1[_]] = UserAbs[E1, U]
  }

  implicit def userNamedGeneric2[U[_]]: SymbolLabelledInstalled[UserAbsAlias[U]#F1] = SymbolLabelledInstalled[UserAbsAlias[U]#F1].derived
  implicit def named[U[_]]: LabelledInstalled[UserAbsAlias[U]#F1]                   = LabelledInstalled[UserAbsAlias[U]#F1].derived
  implicit def encoderProps[U[_]](implicit u: Encoder[U[Int]]): FillIdentity[UserAbsAlias[U]#F1, Encoder] =
    FillIdentity[UserAbsAlias[U]#F1, Encoder].derived

  def encoder[U[_]](implicit u: Encoder[U[Int]]): Encoder[UserAbs[Id, U]] = {
    val enProps  = encoderProps[U].model
    val nameProp = named[U].model

    Encoder.instance { u =>
      val jsonModel: UserAbs[JsonAny, U] =
        UserAbs[JsonAny, U](id = enProps.id(u.id), first = enProps.first(u.first), last = enProps.last(u.last))

      val namedModel: UserAbs[NamedJsonAny, U] = UserAbs[NamedJsonAny, U](
        id = (nameProp.id, jsonModel.id),
        first = (nameProp.first, jsonModel.first),
        last = (nameProp.last, jsonModel.last)
      )

      Json.fromJsonObject(JsonObject.fromIterable(List(namedModel.id, namedModel.first, namedModel.last)))
    }
  }

}
