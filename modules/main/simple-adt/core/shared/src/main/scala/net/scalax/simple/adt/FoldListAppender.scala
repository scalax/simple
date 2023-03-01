package net.scalax.simple
package adt

import nat.number9._
import core.Core2

object FoldListAppender {
  def appendAll(data: Any, list: List[Any => Any]): Number2 = list match {
    case head :: hTail =>
      new Number2S(tail = appendAll(data, hTail)) with TypeAdtGetter {
        override def runGetter(adtConvert: TypeAdt.Context[Any, Any, Any]): Any = head(adtConvert.input(data))
      }
    case Nil => Number2T
  }

  def result[T](core2: Core2): T = {
    val convert: TypeAdt.Context[Any, Any, Any] = core2 match {
      case t: TypeAdt.Context[Any, Any, Any] => t
    }
    val getter: TypeAdtGetter = core2 match {
      case Number2S(u: TypeAdtGetter) => u
    }
    getter.runGetter(convert).asInstanceOf[T]
  }
}
