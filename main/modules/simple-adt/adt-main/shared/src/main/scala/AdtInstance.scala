package net.scalax.simple.adt
package instance

trait AdtHList

object AdtHList { AdtHListSelf =>

  val zero: AdtHList = new AdtHList {
    //
  }

  trait Positive[+H, +Tail <: AdtHList] extends AdtHList {
    def head: H
    def tail: Tail
  }
  object Positive {
    def append[H1, T1 <: AdtHList](h: H1, t: T1): AdtHListSelf.Positive[H1, T1] = new AdtHListSelf.Positive[H1, T1] {
      override def head: H1 = h
      override def tail: T1 = t
    }
  }

  trait UsePositive[H1, T1 <: AdtHList] extends Positive[H1, T1]
  object UsePositive {
    def append[H1, T1 <: AdtHList](h: H1, t: T1): AdtHListSelf.UsePositive[H1, T1] = new AdtHListSelf.UsePositive[H1, T1] {
      override def head: H1 = h
      override def tail: T1 = t
    }
  }

}

object AdtCoProduct {
  AdtCoProductSelf =>

  type AdtType = AdtCoProductSelf.Positive[_, _]
  trait Positive[+H, +Tail <: AdtCoProductSelf.Positive[_, _]] {
    def _foldCoProduct[TU](hFunc: H => TU, tFunc: Tail => TU): TU
  }
  object Positive {
    def left[H1, T1 <: AdtCoProductSelf.AdtType](h: H1): AdtCoProductSelf.Positive[H1, T1] = new AdtCoProductSelf.Positive[H1, T1] {
      override def _foldCoProduct[TU](hFunc: H1 => TU, tFunc: T1 => TU): TU = hFunc(h)
    }
    def right[H1, T1 <: AdtCoProductSelf.AdtType](r: T1): AdtCoProductSelf.Positive[H1, T1] = new AdtCoProductSelf.Positive[H1, T1] {
      override def _foldCoProduct[TU](hFunc: H1 => TU, tFunc: T1 => TU): TU = tFunc(r)
    }

    object Left {
      def unapply[H1](u: AdtCoProductSelf.Positive[H1, _ <: AdtCoProductSelf.AdtType]): Option[H1] =
        u._foldCoProduct[Option[H1]]((h1: H1) => Some(h1), _ => None)
    }
    object Right {
      def unapply[T1 <: AdtCoProductSelf.AdtType](u: AdtCoProductSelf.Positive[_, T1]): Option[T1] =
        u._foldCoProduct[Option[T1]](_ => None, (t1: T1) => Some(t1))
    }
  }

  trait One[+T] extends Positive[T, AdtCoProductSelf.One[T]] { OneSelf =>
    def _foldOne[TU](m: T => TU): TU = OneSelf._foldCoProduct[TU](m, (oth: AdtCoProductSelf.One[T]) => oth._foldOne[TU](m))
  }
  object One { OneSelf =>

    def left[T](t: T): AdtCoProductSelf.One[T] = new AdtCoProductSelf.One[T] {
      override def _foldCoProduct[TU](hFunc: T => TU, tFunc: One[T] => TU): TU = hFunc(t)
    }
    def right[T](one: One[T]): AdtCoProductSelf.One[T] = new AdtCoProductSelf.One[T] {
      override def _foldCoProduct[TU](hFunc: T => TU, tFunc: AdtCoProductSelf.One[T] => TU): TU = tFunc(one)
    }

    def unapplyImpl[T](one: AdtCoProductSelf.One[T]): T   = one._foldOne[T](identity[T])
    def unapply[T](one: AdtCoProductSelf.One[T]): Some[T] = Some(OneSelf.unapplyImpl[T](one))

  }

  object Use {

    type AdtType = AdtCoProductSelf.Use.Positive[_, _]
    trait Positive[H1, T1 <: AdtCoProductSelf.Use.AdtType] extends AdtCoProductSelf.Positive[H1, T1]
    object Positive {

      def left[H1, T1 <: AdtCoProductSelf.Use.AdtType](h: H1): AdtCoProductSelf.Use.Positive[H1, T1] =
        new AdtCoProductSelf.Use.Positive[H1, T1] {
          override def _foldCoProduct[TU](hFunc: H1 => TU, tFunc: T1 => TU): TU = hFunc(h)
        }
      def right[H1, T1 <: AdtCoProductSelf.Use.AdtType](r: T1): AdtCoProductSelf.Use.Positive[H1, T1] =
        new AdtCoProductSelf.Use.Positive[H1, T1] {
          override def _foldCoProduct[TU](hFunc: H1 => TU, tFunc: T1 => TU): TU = tFunc(r)
        }

      object Left {
        def unapply[H1](u: AdtCoProductSelf.Use.Positive[H1, _ <: AdtCoProductSelf.Use.AdtType]): Option[H1] =
          u._foldCoProduct[Option[H1]]((h1: H1) => Some(h1), _ => None)
      }
      object Right {
        def unapply[T1 <: AdtCoProductSelf.Use.AdtType](u: AdtCoProductSelf.Use.Positive[_, T1]): Option[T1] =
          u._foldCoProduct[Option[T1]](_ => None, (t1: T1) => Some(t1))
      }

    }

    trait One[T] extends AdtCoProductSelf.One[T] with AdtCoProductSelf.Use.Positive[T, AdtCoProductSelf.Use.One[T]]
    object One { UseOneSelf =>

      def left[T](t: T): AdtCoProductSelf.Use.One[T] = new AdtCoProductSelf.Use.One[T] {
        override def _foldCoProduct[TU](hFunc: T => TU, tFunc: AdtCoProductSelf.Use.One[T] => TU): TU = hFunc(t)
      }
      def right[T](one: AdtCoProductSelf.Use.One[T]): AdtCoProductSelf.Use.One[T] = new AdtCoProductSelf.Use.One[T] {
        override def _foldCoProduct[TU](hFunc: T => TU, tFunc: AdtCoProductSelf.Use.One[T] => TU): TU = tFunc(one)
      }

      def unapplyImpl[T](one: AdtCoProductSelf.Use.One[T]): T   = one._foldOne[T](identity[T])
      def unapply[T](one: AdtCoProductSelf.Use.One[T]): Some[T] = Some(UseOneSelf.unapplyImpl[T](one))

    }
  }

}
