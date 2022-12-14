package net.scalax.simple.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._

trait ServiceA(xa: Transactor.Aux[IO, Unit]):

  def serviceB: ServiceB

  val y = xa.yolo
  import y._

  def getByName(name: String): IO[String] = IO(println(serviceB.toString)) *> IO(s"Hello, $name.")

end ServiceA

class ServiceAImpl[ServiceBEnv[_]: Wire, T[_]: Wire](sb: () => ServiceBEnv[ServiceB])(using T[Transactor.Aux[IO, Unit]])
    extends ServiceA(Wire[T].unlift(summon)):
  override lazy val serviceB: ServiceB = Wire[ServiceBEnv].unlift(sb())
end ServiceAImpl
