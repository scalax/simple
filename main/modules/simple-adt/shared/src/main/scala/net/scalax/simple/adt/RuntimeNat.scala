package net.scalax.simple
package adt

import net.scalax.simple.adt.temp.IsFinishAndNothing

sealed trait RuntimeNat
trait RuntimeData[+Data, +T <: RuntimeNat] extends RuntimeNat
class RuntimeZero                          extends RuntimeData[IsFinishAndNothing, RuntimeZero]
