package net.scalax.simple
package adt

object AdtAlias extends impl.AdtAliasAbs {
  override type AdtZero                      = NumberCountZero
  override type AdtNat                       = NumberCount[_]
  override type AdtAppend[A, Tail <: AdtNat] = NumberCountChild[A, Tail]
}
