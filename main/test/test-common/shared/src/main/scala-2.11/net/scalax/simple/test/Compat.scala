package net.scalax.simple.test

import zio.test.TestResult

object SimpleCompat {

  implicit class bb(val t: TestResult.type) extends AnyVal {
    @inline def allSuccesses(assert: TestResult, asserts: TestResult*): TestResult = {
      val assertsSeq = assert +: asserts
      t.all(assertsSeq: _*)
    }
  }

}
