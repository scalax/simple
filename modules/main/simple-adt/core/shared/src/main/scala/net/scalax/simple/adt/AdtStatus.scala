package net.scalax.simple.adt

sealed trait AdtStatus

object AdtStatus {
  class Passed extends AdtStatus
  class Failed extends AdtStatus
}
