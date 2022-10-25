package net.scalax.simple.nat.adt
package impl
import net.scalax.simple.nat.adt.TypeAdt

trait TypeAdtImplicitOptsPolyHigher extends TypeAdtImplicitOptsPolyLower with AdtApply:
  inline given [A, B <: A, T <: Tuple](using inline v: ValueOf[Tuple.Size[A *: T]]): TypeAdt.Aux[B, A *: T, ConfirmSucceed] =
    TypeAdt.lift(TypeAdt(v.value))
end TypeAdtImplicitOptsPolyHigher

trait TypeAdtImplicitOptsPolyLower extends LowerLevelPoly:
  inline given [A, B, T <: Tuple](using inline adt: TypeAdt.Aux[B, T, ConfirmSucceed]): TypeAdt.Aux[B, A *: T, ConfirmSucceed] =
    adt.asInstanceOf[TypeAdt.Aux[B, A *: T, ConfirmSucceed]]
end TypeAdtImplicitOptsPolyLower

trait AdtApply:
  inline final def lift[A, B, T <: AdtStatus](inline typeAdt: TypeAdt[A, B]): TypeAdt.Aux[A, B, T] =
    typeAdt.asInstanceOf[TypeAdt.Aux[A, B, T]]
  inline final def get[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F] = null
end AdtApply
