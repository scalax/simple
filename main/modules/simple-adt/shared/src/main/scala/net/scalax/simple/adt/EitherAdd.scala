package net.scalax.simple
package adt

sealed trait RuntimeNat
trait RuntimeNatPositive[+T <: RuntimeNat] extends RuntimeNat
trait RuntimeData[+Data, +T <: RuntimeNat] extends RuntimeNatPositive[T]
class RuntimeZero                          extends RuntimeNatPositive[RuntimeZero]
