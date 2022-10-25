package net.scalax.simple.nat.injection
package impl

private object tools {
  def init[T](data: T): SimpleList[T] = {
    lazy val simpleZero: SimpleZeroImpl[T] = new SimpleZeroImpl[T]() {
      override val future: () => SimpleListNeedPass[T] = () => simpleOut
    }
    lazy val simpleOut: SimpleOut[T] = new SimpleOut[T](data) {
      override val pass: () => SimpleListNeedFuture[T] = () => simpleZero
    }
    simpleOut
  }
}

abstract class SimpleZeroImpl[+T] extends SimpleZero[T] with SimpleListNeedFuture[T] {
  override lazy val length: Int       = future().length
  override def getSelf: SimpleList[T] = future().getSelf
  override val future: () => SimpleListNeedPass[T]
  override def get(i: Int): Option[T]           = if (i >= 0) future().get(i) else Option.empty
  override def add[D >: T](d: D): SimpleList[D] = tools.init(d)
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = new SimpleZeroImpl[D] {
    override val future: () => SimpleListNeedPass[D] = () => needPass
  }
}

trait SimpleZeroImplObject extends SimpleZero[Nothing] {
  override val getSelf: SimpleList[Nothing]           = this
  override def get(i: Int): Option[Nothing]           = Option.empty
  override val length: Int                            = 0
  override def add[D >: Nothing](d: D): SimpleList[D] = tools.init(d)
}

abstract class SimpleInner[+T](data: T)
    extends SimpleListNeedPass[T](data)
    with SimpleListNeedFuture[T]
    with Number3Current
    with LengthCurrent {
  override def getSelf: SimpleList[T] = future().getSelf
  override val pass: () => SimpleListNeedFuture[T]
  override val future: () => SimpleListNeedPass[T]
  override def cut: SimpleList[T] = {
    lazy val listPre: SimpleListNeedFuture[T] = pass().resetPass(listCurr)
    lazy val listCurr: SimpleOut[T] = new SimpleOut[T](data) {
      override val pass: () => SimpleListNeedFuture[T] = () => listPre
    }
    listCurr
  }

  override def get(i: Int): Option[T] = if (i == index) Option(data) else if (i < index) pass().get(i) else future().get(i)
  override def add[D >: T](d: D): SimpleList[D] = {
    lazy val listPre: SimpleListNeedFuture[D] = resetPass(listCurr)
    lazy val listCurr: SimpleListNeedPass[D] = new SimpleOut[D](d) {
      override val pass: () => SimpleListNeedFuture[D] = () => listPre
    }
    listCurr
  }
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = {
    val pass1 = pass
    lazy val simpleInner: SimpleInner[D] = new SimpleInner[D](data) {
      override val pass: () => SimpleListNeedFuture[D] = () => pass1().resetPass(simpleInner)
      override val future: () => SimpleListNeedPass[D] = () => needPass
    }
    simpleInner
  }
}

abstract class SimpleOut[+T](data: T) extends SimpleListNeedPass[T](data) with Number3TT {
  override val getSelf: SimpleList[T] = this
  override val pass: () => SimpleListNeedFuture[T]
  override lazy val length: Int   = size
  override lazy val index: Int    = size - 1
  override def cut: SimpleList[T] = this

  override def get(i: Int): Option[T] = if (i == index) Option(data) else if (i < index) pass().get(i) else Option.empty

  override def add[D >: T](d: D): SimpleList[D] = {
    val pass1 = pass
    lazy val listPre: SimpleInner[D] = new SimpleInner[D](data) {
      override val pass: () => SimpleListNeedFuture[D] = () => pass1().resetPass(listPre)
      override val future: () => SimpleListNeedPass[D] = () => listCurr
    }
    lazy val listCurr: SimpleOut[D] = new SimpleOut[D](d) {
      override val pass: () => SimpleListNeedFuture[D] = () => listPre
    }
    listCurr
  }
}
