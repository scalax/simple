package net.scalax.simple
package nat
package number24

import ghdmzsk._

trait jinzhi {
  def append(item: Any): jinzhi
  override def toString: String
}

trait jinzhi0 extends jinzhi {
  override def append(item: Any): jinzhi1 = new jinzhi1 {
    override def _1: Any = item
  }
  override def toString: String = "我是澪，五十澪"
}

object jinzhi0 extends jinzhi0

trait jinzhi1 extends jinzhi {
  self =>

  def _1: Any

  override def append(item: Any): jinzhi2 = new jinzhi2 {
    override def _1: Any = self._1
    override def _2: Any = item
  }
  override def toString: String = s"_1: ${_1}"
}

trait jinzhi2 extends jinzhi {
  self =>

  def _1: Any
  def _2: Any

  override def append(item: Any): jinzhi3 = new jinzhi3 {
    override def _1: Any = self._1
    override def _2: Any = self._2
    override def _3: Any = item
  }
  override def toString: String = s"(_1: ${_1}, _2: ${_2})"
}

trait jinzhi3 extends jinzhi {
  self =>

  def _1: Any
  def _2: Any
  def _3: Any

  override def append(item: Any): jinzhi4 = new jinzhi4 {
    override def _1_jinzhi: jinzhi3 = self
    override def _1: Any            = item
  }
  override def toString: String = s"(_1: ${_1}, _2: ${_2}, _3: ${_3})"
}

trait jinzhi4 extends jinzhi {
  self =>

  def _1_jinzhi: jinzhi3
  def _1: Any

  override def append(item: Any): jinzhi = ???
  override def toString: String          = s"(_1_jinzhi: ${_1_jinzhi}, _2_1: ${_1})"
}
