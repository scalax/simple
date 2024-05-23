package net.scalax.simple
package adt
package impl

import net.scalax.simple.adt.temp.ADTData

object Adt extends TypeAdtAlias with TypeAdtRuntimeApply with TypeAdtAliasModel with TypeAdtAliasModelUnapply {

  class Adapter[Target, Poly](val value: Target)
  object Adapter {
    def apply[Target, Poly](t: Target): Adapter[Target, Poly]               = new Adapter(t)
    def unapply[Target, Poly](adapter: Adapter[Target, Poly]): Some[Target] = Some(adapter.value)
  }

  trait Context[-In, +Out] extends Any {
    def input(t: In): Out
  }
  object Context {
    implicit def contextImplicitApply[In]: Context[In, In] = new Context[In, In] {
      def input(t: In): In = t
    }
  }

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
