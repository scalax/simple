package net.scalax.simple.adt.implemention

import scala.annotation.tailrec
import scala.collection.compat._

trait UnapplyFuncGetter {
  def get[T <: UnapplyFuncGetter.UnapplyType](count: Int): T
}

object UnapplyFuncGetter {
  type UnapplyType = UnapplyInstance.UnapplyFunc[_ <: UnapplyInstance.UnapplyFunc[_]]
}

object DefaultUnapplyFuncGetter extends UnapplyFuncGetter {

  private var inner: Array[UnapplyFuncGetter.UnapplyType] = {
    val v = UnapplyInstance.UnapplyFuncZero.value
    v.CaseFirst
    Array(v)
  }

  private def update100(): Unit = {
    var tempList: List[UnapplyFuncGetter.UnapplyType] = inner.to(List)
    for (_ <- 1 to 100) {
      val newLast: UnapplyFuncGetter.UnapplyType = UnapplyInstance.UnapplyFuncPositive(tempList.last)
      newLast.CaseFirst
      tempList = tempList ::: newLast :: Nil
    }
    inner = tempList.to(Array)
  }

  @tailrec
  def get[T <: UnapplyFuncGetter.UnapplyType](count: Int): T = {
    if (inner.size > count) {
      inner(count).asInstanceOf[T]
    } else {
      update100()
      get[T](count)
    }
  }

}
