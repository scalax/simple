package net.scalax.simple.nat.adt

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdt[Input, Sum, State <: AdtStatus](val index: Int) extends AnyVal

object TypeAdt extends impl.TypeAdtImplicitOptsPolyHigher {
  object alias extends impl.TypeAdtAlias
}

trait LowerLevelPoly {
  private val failedValue: TypeAdt[Any, Any, ConfirmFailed]        = new TypeAdt(-1)
  implicit def adtFailedResult[I, S]: TypeAdt[I, S, ConfirmFailed] = failedValue.asInstanceOf[TypeAdt[I, S, ConfirmFailed]]
}
