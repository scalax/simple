package net.scalax.simple.adt
package impl

import core.*

trait TypeAdtImplicitOptsPolyHigher extends TypeAdtImplicitOptsPolyLower with AdtApply:
  inline given [A, B <: A, Tail <: Tuple]: TypeAdt.Aux[B, A *: Tail, ConfirmSucceed] = new TypeAdt[B, A *: Tail] {
    type State = ConfirmSucceed
    override def input(typeAdtGetter: TypeAdtGetter, value: Any): AdtList = new AdtListZero {
      override def method1(m: FoldList): FoldList = {
        typeAdtGetter.value = m.asInstanceOf[Any => Any](value)
        m
      }
    }
  }
end TypeAdtImplicitOptsPolyHigher

trait TypeAdtImplicitOptsPolyLower extends LowerLevelPoly:
  inline given [A, B, Tail <: Tuple](using inline adt: TypeAdt.Aux[B, Tail, ConfirmSucceed]): TypeAdt.Aux[B, A *: Tail, ConfirmSucceed] =
    new TypeAdt[B, A *: Tail] {
      type State = ConfirmSucceed
      override def input(typeAdtGetter: TypeAdtGetter, value: Any): AdtList = new AdtListPositive(adt.input(typeAdtGetter, value))
    }
end TypeAdtImplicitOptsPolyLower

trait AdtApply:
  inline final def get[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F] = null
end AdtApply
