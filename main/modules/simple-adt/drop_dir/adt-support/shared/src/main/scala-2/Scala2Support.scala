package net.scalax.simple.adt
package support

trait HListLike[H1, Append1[_, _ <: H1] <: H1, Func[_, _]] {

  def append[A, T1 <: H1, U](
    t1: Func[U, A],
    t2: Func[U, T1]
  ): Func[U, Append1[A, T1]]
  def takeHead[A, T1 <: H1]: Func[Append1[A, T1], A]
  def takeTail[A, T1 <: H1]: Func[Append1[A, T1], T1]

}

trait HListLikeReImpl[H1, Append1[_, _ <: H1] <: H1, Func[_, _], H2, Append2[
  _,
  _ <: H2
] <: H2]
    extends HListLike[H1, Append1, Func] {

  override def append[A, T1 <: H1, U](
    t1: Func[U, A],
    t2: Func[U, T1]
  ): Func[U, Append1[A, T1]]
  override def takeHead[A, T1 <: H1]: Func[Append1[A, T1], A]
  override def takeTail[A, T1 <: H1]: Func[Append1[A, T1], T1]

  def reverse: HListLike[H2, Append2, ({ type OtherFunc[A, B] = Func[B, A] })#OtherFunc]

}

trait HListLikeRe[H1, Append1[_, _ <: H1] <: H1, Func[_, _], H2, Append2[
  _,
  _ <: H2
] <: H2]
    extends HListLikeReImpl[H1, Append1, Func, H2, Append2] {

  override def append[A, T1 <: H1, U](
    t1: Func[U, A],
    t2: Func[U, T1]
  ): Func[U, Append1[A, T1]]
  override def takeHead[A, T1 <: H1]: Func[Append1[A, T1], A]
  override def takeTail[A, T1 <: H1]: Func[Append1[A, T1], T1]

  override def reverse: HListLikeRe[
    H2,
    Append2,
    ({ type OtherFunc[A, B] = Func[B, A] })#OtherFunc,
    H1,
    Append1
  ]

}

object ScalaVersionSupport {

  import shapeless._

  type ProductLike                                 = HList
  type ProductLikeAppender[H, Tail <: ProductLike] = shapeless.::[H, Tail]

  type CoProductLike                                   = shapeless.Coproduct
  type CoProductLikeAppender[H, Tail <: CoProductLike] = shapeless.:+:[H, Tail]

}

trait HListLikeReInstance1
    extends HListLike[
      ScalaVersionSupport.ProductLike,
      ScalaVersionSupport.ProductLikeAppender,
      ({ type F1[A, B] = A => B })#F1
    ] {
  override def append[A, T1 <: shapeless.HList, U](
    t1: U => A,
    t2: U => T1
  ): U => shapeless.::[A, T1] = u => shapeless.::(t1(u), t2(u))
  override def takeHead[A, T1 <: shapeless.HList]: shapeless.::[A, T1] => A  = u => u.head
  override def takeTail[A, T1 <: shapeless.HList]: shapeless.::[A, T1] => T1 = u => u.tail
}

trait HListLikeReInstance2
    extends HListLike[
      ScalaVersionSupport.CoProductLike,
      ScalaVersionSupport.CoProductLikeAppender,
      ({ type F1[A, B] = B => A })#F1
    ] {
  override def append[A, T1 <: shapeless.Coproduct, U](
    t1: A => U,
    t2: T1 => U
  ): shapeless.:+:[A, T1] => U = u => u.eliminate(t1, t2)
  override def takeHead[A, T1 <: shapeless.Coproduct]: A => shapeless.:+:[A, T1]  = u => shapeless.Inl(u)
  override def takeTail[A, T1 <: shapeless.Coproduct]: T1 => shapeless.:+:[A, T1] = u => shapeless.Inr(u)
}

object ProductLike1
    extends HListLikeReInstance1
    with HListLikeRe[
      ScalaVersionSupport.ProductLike,
      ScalaVersionSupport.ProductLikeAppender,
      ({ type F1[A, B] = A => B })#F1,
      ScalaVersionSupport.CoProductLike,
      ScalaVersionSupport.CoProductLikeAppender
    ] {
  override lazy val reverse: ProductLike2.type = ProductLike2
}

object ProductLike2
    extends HListLikeReInstance2
    with HListLikeRe[
      ScalaVersionSupport.CoProductLike,
      ScalaVersionSupport.CoProductLikeAppender,
      ({ type F1[A, B] = B => A })#F1,
      ScalaVersionSupport.ProductLike,
      ScalaVersionSupport.ProductLikeAppender
    ] {
  override lazy val reverse: ProductLike1.type = ProductLike1
}
