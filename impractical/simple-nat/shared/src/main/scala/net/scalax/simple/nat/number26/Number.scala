package net.scalax.simple
package nat
package number26

case class NumberA(tail1: () => NumberA, tail2: () => NumberB) {
  def input(num1: () => NumberA, num2: () => NumberB): (() => NumberA, () => NumberB) = ???
}

case class NumberB(tail1: () => NumberA, tail2: () => NumberB) {
  def input(num1: () => NumberA, num2: () => NumberB): (() => NumberA, () => NumberB) = ???
}
