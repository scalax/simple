package net.scalax.simple.adt
package nat
package support

trait ExtractProductAbstraction[HListLike, AppLike[_, _ <: HListLike] <: HListLike, HZero <: HListLike] {
  ExtractProductAbstractionSelf =>

  def hListFunc: HListFunc[HListLike, AppLike]
  def zeroInstance: HZero

  def runtimeCountSize(t: HListLike): Int
  def labelledItemToString(t: Any): String

  final val hlistSimpleCompat: ExtractProductAbstraction[HListLike, ({ type AP1[_, T1 <: HListLike] = T1 })#AP1, HListLike] =
    ExtractProductAbstractionSelf.asInstanceOf[ExtractProductAbstraction[HListLike, ({ type AP1[_, T1 <: HListLike] = T1 })#AP1, HListLike]]
  final val scalaVersionCompat: ExtractProductAbstraction[Any, ({ type AnyF[A1, A2 <: Any] = Any })#AnyF, Any] =
    ExtractProductAbstractionSelf.asInstanceOf[ExtractProductAbstraction[Any, ({ type AnyF[A1, A2 <: Any] = Any })#AnyF, Any]]

}
