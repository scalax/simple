package net.scalax.simple
package adt

import nat.number9._
import core.Core2
import com.thoughtworks.binding.Binding

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
  ): T = {
    val adtContextVar: Binding.Var[TypeAdt.Context[Any, Any, Any]] = Binding.Var(null)
    val typeGetterVar: Binding.Var[TypeAdtGetter]                  = Binding.Var(null)

    val adtNumber  = adtList(adtContextVar)
    val foldNumber = foldList(typeGetterVar)

    foldNumber.input(adtNumber)

    val convert: TypeAdt.Context[Any, Any, Any] = adtContextVar.value
    val getter: TypeAdtGetter                   = typeGetterVar.value

    getter.executeFunction(convert.input(data)).asInstanceOf[T]
  }
}
