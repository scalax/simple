package net.scalax.simple.nat.injection

trait SimpleList[+T] {
  def getSelf: SimpleList[T]
  def dataStruct: Option[(T, SimpleList[T])]
  def get(i: Int): Option[T]
  def size: Int
  def add[D >: T](d: D): SimpleList[D]
  def allToString: String
  def length: Int

  @throws[IndexOutOfBoundsException]
  def apply(n: Int): T = {
    if (n < 0) throw new IndexOutOfBoundsException(n.toString)
    val skipped = this.get(n)
    if (skipped.isEmpty) throw new IndexOutOfBoundsException(n.toString)
    skipped.get
  }
}
object SimpleList {
  def apply[T](elems: T*): SimpleList[T] = {
    var init: SimpleList[T] = SimpleZero
    for (e <- elems) init = init.add(e)
    init
  }
  def unapplySeq[T](u: SimpleList[T]): Seq[T] = {
    var seq: Seq[T]       = Seq.empty
    var u1: SimpleList[T] = u
    while (u1.dataStruct.isDefined) {
      val current = u1.dataStruct.get
      seq = current._1 +: seq
      u1 = current._2
    }
    seq
  }
  def allToList[T](s: SimpleList[T]): List[T] = {
    var list: List[T] = List.empty
    var t             = s
    @annotation.tailrec
    def loop: Unit = t match {
      case SimpleZero =>
      case SimplePositive(current, tail) =>
        list = current +: list
        t = tail
        loop
    }
    loop
    list
  }
}

abstract class SimpleZero[+T] extends SimpleList[T] {
  override val dataStruct: Option[(T, SimpleList[T])] = Option.empty
}

case object SimpleZero extends SimpleZero[Nothing] with impl.SimpleZeroImplObject {
  override def equals(obj: Any): Boolean = obj match {
    case t: SimpleList[_] => t.dataStruct.isEmpty
    case _                => false
  }
  override def allToString: String = SimpleList.allToList(this).toString()
}

abstract class SimplePositive[+T](data: T) extends SimpleList[T] {
  def index: Int = size - 1

  def tail: SimpleList[T]
  override def dataStruct: Option[(T, SimpleList[T])] = Option((data, tail))
  override def allToString: String                    = SimpleList.allToList(this).toString()
}
object SimplePositive {
  def unapply[T](u: SimpleList[T]): Option[(T, SimpleList[T])] = u.dataStruct
}

trait SimpleListNeedFuture[+T] extends SimpleListNeedFutureImpl[T] with SimpleList[T] {
  override def future: SimpleListNeedPass[T]
  def resetPass[D >: T](t: SimpleListNeedPass[D]): SimpleListNeedFuture[D]
  override def allToString: String = future.allToString
}
trait SimpleListNeedPass[+T] extends SimpleListNeedPassImpl[T] with SimpleList[T] {
  override def pass: SimpleListNeedFuture[T]
}
