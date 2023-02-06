package net.scalax.simple

package object adt {

  type TypeAdt = AdtAliasBuilder.ExceptSucceed.Context[AdtDefaultContext.type]
  val TypeAdt: TypeAdt = AdtAliasBuilder.value

}
