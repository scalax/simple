package net.scalax.simple

package object adt {

  type TypeAdt = AdtAliasBuilder.ExceptSucceed.Context[AdtDefaultContext.type]
  val TypeAdt: TypeAdt = AdtAliasBuilder.value[TypeAdt]

  type TypeAdtFailed = AdtAliasBuilder.ExceptFailed.Context[AdtDefaultContext.type]
  val TypeAdtFailed: TypeAdtFailed = AdtAliasBuilder.value[TypeAdtFailed]

}
