package net.scalax.simple.codec

import slick.jdbc.JdbcProfile

class SlickCompatAlias[V <: JdbcProfile](val profile: V) {
  type ColumnOptions = profile.ColumnOptions
}

object SlickCompatAlias {
  def build[V <: JdbcProfile](implicit p: V): SlickCompatAlias[V] = new SlickCompatAlias(profile = p)
}
