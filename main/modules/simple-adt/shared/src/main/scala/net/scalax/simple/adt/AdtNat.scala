package net.scalax.simple.adt
package nat

import net.scalax.simple.adt.temp.IsFinishAndNothing

trait AdtNat
trait AdtNatPositive[+Head, +T <: AdtNat] extends AdtNat
class AdtNatZero                          extends AdtNatPositive[IsFinishAndNothing, AdtNatZero]
