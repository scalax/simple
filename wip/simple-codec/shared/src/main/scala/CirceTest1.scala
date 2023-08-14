package net.scalax.simple.codec
package aa

import io.circe._

object CirceModelSample {

  case class UserAbs[F[_], U[_]](id: F[U[Int]], first: F[String], last: F[String])

  type Id[T]           = T
  type StringAny[T]    = String
  type JsonAny[T]      = Json
  type NamedJsonAny[T] = (String, Json)

  def encoderProps[U[_]](implicit u: Encoder[U[Int]]): UserAbs[Encoder, U] = UserAbs[Encoder, U](implicitly, implicitly, implicitly)
  def named[U[_]]: UserAbs[StringAny, U] = UserAbs[StringAny, U](id = "id", first = "first", last = "last")

  def encoder[U[_]](implicit u: Encoder[U[Int]]): Encoder[UserAbs[Id, U]] = {
    val enProps  = encoderProps[U]
    val nameProp = named[U]

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
