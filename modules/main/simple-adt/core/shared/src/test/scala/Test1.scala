package net.scalax.simple.nat
package test

import adt.TypeAdt.{alias => adtAlias, get => getAdtApply}, adtAlias._
import net.scalax.simple.nat.adt.impl.FetchAdtApply
import scala.collection.compat._

import zio._
import zio.test._
import zio.test.Assertion._

object HelloWorldSpec extends ZIOSpecDefault {

  def inputOptDat[T: TypeOptions3[*, None.type, Some[Int], Option[Int]]](t: T): (String, Option[Int]) = {
    val applyM = getAdtApply[TypeOptions3[*, None.type, Some[Int], Option[Int]]]
    applyM.input(t).fold(n => ("None", n), n => ("Some", Some(n.get + 1)), n => ("Option", n.map(_ + 1)))
  }

  def spec = suite("HelloWorldSpec")(
    test("sayHello correctly displays output") {
      val bb = None
      val cc = inputOptDat(bb)
      assert(cc)(Assertion.equalTo(("None", bb)))
    }
  )
}
