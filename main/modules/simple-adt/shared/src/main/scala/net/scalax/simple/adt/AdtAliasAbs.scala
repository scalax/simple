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

  object ADTDataMutiply extends Status {
    implicit class ADTDataExtra1[T <: RuntimeNat, S <: Status](val data: ADTData[T, S]) extends AnyVal {
      def lockSubClass[U <: S]: ADTData[T, U with ADTDataMutiply.type] = data.asInstanceOf[ADTData[T, U with ADTDataMutiply.type]]
      def changeImplement[U]: ADTData[T, U with ADTDataMutiply.type]   = data.asInstanceOf[ADTData[T, U with ADTDataMutiply.type]]
    }
  }

}
