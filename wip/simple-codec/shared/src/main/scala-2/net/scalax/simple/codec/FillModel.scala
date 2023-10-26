package net.scalax.simple.codec

trait FillFunc[I[_]] {
  def instance[U]: I[U]
}
trait FillModel[U] {
  def input[I[_]](ins: FillFunc[I]): I[U]
}

object FillModel {
  implicit def implicit1[U]: FillModel[U] = new FillModel[U] {
    override def input[I[_]](ins: FillFunc[I]): I[U] = ins.instance[U]
  }
}
