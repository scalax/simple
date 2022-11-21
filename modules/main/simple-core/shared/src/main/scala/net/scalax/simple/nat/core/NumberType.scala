package net.scalax.simple.nat.core
package tpe

trait NumberParent
trait NumberChild[Tail <: NumberParent] extends NumberParent

trait NeedFuture[F <: NeedPass[_]]
trait NeedPass[Tail <: NeedFuture[_]]

trait Current[F <: NeedPass[_], Tail <: NeedFuture[_]] extends NeedFuture[F] with NeedPass[Tail]

trait Number3SS[F <: Number3TS[_]]    extends NeedFuture[F] with NumberParent
trait Number3TS[Tail <: Number3SS[_]] extends NumberChild[Tail] with NeedPass[Tail]

trait Number3ST[F <: Number3TS[_], Tail <: Number3SS[_]] extends Current[F, Tail] with Number3TS[Tail] with Number3SS[F]
