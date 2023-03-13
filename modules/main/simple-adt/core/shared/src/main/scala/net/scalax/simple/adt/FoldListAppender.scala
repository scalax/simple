package net.scalax.simple
package adt

import nat.number9._
import core.Core2
import com.thoughtworks.binding._
import com.thoughtworks.binding.Binding
import Binding._

object FoldListAppender {
  def appendAll(list: List[Any => Any]): Binding.Var[TypeAdtGetter] => Number2 = getterBinding =>
    list match {
      case head :: hTail =>
        new Number2S(tail = appendAll(list = hTail)(getterBinding)) {
          override def input(core2: => Core2): Number2 = {
            getterBinding.value = TypeAdtGetter(head)
            super.input(core2)
          }
        }
      case Nil => Number2T
    }

  def result[T](
    foldList: Binding.Var[TypeAdtGetter] => Core2,
    adtList: Binding.Var[TypeAdt.Context[Any, Any, Any]] => Core2,
    data: Any
  ): Binding.F[T] = {
    val adtContextVar: Binding.Var[TypeAdt.Context[Any, Any, Any]] = Binding.Var(null)
    val typeGetterVar: Binding.Var[TypeAdtGetter]                  = Binding.Var(null)

    val adtNumber  = adtList(adtContextVar)
    val foldNumber = foldList(typeGetterVar)

    val resultCompute = Binding {
      val convert: TypeAdt.Context[Any, Any, Any] = adtContextVar.bind
      val getter: TypeAdtGetter                   = typeGetterVar.bind
      getter.executeFunction(convert.input(data)).asInstanceOf[T]
    }

    foldNumber.input(adtNumber)

    resultCompute
  }
}
