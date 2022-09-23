package net.scalax.simple.nat.injection.impl

import net.scalax.simple.nat.injection.{SimpleAdd, SimpleAddAbs, SimpleList, SimpleListAbs, SimpleListImpl, SimpleListZero, SimpleZero}

private object tools {
  def init[T](data: T): SimpleList[T] = {
    lazy val simpleZero: SimpleZeroImpl[T] = new SimpleZeroImpl[T]() {
      override def num2: SimpleAddAbs[T] = simpleOut
    }
    lazy val simpleOut: SimpleOut[T] = new SimpleOut[T](data, simpleZero) {
      override def num1: SimpleListAbs[T] = simpleZero
    }
    simpleOut
  }
}

abstract case class SimpleZeroImpl[+T]() extends SimpleZero[T] with SimpleListZero[T] with SimpleListAbs[T] {
  override def num2: SimpleAddAbs[T]
  override def get(i: Int): Option[T]                 = super.get(i)
  override val size: Int                              = preIndex
  override def add[U >: Nothing](d: U): SimpleList[U] = tools.init(d)
}

trait SimpleZeroImplObject extends SimpleZero[Nothing] {
  override def get(i: Int): Option[Nothing]           = Option.empty
  override val size: Int                              = 0
  override def add[U >: Nothing](d: U): SimpleList[U] = tools.init(d)
}

abstract case class SimpleInner[+T](override val data: T, override val tail: SimpleList[T])
    extends SimpleAdd[T](data, tail)
    with SimpleListAbs[T]
    with SimpleAddAbs[T]
    with SimpleListImpl[T] {
  override def num1: SimpleListAbs[T]
  override def num2: SimpleAddAbs[T]
  override def size: Int              = preIndex
  override def get(i: Int): Option[T] = super.get(i)
  override def add[U >: T](d: U): SimpleList[U] = {
    val num1Impl = num1
    lazy val listPre: SimpleInner[U] = new SimpleInner[U](data, tail) {
      override def num1: SimpleListAbs[U] = num1Impl
      override def num2: SimpleAddAbs[U]  = listCurr
    }
    lazy val listCurr: SimpleOut[U] = new SimpleOut[U](data, tail) {
      override def num1: SimpleListAbs[U] = listPre
    }
    listCurr
  }
}

abstract case class SimpleOut[+T](override val data: T, override val tail: SimpleList[T])
    extends SimpleAdd[T](data, tail)
    with SimpleAddAbs[T] {
  override def num1: SimpleListAbs[T]
  override def size: Int              = index
  override def get(i: Int): Option[T] = super.get(i)
  override def add[U >: T](d: U): SimpleList[U] = {
    val num1Impl = num1
    lazy val listPre: SimpleInner[U] = new SimpleInner[U](data, tail) {
      override def num1: SimpleListAbs[U] = num1Impl
      override def num2: SimpleAddAbs[U]  = listCurr
    }
    lazy val listCurr: SimpleOut[U] = new SimpleOut[U](data, tail) {
      override def num1: SimpleListAbs[U] = listPre
    }
    listCurr
  }
}
