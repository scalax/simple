package net.scalax.simple.adt

import CoreInstance._

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdt[Input, Sum](val value: Core2) extends AnyVal

object TypeAdt extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum, S <: AdtStatus] = TypeAdt[Input, Sum] { type State = S }
  def apply[Input, Sum, S <: AdtStatus](input: Core2): TypeAdt.Aux[Input, Sum, S] =
    new TypeAdt[Any, Any](input).asInstanceOf[TypeAdt.Aux[Input, Sum, S]]
  object alias extends impl.TypeAdtAlias
}

trait LowerLevelPoly {
  private val failedValue: TypeAdt.Aux[Any, Any, ConfirmFailed]        = TypeAdt(AdtListException)
  implicit def adtFailedResult[I, S]: TypeAdt.Aux[I, S, ConfirmFailed] = failedValue.asInstanceOf[TypeAdt.Aux[I, S, ConfirmFailed]]
}
