package net.scalax.simple.adt
package impl

import CoreInstance.*

trait TypeAdtImplicitOptsPolyHigher extends TypeAdtImplicitOptsPolyLower:
  inline given [A, B <: A, Tail <: Tuple]: TypeAdtApply.Aux[B, A *: Tail, ConfirmSucceed] = TypeAdtApply(AdtListZero)
end TypeAdtImplicitOptsPolyHigher

trait TypeAdtImplicitOptsPolyLower extends LowerLevelPoly:
  inline given [A, B, Tail <: Tuple](using
    inline adt: TypeAdtApply.Aux[B, Tail, ConfirmSucceed]
  ): TypeAdtApply.Aux[B, A *: Tail, ConfirmSucceed] = TypeAdtApply(AdtListPositive(() => adt.value))
  end given
end TypeAdtImplicitOptsPolyLower
