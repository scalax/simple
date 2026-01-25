package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct1, SimpleProductContextX}

trait IndexOfPropertyName[F[_[_]]] {
  def ofName(input1: String, model: F[({ type T1[_] = String })#T1]): Int
}

object IndexOfPropertyName {

  trait ListLike {
    def size: Int
  }
  object PositiveListLike extends (ListLike => ListLike) {
    override def apply(v1: ListLike): ListLike = new ListLike {
      override def size: Int = v1.size + 1
    }
  }
  object ZeroListLike extends ListLike {
    override def size: Int = 0
  }

  trait ContainsString[T] {
    def input(str: T): Either[ListLike, ListLike => ListLike]
  }

  val appendMonad: SimpleProduct1.SimpleAppender[ContainsString] = new SimpleProduct1.SimpleAppender[ContainsString] {
    override def append[A1, B1, C1](c: ABCFunc[A1, B1, C1])(
      ma: ContainsString[A1],
      mb: ContainsString[B1]
    ): ContainsString[C1] = new ContainsString[C1] {
      override def input(pro: C1): Either[ListLike, ListLike => ListLike] = {
        def head1: A1 = c.takeHead(pro)
        def tail1: B1 = c.takeTail(pro)

        ma.input(head1)
          .fold(
            leftZero => Left(leftZero),
            rightAppender1 =>
              mb.input(tail1)
                .fold(
                  leftZero => Left(rightAppender1(leftZero)),
                  rightAppender2 => Right((l: ListLike) => rightAppender2(rightAppender1(l)))
                )
          )
      }
    }

    override def zero[N1](n1: N1): ContainsString[N1] = new ContainsString[N1] {
      override def input(t: N1): Either[ListLike, ListLike => ListLike] = Right(identity)
    }
  }

  def toNamed(proNameToFind: String): SimpleProduct1.TypeGen[ContainsString, ({ type T1[_] = String })#T1] =
    new SimpleProduct1.TypeGen[ContainsString, ({ type T1[_] = String })#T1] {
      override def gen[T]: ContainsString[String] = new ContainsString[String] {
        override def input(str: String): Either[ListLike, ListLike => ListLike] = {
          if (str == proNameToFind) Left(ZeroListLike) else Right(t => PositiveListLike(t))
        }
      }
    }

  class Builder[F[_[_]]] {
    def derived(appender1: SimpleProduct1.ProductAdapter[F]): IndexOfPropertyName[F] = new IndexOfPropertyName[F] {
      override def ofName(input1: String, model: F[({ type T1[_] = String })#T1]): Int = {
        val containFunc = appender1.append[ContainsString, ({ type T1[_] = String })#T1](toNamed(input1), appendMonad)
        containFunc.input(model).left.getOrElse(throw new Exception(s"Not confirm property name.(name: $input1)")).size
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
