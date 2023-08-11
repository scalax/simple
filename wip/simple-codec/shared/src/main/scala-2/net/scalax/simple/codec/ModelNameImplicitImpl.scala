package net.scalax.simple.codec

import slick.jdbc.JdbcProfile

class U[V <: JdbcProfile](val profile: V) {
  type ColumnOptions = profile.ColumnOptions
}
