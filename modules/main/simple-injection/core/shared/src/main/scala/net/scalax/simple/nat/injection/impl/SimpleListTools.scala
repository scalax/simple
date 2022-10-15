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

abstract class SimpleZeroImpl[+T] extends SimpleZero[T] with SimpleListNeedFutureZero[T] with SimpleListNeedFuture[T] {
  override lazy val size: Int         = 0
  override lazy val length: Int       = future.length
  override def getSelf: SimpleList[T] = future.getSelf
  override def future: SimpleListNeedPass[T]
  override def get(i: Int): Option[T]           = if (i >= 0) future.get(i) else Option.empty
  override def add[D >: T](d: D): SimpleList[D] = tools.init(d)
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = new SimpleZeroImpl[D] {
    override def future: SimpleListNeedPass[D] = needPass
  }
}

trait SimpleZeroImplObject extends SimpleZero[Nothing] {
  override def getSelf: SimpleList[Nothing]           = this
  override def get(i: Int): Option[Nothing]           = Option.empty
  override val size: Int                              = 0
  override val length: Int                            = 0
  override def add[D >: Nothing](d: D): SimpleList[D] = tools.init(d)
}

abstract class SimpleInner[+T](override val data: T)
    extends SimplePositive[T](data)
    with SimpleListNeedFuture[T]
    with SimpleListNeedPass[T]
    with SimpleListCurrentImpl[T] {
  override def getSelf: SimpleList[T] = future.getSelf
  override def tail: SimpleList[T]    = pass
  override def pass: SimpleListNeedFuture[T]
  override def future: SimpleListNeedPass[T]
  override def get(i: Int): Option[T] = if (i == index) Option(data) else if (i < index) pass.get(i) else future.get(i)
  override lazy val size: Int         = super.size
  override lazy val length: Int       = super.length
  override def add[D >: T](d: D): SimpleList[D] = {
    lazy val listPre: SimpleListNeedFuture[D] = resetPass(listCurr)
    lazy val listCurr: SimpleListNeedPass[D] = new SimpleOut[D](d) {
      override def pass: SimpleListNeedFuture[D] = listPre
    }
    listCurr
  }
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = {
    val pass1 = pass
    lazy val simpleInner: SimpleInner[D] = new SimpleInner[D](data) {
      override def pass: SimpleListNeedFuture[D] = pass1.resetPass(simpleInner)
      override def future: SimpleListNeedPass[D] = needPass
    }
    simpleInner
  }
}

abstract class SimpleOut[+T](override val data: T) extends SimplePositive[T](data) with SimpleListNeedPass[T] {
  override def getSelf: SimpleList[T] = this
  override def tail: SimpleList[T]    = pass
  override def pass: SimpleListNeedFuture[T]
  override lazy val size: Int         = pass.size + 1
  override lazy val length: Int       = size
  override def get(i: Int): Option[T] = if (i == index) Option(data) else if (i < index) pass.get(i) else Option.empty

  override def add[D >: T](d: D): SimpleList[D] = {
    val pass1 = pass
    lazy val listPre: SimpleInner[D] = new SimpleInner[D](data) {
      override def pass: SimpleListNeedFuture[D] = pass1.resetPass(listPre)
      override def future: SimpleListNeedPass[D] = listCurr
    }
    lazy val listCurr: SimpleOut[D] = new SimpleOut[D](d) {
      override def pass: SimpleListNeedFuture[D] = listPre
    }
    listCurr
  }
  override def allToString: String = SimpleList.allToList(this).toString()
}
