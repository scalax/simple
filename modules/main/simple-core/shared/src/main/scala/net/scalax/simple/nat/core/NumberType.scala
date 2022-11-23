package net.scalax.simple.nat.core
package tpe

trait NumberParent
trait NumberChild[Tail <: NumberParent] extends NumberParent

// ====================

trait NFuture
trait NeedFuture[F <: NPass] extends NFuture

trait NPass
trait NeedPass[Tail <: NFuture] extends NPass

trait NCurrent                             extends NFuture with NPass
trait Current[F <: NPass, Tail <: NFuture] extends NeedFuture[F] with NeedPass[Tail] with NCurrent

// ====================

trait N3SS                 extends NumberParent with NFuture
trait Number3SS[F <: N3TS] extends NumberParent with NeedFuture[F] with N3SS

trait N3TS extends NumberParent with NPass

trait Number3TS[Tail <: N3SS] extends NumberChild[Tail] with NeedPass[Tail] with N3TS with NPass

trait N3ST                               extends NCurrent with N3SS with N3TS
trait Number3ST[F <: N3TS, Tail <: N3SS] extends Current[F, Tail] with Number3TS[Tail] with Number3SS[F] with N3ST
