package net.scalax.simple.nat.adt
package impl
import net.scalax.simple.nat.adt.TypeAdt

trait TypeAdtImplicitOptsPolyHigher extends TypeAdtImplicitOptsPolyLower with AdtApply:
  inline given [A, B <: A, T <: Tuple](using inline v: ValueOf[Tuple.Size[A *: T]]): TypeAdt[B, A *: T, ConfirmSucceed] = TypeAdt(v.value)
end TypeAdtImplicitOptsPolyHigher

trait TypeAdtImplicitOptsPolyLower:
  inline given [A, B, T <: Tuple](using inline adt: TypeAdt[B, T, ConfirmSucceed]): TypeAdt[B, A *: T, ConfirmSucceed] =
    adt.asInstanceOf[TypeAdt[B, A *: T, ConfirmSucceed]]
end TypeAdtImplicitOptsPolyLower

trait AdtApply:
  inline final def get[F[_] <: TypeAdt[_, _, ConfirmSucceed]]: FetchAdtApply[F] = null
end AdtApply
