package net.scalax.simple
package adt

sealed trait RuntimeNat
trait RuntimeData[+Data, +T <: RuntimeNat] extends RuntimeNat
class RuntimeZero                          extends RuntimeData[IsFinishAndNothing, RuntimeZero]
