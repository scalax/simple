package net.scalax.simple
package adt

import core.Core2

object FoldListAppender {
  def appendAll(data: Any, list: List[Any => Any]): Number1 = list match {
    case head :: tail => new TypeGetterByCore2(data = data, func = head, core2Tail = appendAll(data, tail))
    case Nil          => Number1T
  }
}

class TypeGetterByCore2(data: Any, func: Any => Any, core2Tail: Number1) extends Number1S(core2Tail) with TypeAdtGetter {
  override def runGetter(adtConvert: TypeAdt.Context[Any, Any, Any]): Any = func(adtConvert.input(data))
}

class AdtConvertWrapper(convert: TypeAdt.Context[Any, Any, Any]) extends Number2T {
  override def input(t: => Core2): Number2 = new Number2T with AdtValueGetter { self: Number2T =>
    override def input(num1: => Core2): Number2 = self

    override def value: Any = t.asInstanceOf[TypeAdtGetter].runGetter(convert)
  }
}
