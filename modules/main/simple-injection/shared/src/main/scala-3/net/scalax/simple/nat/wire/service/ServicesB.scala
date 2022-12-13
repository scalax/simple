package net.scalax.simple.nat.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes

trait ServiceB:
  def serviceA: ServiceA
end ServiceB

class ServiceBImpl(sa: () => ServiceA) extends ServiceB:
  override lazy val serviceA: ServiceA = sa()
end ServiceBImpl
