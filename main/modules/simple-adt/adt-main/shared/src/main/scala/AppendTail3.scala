package net.scalax.simple.adt
package instance
package support

object AppendTail3 {
  AppendTailSelf =>

  def mapHead[A, B <: AdtCoProduct.Use.Positive[_, _], C](
    t: AdtCoProduct.Use.Positive[A, B]
  )(func: A => C): AdtCoProduct.Use.Positive[C, B] =
    t._foldCoProduct[AdtCoProduct.Use.Positive[C, B]](
      (a1: A) => AdtCoProduct.Use.Positive.left[C, B](func(a1)),
      (a1: B) => AdtCoProduct.Use.Positive.right[C, B](a1)
    )

  def headOption[A, B <: AdtCoProduct.Use.Positive[_, _]](t: AdtCoProduct.Use.Positive[A, B]): Option[A] =
    t._foldCoProduct[Option[A]]((a1: A) => Some(a1), (_: B) => Option.empty[A])

}
