/*package net.scalax.simple.codec

import slick.jdbc.JdbcProfile

class SlickCompatAlias[V <: JdbcProfile](val profile: V) {
  type SqlColumnOptions = profile.SqlColumnOptions
}

object SlickCompatAlias {
  def build[V <: JdbcProfile](implicit p: V): SlickCompatAlias[p.type] = new SlickCompatAlias(profile = p)
}
 */
