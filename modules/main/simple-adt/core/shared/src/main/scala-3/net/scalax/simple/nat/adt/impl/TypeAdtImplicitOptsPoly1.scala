package net.scalax.simple.nat.adt
package impl
import net.scalax.simple.nat.adt.TypeAdt

trait TypeAdtImplicitOptsPolyHigher extends TypeAdtImplicitOptsPolyLower with AdtApply:
  inline given [A, B <: A, T <: Tuple]: TypeAdt[B, A *: T, ConfirmSucceed] = TypeAdt(1)
end TypeAdtImplicitOptsPolyHigher

trait TypeAdtImplicitOptsPolyLower:
  inline given [A, B, T <: Tuple](using inline adt: TypeAdt[B, T, ConfirmSucceed]): TypeAdt[B, A *: T, ConfirmSucceed] = TypeAdt(
    adt.index + 1
  )
end TypeAdtImplicitOptsPolyLower

trait AdtApply:
  inline final def get[F[_] <: TypeAdt[_, _, ConfirmSucceed]]: FetchAdtApply[F] = null
end AdtApply
