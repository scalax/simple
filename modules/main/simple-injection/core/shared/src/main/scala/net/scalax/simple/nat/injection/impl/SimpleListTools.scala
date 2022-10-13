package net.scalax.simple.nat.injection
package impl

private object tools {
  def init[T](data: T): SimpleList[T] = {
    lazy val simpleZero: SimpleZeroImpl[T] = new SimpleZeroImpl[T]() {
      override def future: SimpleListNeedPass[T] = simpleOut
    }
    lazy val simpleOut: SimpleOut[T] = new SimpleOut[T](data) {
      override def pass: SimpleListNeedFuture[T] = simpleZero
    }
    simpleOut
  }
}

abstract class SimpleZeroImpl[T]() extends SimpleZero[T] with SimpleListNeedFutureZero[T] with SimpleListNeedFuture[T] {
  1
  override def future: SimpleListNeedPass[T]
  override def get(i: Int): Option[T]   = super.get(i)
  override def add(d: T): SimpleList[T] = tools.init(d)

  /*override val addNext: T => SimpleOut[T] = { t =>
    lazy val out: SimpleOut[T] = new SimpleOut(t) {
      override def pass: SimpleListNeedFuture[T] = in
    }
    lazy val in: SimpleListNeedFuture[T] = new SimpleZeroImpl[T] {
      override def future: SimpleListNeedPass[T] = out
    }
    out
  }*/
}

trait SimpleZeroImplObject[T] extends SimpleZero[T] {
  override def get(i: Int): Option[Nothing] = Option.empty
  override val size: Int                    = 0
  override def add(d: T): SimpleList[T]     = tools.init(d)
}

abstract class SimpleInner[T](override val data: T)
    extends SimplePositive[T](data)
    with SimpleListNeedFuture[T]
    with SimpleListNeedPass[T]
    with SimpleListCurrentImpl[T] {
  override def tail: SimpleList[T] = pass
  override def pass: SimpleListNeedFuture[T]
  override def future: SimpleListNeedPass[T]
  override def get(i: Int): Option[T] = super.get(i)
  override val size: Int              = super.size
  override def add(d: T): SimpleList[T] = {
    val num1Impl = pass
    lazy val listPre: SimpleInner[T] = new SimpleInner[T](data) {
      override def pass: SimpleListNeedFuture[T] = num1Impl
      override def future: SimpleListNeedPass[T] = listCurr
    }
    lazy val listCurr: SimpleOut[T] = new SimpleOut[T](data) {
      override def pass: SimpleListNeedFuture[T] = listPre
    }
    listCurr
  }
}

abstract class SimpleOut[T](override val data: T) extends SimplePositive[T](data) with SimpleListNeedPass[T] {
  override def tail: SimpleList[T] = pass
  override def pass: SimpleListNeedFuture[T]
  override val size: Int              = super.index + 1
  override def get(i: Int): Option[T] = super.get(i)
  override def add(d: T): SimpleList[T] = {
    val num1Impl = pass
    lazy val listPre: SimpleInner[T] = new SimpleInner[T](data) {
      override def pass: SimpleListNeedFuture[T] = num1Impl
      override def future: SimpleListNeedPass[T] = listCurr
    }
    lazy val listCurr: SimpleOut[T] = new SimpleOut[T](data) {
      override def pass: SimpleListNeedFuture[T] = listPre
    }
    listCurr
  }
  /*override val addPre: T => SimpleListAbs[T] = {
    11
  }*/

}
