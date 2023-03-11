package net.scalax.simple
package codec

trait ContextO[Model[_[_]]] {
  type AnyF    = Model[ContextI#AnyF]
  type NoneF   = Model[ContextI#NoneF]
  type IdF     = Model[ContextI#IdF]
  type StringF = Model[ContextI#StringF]
}

trait ContextI {
  type AnyF[_]    = Any
  type NoneF[_]   = None.type
  type IdF[T]     = T
  type StringF[T] = String
}
