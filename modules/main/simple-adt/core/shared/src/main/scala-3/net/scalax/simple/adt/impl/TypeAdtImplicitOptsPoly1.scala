package net.scalax.simple.adt
package impl

import CoreInstance.*

trait TypeAdtImplicitOptsPolyHigher extends TypeAdtImplicitOptsPolyLower with AdtApply:

  inline given [A, B <: A, Tail <: Tuple]: TypeAdt.Aux[B, A *: Tail, ConfirmSucceed] =
    val zeroAdt: AdtListZero = new AdtListZero:
      override def apply(m: () => FoldList): FoldList =
        val valueM = super.apply(m)
        valueM.asInstanceOf[TypeAdtGetter].runGetter
        valueM
      end apply
    end zeroAdt

    TypeAdt(zeroAdt)
  end given

end TypeAdtImplicitOptsPolyHigher

trait TypeAdtImplicitOptsPolyLower extends LowerLevelPoly:
  inline given [A, B, Tail <: Tuple](using inline adt: TypeAdt.Aux[B, Tail, ConfirmSucceed]): TypeAdt.Aux[B, A *: Tail, ConfirmSucceed] =
    TypeAdt(AdtListPositive(() => adt.value))
  end given
end TypeAdtImplicitOptsPolyLower

trait AdtApply:
  inline final def get[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F] = null
end AdtApply
