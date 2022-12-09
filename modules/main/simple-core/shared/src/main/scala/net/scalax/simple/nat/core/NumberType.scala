package net.scalax.simple.nat.core
package tpe

trait NumberParent
trait NumberChild[Tail <: NumberParent] extends NumberParent

// ====================

trait NFuture
trait NeedFuture[Future <: NPass] extends NFuture

trait NPass
trait NeedPass[Pass <: NFuture] extends NPass

/*trait NCurrent                                  extends NFuture with NPass
trait Current[Future <: NPass, Pass <: NFuture] extends NeedFuture[Future] with NeedPass[Pass] with NCurrent*/
