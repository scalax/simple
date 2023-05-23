package net.scalax.simple
package adt

import implemention._

object AdtAlias extends impl.AdtAliasAbs {
  override type AdtZero                      = NatFuncZero
  override type AdtNat                       = NatFunc
  override type AdtAppend[A, Tail <: AdtNat] = NatFuncPositive[A, Tail]
}
