package net.scalax.simple.nat.number21

case class `有理数`(tail: () => `有理数`, 是否分母: Boolean) {
  def `除以`(other: () => `有理数`, 是否被乘数: Boolean): `有理数` = if (是否分母) {
    other().`除以`(tail, !是否被乘数)
  } else {
    `有理数`(tail = () => tail().`除以`(other, 是否被乘数), 是否分母 = 是否被乘数)
  }
}
