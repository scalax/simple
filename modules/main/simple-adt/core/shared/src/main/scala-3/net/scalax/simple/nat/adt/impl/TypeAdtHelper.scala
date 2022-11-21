package net.scalax.simple.nat.adt
package impl

final class FetchAdtApply[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]:
   type TakeTuple[T <: TypeAdt.Aux[_, _, ConfirmSucceed]] <: Tuple = T match
      case TypeAdt[a, b] =>
        b match
           case c *: d     => c *: d
           case EmptyTuple => EmptyTuple
   end TakeTuple

   inline final def input[T](inline data: T): InnerApply[[t] =>> Tuple.Map[TakeTuple[F[T]], [x] =>> (x => t)], F[T]] = InnerApply(data)
end FetchAdtApply

final class InnerApply[O[_] <: Tuple, TAdt <: TypeAdt.Aux[_, _, ConfirmSucceed]](value: Any) extends AnyVal:
   inline def fold[U](inline funcCol: O[U])(using inline adt: TAdt): U =
     if (funcCol eq EmptyTuple)
       funcCol.productElement(adt.index - 1).asInstanceOf[Any => Any](value).asInstanceOf[U]
     else
       funcCol.asInstanceOf[NonEmptyTuple](adt.index - 1).asInstanceOf[Any => Any](value).asInstanceOf[U]
   end fold
end InnerApply
