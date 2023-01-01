package net.scalax.simple.adt

import core._

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
trait TypeAdt[Input, Sum] {
  def input(value: Any): AdtList
}

object TypeAdt extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum, S <: AdtStatus] = TypeAdt[Input, Sum] { type State = S }
  object alias extends impl.TypeAdtAlias
}

trait LowerLevelPoly {
  private val failedValue: TypeAdt.Aux[Any, Any, ConfirmFailed] = new TypeAdt[Any, Any] {
    type State = ConfirmFailed
    override def input(value: Any): AdtList = AdtList.exception
  }
  implicit def adtFailedResult[I, S]: TypeAdt.Aux[I, S, ConfirmFailed] = failedValue.asInstanceOf[TypeAdt.Aux[I, S, ConfirmFailed]]
}
