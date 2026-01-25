package net.scalax.simple.adt
package nat
package support

trait CoProductFunc[CoLike, Ap[_, _ <: CoLike] <: CoLike] {
  def appendLeft[Head, Tail <: CoLike](m: Head): Ap[Head, Tail]
  def appendRight[Head, Tail <: CoLike](m: Tail): Ap[Head, Tail]
  def fold[Head, Tail <: CoLike, U](h: Head => U, t: Tail => U): Ap[Head, Tail] => U
}
