package net.scalax.simple
package adt
package core

import net.scalax.simple.core.Core2

object AdtCoreFactory {

  val Number1: Core2      = Core2(tail => Core2(other => other()(tail)))
  val Number2: Core2      = Core2(tail => tail())
  lazy val Number3: Core2 = Core2(tail => Number3)

}
