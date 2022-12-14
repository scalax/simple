package net.scalax.simple.nat.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._

trait ServiceB(xa: Transactor.Aux[IO, Unit]):
  def serviceA: ServiceA

  val y = xa.yolo
  import y._

end ServiceB

class ServiceBImpl[ServiceAEnv[_]: Getter, T[_]: Getter](sa: () => ServiceAEnv[ServiceA])(using T[Transactor.Aux[IO, Unit]])
    extends ServiceB(Getter.instance[T].get(summon)):
  override lazy val serviceA: ServiceA = Getter.instance[ServiceAEnv].get(sa())
end ServiceBImpl
