package net.scalax.simple.nat.adt

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdt[Input, Sum](val index: Int) extends AnyVal

object TypeAdt extends impl.TypeAdtImplicitOptsPolyHigher {
  object alias extends impl.TypeAdtAlias
}
