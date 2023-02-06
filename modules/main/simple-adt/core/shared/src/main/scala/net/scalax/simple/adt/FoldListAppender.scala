package net.scalax.simple.adt

import CoreInstance._

object FoldListAppender {
  @inline def append(data: Any, func: Any => Any, core2Tail: () => Core2): Core2 =
    TypeGetterByCore2(data = data, func = func, core2Tail = core2Tail)
}

case class TypeGetterByCore2(data: Any, func: Any => Any, core2Tail: () => Core2) extends TypeAdtGetter with Core2 {
  override def runGetter(adtConvert: AdtContext[Any, Any, Any]): Any = func(adtConvert.input(data))
  override def apply(other: () => Core2): Core2                      = FoldListPositive(core2Tail)(other)
}
