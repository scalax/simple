package net.scalax.simple.nat.number15

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number1 {

  case class AA(cc: () => ghdmzsk) extends ghdmzsk {
    override def apply(t: () => ghdmzsk): ghdmzsk = throw new Exception
  }
  case class BB(cc: () => ghdmzsk) extends ghdmzsk {
    override def apply(t: () => ghdmzsk): ghdmzsk = throw new Exception
  }

  val number1S: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => other()(tail)))
  val number1T: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => AA(() => tail()(other))))
  val number1U: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => BB(() => tail()(other))))
  val number1V: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => BB(() => other()(tail))))

}
