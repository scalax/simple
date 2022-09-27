package net.scalax.simple.nat.adt
package impl

final class FetchAdtApply[F[_] <: TypeAdt[_, _, ConfirmSucceed]]:
  type TakeTuple[T <: TypeAdt[_, _, ConfirmSucceed]] <: Tuple = T match
    case TypeAdt[a, b, ConfirmSucceed] =>
      b match
        case c *: d     => c *: d
        case EmptyTuple => EmptyTuple
  end TakeTuple

  inline final def input[T](inline data: T): InnerApply[[t] =>> Tuple.Map[TakeTuple[F[T]], [x] =>> (x => t)], F[T]] = InnerApply(data)
end FetchAdtApply

final class InnerApply[O[_] <: Tuple, TAdt <: TypeAdt[_, _, ConfirmSucceed]](value: Any) extends AnyVal:
  inline def fold[U](inline funcCol: O[U])(using inline adt: TAdt): U =
    funcCol.productElement(adt.index - 1).asInstanceOf[Any => Any](value).asInstanceOf[U]
end InnerApply
