package net.scalax.simple.adt

trait TypeAdtGetter {
  def runGetter(adtConvert: AdtContext[Any, Any, Any]): Any
}
