package net.scalax.simple.adt

class VarSetting[T] {
  var value: T = null.asInstanceOf[T]
}

object VarSetting {
  def init[T]: VarSetting[T] = new VarSetting
}
