package net.scalax.simple.adt

trait TypeAdtGetter {
  def runGetter(adtConvert: TypeAdt.Context[Any, Any, Any]): Any
}
