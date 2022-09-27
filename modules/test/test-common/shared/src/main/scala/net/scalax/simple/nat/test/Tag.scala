package net.scalax.simple.nat.test

class Tag[T]
object Tag {
  def assertType[T](t1: Tag[T], t2: Tag[T]): List[Tag[T]] = List(t1, t2)

  def apply[T]: Tag[T]       = new Tag[T]
  def apply[T](t: T): Tag[T] = new Tag[T]
}
