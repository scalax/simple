package net.scalax.simple
package adt

import nat.number9._
import core.Core2

object FoldListAppender {
  def appendAll(list: List[Any => Any]): Number2 = list match {
    case head :: hTail =>
      new Number2S(tail = appendAll(list = hTail)) with TypeAdtGetter {
        override def executeFunction: Any => Any = head
      }
    case Nil => Number2T
  }

  def result[T](number: Core2, data: Any): T = {
    val convert: TypeAdt.Context[Any, Any, Any] = number match {
      case t: TypeAdt.Context[Any, Any, Any] => t
    }
    val getter: TypeAdtGetter = number match {
      case Number2S(u: TypeAdtGetter) => u
    }
    getter.executeFunction(convert.input(data)).asInstanceOf[T]
  }
}
