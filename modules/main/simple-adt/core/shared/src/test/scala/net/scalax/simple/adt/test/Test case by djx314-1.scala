package net.scalax.simple.adt.core
package test

import scala.collection.compat._

import zio._
import zio.test._
import zio.test.Assertion._

import net.scalax.simple.core.Core2

object SimpleAdtCoreBuilder {

  def build1(i1: Int, i2: Int): Int = {
    var i3: Int = 0
    def i1InitNumber(i1Impl: Int): Core2 = if (i1Impl > 0)
      Core2 { other =>
        i3 = i3 + 1
        AdtCoreFactory.Number1(() => i1InitNumber(i1Impl - 1))(other)
      }
    else AdtCoreFactory.Number3

    def i2InitNumber(i2Impl: Int): Core2 = if (i2Impl > 0)
      Core2 { other =>
        AdtCoreFactory.Number1(() => i2InitNumber(i2Impl - 1))(other)
      }
    else AdtCoreFactory.Number2

    val number1 = i1InitNumber(i1)
    val number2 = i2InitNumber(i2)

    number1(() => number2)

    i3
  }

  def build2(i1: Int, i2: Int): Int = {
    var i3: Int = 0

    def i1InitNumber(i1Impl: Int): Core2 = if (i1Impl > 0)
      Core2 { other =>
        i3 = i3 + 1
        AdtCoreFactory.Number1(() => i1InitNumber(i1Impl - 1))(other)
      }
    else AdtCoreFactory.Number3

    def i2InitNumber(i2Impl: Int): Core2 = if (i2Impl > 0)
      Core2 { other =>
        AdtCoreFactory.Number1(() => i2InitNumber(i2Impl - 1))(other)
      }
    else AdtCoreFactory.Number2

    val number1 = i1InitNumber(i1)
    val number2 = i2InitNumber(i2)

    number2(() => number1)

    i3
  }

  def build3(i1: Int, i2: Int): Int = {
    var i3: Int = 0

    def i1InitNumber(i1Impl: Int): Core2 = if (i1Impl > 0)
      Core2 { other =>
        AdtCoreFactory.Number1(() => i1InitNumber(i1Impl - 1))(other)
      }
    else AdtCoreFactory.Number3

    def i2InitNumber(i2Impl: Int): Core2 = if (i2Impl > 0)
      Core2 { other =>
        i3 = i3 + 1
        AdtCoreFactory.Number1(() => i2InitNumber(i2Impl - 1))(other)
      }
    else AdtCoreFactory.Number2

    val number1 = i1InitNumber(i1)
    val number2 = i2InitNumber(i2)

    number1(() => number2)

    i3
  }

  def build4(i1: Int, i2: Int): Int = {
    var i3: Int = 0

    def i1InitNumber(i1Impl: Int): Core2 = if (i1Impl > 0)
      Core2 { other =>
        AdtCoreFactory.Number1(() => i1InitNumber(i1Impl - 1))(other)
      }
    else AdtCoreFactory.Number3

    def i2InitNumber(i2Impl: Int): Core2 = if (i2Impl > 0)
      Core2 { other =>
        i3 = i3 + 1
        AdtCoreFactory.Number1(() => i2InitNumber(i2Impl - 1))(other)
      }
    else AdtCoreFactory.Number2

    val number1 = i1InitNumber(i1)
    val number2 = i2InitNumber(i2)

    number2(() => number1)

    i3
  }

}

object TestCaseFoeSimpleAdtCore extends ZIOSpecDefault {
  override def spec: Spec[TestEnvironment with Scope, Any] = suite("Test case for simple-adt-core")(
    test("test1.") {
      check(Gen.int(0, 100), Gen.int(0, 100)) { (a, b) =>
        val result1 = SimpleAdtCoreBuilder.build1(a, b)
        val result2 = math.min(a, b + 1)
        assert(result1)(Assertion.equalTo(result2))
      }
    },
    test("test2.") {
      check(Gen.int(0, 100), Gen.int(0, 100)) { (a, b) =>
        val result1 = SimpleAdtCoreBuilder.build2(a, b)
        val result2 = math.min(a, b)
        assert(result1)(Assertion.equalTo(result2))
      }
    },
    test("test3.") {
      check(Gen.int(0, 100), Gen.int(0, 100)) { (a, b) =>
        val result1 = SimpleAdtCoreBuilder.build3(a, b)
        val result2 = math.min(a, b)
        assert(result1)(Assertion.equalTo(result2))
      }
    },
    test("test4.") {
      check(Gen.int(0, 100), Gen.int(0, 100)) { (a, b) =>
        val result1 = SimpleAdtCoreBuilder.build4(a, b)
        val result2 = math.min(a + 1, b)
        assert(result1)(Assertion.equalTo(result2))
      }
    }
  )
}
