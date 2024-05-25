package net.scalax.simple.nat.number14

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk = ghdmzsk(num1Tail =>
    ghdmzsk(num2 => ghdmzsk(num4 => ghdmzsk(num3 => AA(() => num1Tail().inputGHDMZSK(num2()).inputGHDMZSK(num4()).inputGHDMZSK(num3())))))
  )
  val number1T: ghdmzsk = ghdmzsk(num1Tail =>
    ghdmzsk(num2 => ghdmzsk(num4 => ghdmzsk(num3 => num2().inputGHDMZSK(num3()).inputGHDMZSK(num1Tail()).inputGHDMZSK(num4()))))
  )

  val number2S: ghdmzsk = ghdmzsk(num2Tail =>
    ghdmzsk(num3 => ghdmzsk(num1 => ghdmzsk(num4 => num1().inputGHDMZSK(num2Tail()).inputGHDMZSK(num4()).inputGHDMZSK(num3()))))
  )
  val number2T: ghdmzsk = ghdmzsk(num2Tail =>
    ghdmzsk(num3 => ghdmzsk(num1 => ghdmzsk(num4 => num3().inputGHDMZSK(num4()).inputGHDMZSK(num2Tail()).inputGHDMZSK(num1()))))
  )
  val number2U: ghdmzsk = ghdmzsk(num2Tail =>
    ghdmzsk(num3 => ghdmzsk(num1 => ghdmzsk(num4 => BB(() => num3().inputGHDMZSK(num4()).inputGHDMZSK(num2Tail()).inputGHDMZSK(num1())))))
  )

  val number3S: ghdmzsk = ghdmzsk(num3Tail =>
    ghdmzsk(num4 => ghdmzsk(num2 => ghdmzsk(num1 => num2().inputGHDMZSK(num3Tail()).inputGHDMZSK(num1()).inputGHDMZSK(num4()))))
  )
  val number3T: ghdmzsk = ghdmzsk(num3Tail =>
    ghdmzsk(num4 => ghdmzsk(num2 => ghdmzsk(num1 => num4().inputGHDMZSK(num1()).inputGHDMZSK(num3Tail()).inputGHDMZSK(num2()))))
  )

  val number4S: ghdmzsk = ghdmzsk(num4Tail =>
    ghdmzsk(num1 => ghdmzsk(num3 => ghdmzsk(num2 => num3().inputGHDMZSK(num4Tail()).inputGHDMZSK(num2()).inputGHDMZSK(num1()))))
  )
  val number4T: ghdmzsk = ghdmzsk(num4Tail =>
    ghdmzsk(num1 => ghdmzsk(num3 => ghdmzsk(num2 => num1().inputGHDMZSK(num2()).inputGHDMZSK(num4Tail()).inputGHDMZSK(num3()))))
  )

  case class AA(cc: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception
  }
  case class BB(cc: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception
  }

  lazy val n1Pos: ghdmzsk = number1S.inputGHDMZSK(
    number1S.inputGHDMZSK(number1S.inputGHDMZSK(number1S.inputGHDMZSK(number1S.inputGHDMZSK(number1S.inputGHDMZSK(n1Zero)))))
  )
  lazy val n1Zero: ghdmzsk = number2T.inputGHDMZSK(n1Pos)

  lazy val n2Pos: ghdmzsk =
    number2S.inputGHDMZSK(
      number2S.inputGHDMZSK(
        number2S.inputGHDMZSK(number2S.inputGHDMZSK(number2S.inputGHDMZSK(number2S.inputGHDMZSK(number2S.inputGHDMZSK(n2Zero)))))
      )
    )
  lazy val n2Zero: ghdmzsk = number2T.inputGHDMZSK(n2Pos)

  lazy val n3Pos: ghdmzsk =
    number2S.inputGHDMZSK(
      number2S.inputGHDMZSK(
        number2S.inputGHDMZSK(number2S.inputGHDMZSK(number2S.inputGHDMZSK(number2S.inputGHDMZSK(number2S.inputGHDMZSK(n3Zero)))))
      )
    )
  lazy val n3Zero: ghdmzsk = number2T.inputGHDMZSK(n3Pos)

  lazy val n4Pos: ghdmzsk =
    number2S.inputGHDMZSK(
      number2S.inputGHDMZSK(
        number2S.inputGHDMZSK(number2S.inputGHDMZSK(number2S.inputGHDMZSK(number2S.inputGHDMZSK(number2S.inputGHDMZSK(n4Zero)))))
      )
    )
  lazy val n4Zero: ghdmzsk = number2U.inputGHDMZSK(n4Pos)

}
