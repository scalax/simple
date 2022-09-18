package net.scalax.simple.nat.adt.impl

import net.scalax.simple.nat.adt.TypeAdt

final class FetchAdtApply[F[_] <: TypeAdt[_, _]]:
  type TakeTuple[T <: TypeAdt[_, _]] <: Tuple = T match
    case TypeAdt[a, b] =>
      b match
        case c *: d     => c *: d
        case EmptyTuple => EmptyTuple
  end TakeTuple

  inline final def input[T](inline data: T): InnerApply[[t] =>> Tuple.Map[TakeTuple[F[T]], [x] =>> (x => t)], F[T]] = InnerApply(data)
end FetchAdtApply

final class InnerApply[O[_] <: Tuple, TAdt <: TypeAdt[_, _]](value: Any) extends AnyVal:
  inline def fold[U](inline funcCol: O[U])(using inline adt: TAdt): U =
    funcCol.productElement(adt.index - 1).asInstanceOf[Any => Any](value).asInstanceOf[U]
end InnerApply
