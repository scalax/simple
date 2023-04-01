package net.scalax.simple.nat.number14

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {
  val number1S: ghdmzsk = ghdmzsk(tail => ghdmzsk(inputANum2AndGetANum2 => inputANum2AndGetANum2()(tail)))
  val number1T: ghdmzsk = ghdmzsk(tail => ghdmzsk(inputANum2AndGetANum2 => tail()(inputANum2AndGetANum2))) // Count

  val number2S: ghdmzsk = ghdmzsk(tail => ghdmzsk(needInputTail => ghdmzsk(other => other()(() => needInputTail()(tail)))))
  val number2T: ghdmzsk = ghdmzsk(tail => ghdmzsk(needInputTail => ghdmzsk(other => needInputTail()(tail)(other))))
}
