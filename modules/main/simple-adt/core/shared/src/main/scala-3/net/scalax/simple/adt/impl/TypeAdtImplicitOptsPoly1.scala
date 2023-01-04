package net.scalax.simple.adt
package impl

import core.*

trait TypeAdtImplicitOptsPolyHigher extends TypeAdtImplicitOptsPolyLower with AdtApply:

  inline given [A, B <: A, Tail <: Tuple]: TypeAdt.Aux[B, A *: Tail, ConfirmSucceed] =
    val zeroAdt = new AdtListZero:
      override def method1(m: FoldList): FoldList =
        m.asInstanceOf[TypeAdtGetter].runGetter
        super.method1(m)
      end method1
    end zeroAdt

    TypeAdt(zeroAdt)
  end given

end TypeAdtImplicitOptsPolyHigher

trait TypeAdtImplicitOptsPolyLower extends LowerLevelPoly:
  inline given [A, B, Tail <: Tuple](using inline adt: TypeAdt.Aux[B, Tail, ConfirmSucceed]): TypeAdt.Aux[B, A *: Tail, ConfirmSucceed] =
    TypeAdt(new AdtListPositive(adt.value))
end TypeAdtImplicitOptsPolyLower

trait AdtApply:
  inline final def get[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F] = null
end AdtApply
