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
class TypeAdtApply[Input, Sum](val value: Core2) extends AnyVal

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum, S <: AdtStatus] = TypeAdtApply[Input, Sum] { type State = S }
  def apply[Input, Sum, S <: AdtStatus](input: Core2): TypeAdtApply.Aux[Input, Sum, S] =
    new TypeAdtApply[Any, Any](input).asInstanceOf[TypeAdtApply.Aux[Input, Sum, S]]
}

trait LowerLevelPoly {
  private val failedValue: TypeAdtApply.Aux[Any, Any, ConfirmFailed] = TypeAdtApply(AdtListException)
  implicit def adtFailedResult[I, S]: TypeAdtApply.Aux[I, S, ConfirmFailed] =
    failedValue.asInstanceOf[TypeAdtApply.Aux[I, S, ConfirmFailed]]
}
