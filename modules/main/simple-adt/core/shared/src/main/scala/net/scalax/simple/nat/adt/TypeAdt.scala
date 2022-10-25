package net.scalax.simple.nat.adt

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdt[Input, Sum](val index: Int) extends AnyVal

object TypeAdt extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum, S <: AdtStatus] = TypeAdt[Input, Sum] { type State = S }
  object alias extends impl.TypeAdtAlias
}

trait LowerLevelPoly {
  private val failedValue: TypeAdt.Aux[Any, Any, ConfirmFailed]        = TypeAdt.lift(new TypeAdt[Any, Any](-1))
  implicit def adtFailedResult[I, S]: TypeAdt.Aux[I, S, ConfirmFailed] = failedValue.asInstanceOf[TypeAdt.Aux[I, S, ConfirmFailed]]
}
