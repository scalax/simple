package net.scalax.simple.nat

import core.tpe._

package adt {

  trait NumberCount                                       extends NumberParent
  final class NumberCountChild[Head, Tail <: NumberCount] extends NumberChild[Tail] with NumberCount
  final class NumberCountZero                             extends NumberChild[NumberCountZero] with NumberCount

}
