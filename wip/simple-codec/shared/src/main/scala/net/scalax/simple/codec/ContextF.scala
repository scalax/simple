package net.scalax.simple
package codec

trait ContextO[Model[_[_]]] {
  type AnyF       = Model[ContextI#AnyF]
  type NoneF      = Model[ContextI#NoneF]
  type IdF        = Model[ContextI#IdF]
  type StringF    = Model[ContextI#StringF]
  type SimpleVarF = Model[ContextI#SimpleVarF]
  type OptionF    = Model[ContextI#OptionF]
  type EmptyTagF  = Model[ContextI#EmptyTagF]
  type IntF       = Model[ContextI#IntF]
}

trait ContextI {
  type AnyF[_]       = Any
  type NoneF[_]      = None.type
  type IdF[T]        = T
  type StringF[T]    = String
  type SimpleVarF[T] = SimpleVar[T]
  type OptionF[T]    = Option[T]
  type EmptyTagF[T]  = EmptyTag[T]
  type IntF[T]       = Int
}
