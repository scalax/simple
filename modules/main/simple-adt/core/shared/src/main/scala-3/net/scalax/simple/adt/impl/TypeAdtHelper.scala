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
    def tranToFoldList(t: Tuple): FoldList[U] = t.match
      case head *: tail => new FoldListPositive(tranToFoldList(tail), head.asInstanceOf[Nothing => U])
      case EmptyTuple   => FoldList.zero
    end tranToFoldList
    tranToFoldList(funcCol).method2(adt.input(value))
  end fold
end InnerApply
