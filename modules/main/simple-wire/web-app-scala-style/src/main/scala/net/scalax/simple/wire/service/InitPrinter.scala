package net.scalax.simple.wire
package service

import cats.effect._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.HttpRoutes
import doobie._
import model._
import cats._

class InitPrinter {

  def printAction(): Unit = {
    for (_ <- 1 to 10) {
      println("Project init...")
    }
  }

}
