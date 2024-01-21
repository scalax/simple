package `整数树20240120`

import net.scalax.simple.ghdmzsk.ghdmzsk

object NumberCount {

  val 零点: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(后继: () => ghdmzsk): ghdmzsk = 后继()
  }

  val 表层: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(前驱: () => ghdmzsk): ghdmzsk = 前驱()
  }

  val 有前驱有后继: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(前驱: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(后继: () => ghdmzsk): ghdmzsk = 前驱()
    }
  }

  //
  零点
  表层
  有前驱有后继

}
