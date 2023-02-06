package net.scalax.simple
package adt

object AdtAlias extends impl.AdtAliasAbs {
  override type AdtZero                      = EmptyTuple
  override type AdtNat                       = Tuple
  override type AdtAppend[A, Tail <: AdtNat] = A *: Tail
}
