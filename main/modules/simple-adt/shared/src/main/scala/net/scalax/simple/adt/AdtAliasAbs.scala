package net.scalax.simple
package adt
package impl

import net.scalax.simple.adt.temp.ADTData

object Adt extends TypeAdtAlias with TypeAdtRuntimeApply with TypeAdtAliasModel with TypeAdtAliasModelUnapply {

  sealed trait Status

  object Status {
    object Passed      extends Status with ADTPassedFunction
    object NotFinished extends Status
  }

}
