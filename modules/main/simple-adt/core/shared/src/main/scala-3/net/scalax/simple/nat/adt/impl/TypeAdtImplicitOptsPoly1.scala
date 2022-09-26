package net.scalax.simple.nat.adt.impl
import net.scalax.simple.nat.adt.TypeAdt

trait TypeAdtImplicitOptsPolyHigher extends TypeAdtImplicitOptsPolyLower with AdtApply:
  inline given [A, B <: A, T <: Tuple]: TypeAdt[B, A *: T] = TypeAdt(1)
end TypeAdtImplicitOptsPolyHigher

trait TypeAdtImplicitOptsPolyLower:
  inline given [A, B, T <: Tuple](using inline adt: TypeAdt[B, T]): TypeAdt[B, A *: T] = TypeAdt(adt.index + 1)
end TypeAdtImplicitOptsPolyLower

trait AdtApply:
  inline final def get[F[_] <: TypeAdt[_, _]]: FetchAdtApply[F] = null
end AdtApply
