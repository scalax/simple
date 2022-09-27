package net.scalax.simple.nat.adt

sealed trait AdtStatus
class ConfirmSucceed extends AdtStatus
class ConfirmFailed  extends AdtStatus
