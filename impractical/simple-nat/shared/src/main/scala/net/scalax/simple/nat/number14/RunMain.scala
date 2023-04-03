package net.scalax.simple.nat.number14

object RunMain extends App {

  try {
    Number.n1Pos(() => Number.n2Pos)(() => Number.n4Pos)(() => Number.n3Pos)
  } catch {
    case _: StackOverflowError =>
  }

  println(Number.tag1, Number.tag2)
  println(BigDecimal(Number.tag1) / BigDecimal(Number.tag2 - 1))

}
