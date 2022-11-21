package net.scalax.simple.nat.injection
package impl

private object tools {
  def init[T](data: T): SimpleList[T] = {
    lazy val simpleZero: SimpleZeroImpl[T] = new SimpleZeroImpl[T]() {
      override val future: () => SimpleListNeedPass[T] = () => simpleOut
    }
    lazy val simpleOut: SimpleOut[T] = new SimpleOut[T](data) {
      override val tail: () => SimpleListNeedFuture[T] = () => simpleZero
    }
    simpleOut
  }
}

abstract class SimpleZeroImpl[+T] extends SimpleZero[T] with SimpleListNeedFuture[T] {
  override lazy val length: Int       = future().length
  override def getSelf: SimpleList[T] = future().getSelf
  override val future: () => SimpleListNeedPass[T]
  override def get(i: Int): Option[T]           = if i >= 0 then future().get(i) else Option.empty
  override def add[D >: T](d: D): SimpleList[D] = tools.init(d)
}

trait SimpleZeroImplObject extends SimpleZero[Nothing] {
  override val getSelf: SimpleList[Nothing]           = this
  override def get(i: Int): Option[Nothing]           = Option.empty
  override val length: Int                            = 0
  override def add[D >: Nothing](d: D): SimpleList[D] = tools.init(d)
}

abstract class SimpleInner[+T](data: T)
    extends SimplePositive(data)
    with SimpleListNeedPass[T]
    with SimpleListNeedFuture[T]
    with LengthCurrent
    with Number3ST {
  override def getSelf: SimpleList[T] = future().getSelf
  override val tail: () => SimpleListNeedFuture[T]
  override val future: () => SimpleListNeedPass[T]
  override def cut: SimpleList[T] = {
    lazy val listPre: SimpleListNeedFuture[T] = tail().resetPass(listCurr)
    lazy val listCurr: SimpleOut[T] = new SimpleOut[T](data) {
      override val tail: () => SimpleListNeedFuture[T] = () => listPre
    }
    listCurr
  }
  override def get(i: Int): Option[T] = if i == index then Option(data) else if i < index then tail().get(i) else future().get(i)
  override def add[D >: T](d: D): SimpleList[D] = {
    lazy val listPre: SimpleListNeedFuture[D] = resetPass(listCurr)
    lazy val listCurr: SimpleListNeedPass[D] = new SimpleOut[D](d) {
      override val tail: () => SimpleListNeedFuture[D] = () => listPre
    }
    listCurr
  }
}

abstract class SimpleOut[+T](override val data: T) extends SimplePositive(data) with SimpleListNeedPass[T] {
  override val getSelf: SimpleList[T] = this
  override val tail: () => SimpleListNeedFuture[T]
  override lazy val length: Int       = size
  override lazy val index: Int        = size - 1
  override def cut: SimpleList[T]     = this
  override def get(i: Int): Option[T] = if i == index then Option(data) else if i < index then tail().get(i) else Option.empty
  override def add[D >: T](d: D): SimpleList[D] = {
    val tail1 = tail
    lazy val listPre: SimpleInner[D] = new SimpleInner[D](data) {
      override val tail: () => SimpleListNeedFuture[D] = () => tail1().resetPass(listPre)
      override val future: () => SimpleListNeedPass[D] = () => listCurr
    }
    lazy val listCurr: SimpleOut[D] = new SimpleOut[D](d) {
      override val tail: () => SimpleListNeedFuture[D] = () => listPre
    }
    listCurr
  }
}
