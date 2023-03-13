package net.scalax.simple
package adt

import nat.number9._
import core.Core2
import com.thoughtworks.binding.Binding

object FoldListAppender {
  def appendAll(list: List[Any => Any]): Number2 = list match {
    case head :: hTail =>
      new Number2S(tail = appendAll(list = hTail)) with TypeAdtGetter {
        override def executeFunction: Any => Any = head
      }
    case Nil => Number2T
  }

  def result[T](number: Core2, adtList: Binding.Var[TypeAdt.Context[Any, Any, Any]] => Core2, data: Any): T = {
    val adtContextVar: Binding.Var[TypeAdt.Context[Any, Any, Any]] = Binding.Var(null)
    val adtNumber                                                  = adtList(adtContextVar)
    val numberResult                                               = adtNumber.input(number)
    val convert: TypeAdt.Context[Any, Any, Any]                    = adtContextVar.value
    val getter: TypeAdtGetter = numberResult match {
      case u: TypeAdtGetter => u
    }
    getter.executeFunction(convert.input(data)).asInstanceOf[T]
  }
}
