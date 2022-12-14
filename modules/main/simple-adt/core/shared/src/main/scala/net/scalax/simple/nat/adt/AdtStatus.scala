package net.scalax.simple.adt

sealed trait AdtStatus
class ConfirmSucceed extends AdtStatus
class ConfirmFailed  extends AdtStatus
