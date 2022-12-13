package net.scalax.simple.nat.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes

trait ServiceA:

  def serviceB: ServiceB

  def getByName(name: String): IO[String] = IO(println(serviceB.toString)) *> IO(s"Hello, $name.")

end ServiceA

class ServiceAImpl(sb: () => ServiceB) extends ServiceA:
  override lazy val serviceB: ServiceB = sb()
end ServiceAImpl
