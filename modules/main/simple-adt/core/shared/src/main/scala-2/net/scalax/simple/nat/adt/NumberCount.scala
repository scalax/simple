package net.scalax.simple
package adt

import core.Core1

trait NumberCount[T <: NumberCount[_]]                     extends Core1[T]
final class NumberCountChild[Head, Tail <: NumberCount[_]] extends NumberCount[Tail]
final class NumberCountZero                                extends NumberCount[NumberCountZero]
