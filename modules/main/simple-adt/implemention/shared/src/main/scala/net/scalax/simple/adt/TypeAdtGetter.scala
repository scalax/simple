package net.scalax.simple.adt

trait TypeAdtGetter {
  def executeFunction: Any => Any
}

object TypeAdtGetter {
  def apply(func: Any => Any): TypeAdtGetter = new TypeAdtGetter {
    override val executeFunction: Any => Any = func
  }
}
