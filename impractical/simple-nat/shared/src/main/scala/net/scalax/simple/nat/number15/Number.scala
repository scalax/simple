package net.scalax.simple.nat.number15

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number1 {

  var count1: Long = 0
  var count2: Long = 0

  val AA = ghdmzsk(tail =>
    ghdmzsk { anything =>
      count1 = count1 + 1
      tail()
    }
  )
  val BB = ghdmzsk(tail =>
    ghdmzsk { anything =>
      count2 = count2 + 1
      tail()
    }
  )

  val number1S: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => other()(tail)))
  val number1T: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => AA(() => tail()(other))))
  val number1U: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => BB(() => tail()(other))))
  val number1V: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => BB(() => other()(tail))))

}
