package net.scalax.simple.nat.number14

object RunMain extends App {

  try {
    Number.n1Pos(() => Number.n2Pos)(() => Number.n4Pos)(() => Number.n2Pos)
  } catch {
    case _: StackOverflowError =>
  }

  println(BigDecimal(Number.tag1) / BigDecimal(Number.tag2))

}
