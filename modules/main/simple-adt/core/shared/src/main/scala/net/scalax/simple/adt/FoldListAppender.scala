package net.scalax.simple.adt

import CoreInstance._

object FoldListAppender {
  @inline def append(data: Any, func: Any => Any, core2Tail: () => Core2): Core2 =
    TypeGetterByCore2(data = data, func = func, core2Tail = core2Tail)
}

case class TypeGetterByCore2(data: Any, func: Any => Any, core2Tail: () => Core2) extends TypeAdtGetter with Core2 {
  override def runGetter(adtConvert: TypeAdt.Context[Any, Any, Any]): Any = func(adtConvert.input(data))
  override def apply(other: () => Core2): Core2                           = FoldListPositive(core2Tail)(other)
}

case class AdtConvertWrapper(result: Core2, convert: TypeAdt.Context[Any, Any, Any]) extends Core2 {
  override def apply(t: () => Core2): Core2 = throw new Exception
}
