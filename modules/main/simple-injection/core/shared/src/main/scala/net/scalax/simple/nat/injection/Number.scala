package net.scalax.simple.nat.injection

// 考虑后继
trait Number1
trait Number1S extends Number1 {
  def num2: Number2 // 后继
}

// 考虑前驱
trait Number2
trait Number2S extends Number2 {
  def num1: Number1 // 前驱
}
