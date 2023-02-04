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
class TypeAdtApply[Input, Sum](val value: Core2)

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum, S <: AdtStatus, P] = TypeAdtApply[Input, Sum] { type State = S; type Poly = P }
  def apply[Input, Sum, S <: AdtStatus, P](input: Core2): TypeAdtApply.Aux[Input, Sum, S, P] =
    new TypeAdtApply[Any, Any](input).asInstanceOf[TypeAdtApply.Aux[Input, Sum, S, P]]
}

trait LowerLevelPoly {
  private val failedValue: TypeAdtApply.Aux[Any, Any, ConfirmFailed, Any] = TypeAdtApply(AdtListException)
  implicit def adtFailedResult[I, S, Poly]: TypeAdtApply.Aux[I, S, ConfirmFailed, Poly] =
    failedValue.asInstanceOf[TypeAdtApply.Aux[I, S, ConfirmFailed, Poly]]
}
