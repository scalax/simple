package net.scalax.simple.adt
package impl

import core._

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
    def tranToFoldList(t: Tuple): FoldList = t.match
      case head *: tail =>
        new FoldListPositive(tranToFoldList(tail)) with (Any => Any) {
          override def apply(any: Any): Any = head.asInstanceOf[Any => Any](any)
        }
      case EmptyTuple => FoldList.zero
    end tranToFoldList
    adt.input(value).method1(tranToFoldList(funcCol)).asInstanceOf[U]
  end fold
end InnerApply
