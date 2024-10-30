package net.scalax.simple.adt

import scala.collection.compat._
import scala.reflect.ClassTag

object TempAppender {

  def buildTemp[T](appender: ListLikeAppender[T], cutNumber: Int): AppendTemp[T] = {
    val buildAction: BuildAction[T] = new BuildAction[T](listLikeAppender = appender)
    new buildAction.AppendTempLazyImplZero(cutNumber = cutNumber)
  }

  type ListLikeAppenderPos[T] = T => T

  trait ListLikeAppender[T] {
    def zero: T
    val append: ListLikeAppenderPos[T]
  }

  object ListLikeAppender {
    def apply[T](zero: => T, append: ListLikeAppenderPos[T]): ListLikeAppender[T] = {
      def zero1: T                        = zero
      val append1: ListLikeAppenderPos[T] = append

      new ListLikeAppender[T] {
        override def zero: T                        = zero1
        override val append: ListLikeAppenderPos[T] = append1
      }
    }
  }

  trait AppendTemp[T] {
    self =>

    def getByIndex(index: Int): AppendTemp[T] = {
      if (self.index == index)
        self
      else
        self.next.getByIndex(index)
    }

    def current: T
    def index: Int

    def next: AppendTemp[T]

    def reverseList: List[T]
    def toList: List[T]                                        = reverseList.reverse
    def reverseArray(implicit classTag: ClassTag[T]): Array[T] = reverseList.to(Array)
    def toArray(implicit classTag: ClassTag[T]): Array[T]      = toList.to(Array)
  }

  private class BuildAction[T](listLikeAppender: ListLikeAppender[T]) {
    abstract class AppendTempImpl(
      override val current: T,
      override val index: Int
    ) extends AppendTemp[T] {
      self =>

      override def reverseList: List[T]

      override def next: AppendTemp[T] = {
        val newCurrent: T = listLikeAppender.append(self.current)
        new AppendTempImpl(
          current = newCurrent,
          index = self.index + 1
        ) {
          override def reverseList: List[T] = newCurrent :: self.reverseList
        }
      }

    }

    class AppendTempLazyImpl(
      cutNumber: Int,
      override val current: T,
      override val index: Int,
      override val reverseList: List[T]
    ) extends AppendTempImpl(current = current, index = index) {
      self =>

      override lazy val next: AppendTemp[T] = {
        val simpleNext: AppendTemp[T] = super.next

        if (cutNumber > index) {
          new AppendTempLazyImpl(
            cutNumber = cutNumber,
            current = simpleNext.current,
            index = simpleNext.index,
            reverseList = simpleNext.reverseList
          )
        } else {
          simpleNext
        }
      }

    }

    class AppendTempLazyImplZero(cutNumber: Int)
        extends AppendTempLazyImpl(
          cutNumber = cutNumber,
          current = listLikeAppender.zero,
          index = 0,
          reverseList = List(listLikeAppender.zero)
        )
  }

}

trait Valued[+T] {
  def value: T
}

trait ResultFolderValuedApply[Data, Tail[_] <: Any, Result] {
  self =>

  // def __peotectedValuedApply: ResultFolder[AA]

  def apply[TD >: Result](f: Data => TD): Tail[TD]
}

trait ResultFolder[Data, Tail[_ >: Result] <: Any, Result] {
  def apply[TD >: Result](f: Data => TD): Tail[TD]
}

object CCDD {

  trait ABDECD[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, Q1, Q1Append[
    _,
    _ <: Q1
  ] <: Q1, Q1Zero <: Q1, M[_ <: P1, _ <: X1, _ <: Q1]] {
    def append[A, P <: P1, X <: X1, Q <: Q1](m: M[P, X, Q]): M[P1Append[A, P], X1Append[A, X], Q1Append[A, Q]]
    def zero: M[P1Zero, X1Zero, Q1Zero]
  }

  trait ABCD2[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, M2[_ <: P1, _ <: X1]]
      extends ABDECD[
        P1,
        P1Append,
        P1Zero,
        P1,
        P1Append,
        P1Zero,
        X1,
        X1Append,
        X1Zero,
        ({ type MX[A <: P1, B <: P1, C <: X1] = M2[B, C] })#MX
      ] {
    def append2[A, P <: P1, X <: X1](m: M2[P, X]): M2[P1Append[A, P], X1Append[A, X]]
    def zero2: M2[P1Zero, X1Zero]

    final override def append[A, PP <: P1, P2 <: P1, X <: X1](m: M2[P2, X]): M2[P1Append[A, P2], X1Append[A, X]] = append2(m)
    final override def zero: M2[P1Zero, X1Zero]                                                                  = zero2
  }

  type ProductType22AppenderImpl2[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, M2[
    _ <: P1,
    _ <: X1
  ]] = utils.ProductType22Appender[
    P1,
    P1Append,
    P1Zero,
    P1,
    P1Append,
    P1Zero,
    X1,
    X1Append,
    X1Zero,
    ({ type MX[A <: P1, B <: P1, C <: X1] = M2[B, C] })#MX
  ]

  object ProductType22AppenderImpl2 {
    def gen[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, M2[
      _ <: P1,
      _ <: X1
    ]](
      a: ABCD2[P1, P1Append, P1Zero, X1, X1Append, X1Zero, M2]
    ): ProductType22AppenderImpl2[P1, P1Append, P1Zero, X1, X1Append, X1Zero, M2] = utils.ProductType22AppenderGen.gen[
      P1,
      P1Append,
      P1Zero,
      P1,
      P1Append,
      P1Zero,
      X1,
      X1Append,
      X1Zero,
      ({ type MX[A <: P1, B <: P1, C <: X1] = M2[B, C] })#MX
    ](a)
  }

  trait ABCD1[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, M2[_ <: P1]]
      extends ABCD2[P1, P1Append, P1Zero, P1, P1Append, P1Zero, ({ type MX[B <: P1, C <: P1] = M2[C] })#MX] {
    def append1[A, P <: P1](m: M2[P]): M2[P1Append[A, P]]
    def zero1: M2[P1Zero]

    final override def append2[A, PP <: P1, P2 <: P1](m: M2[P2]): M2[P1Append[A, P2]] = append1(m)
    final override def zero2: M2[P1Zero]                                              = zero1
  }

  type ProductType22AppenderImpl1[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, M2[_ <: P1]] = ProductType22AppenderImpl2[
    P1,
    P1Append,
    P1Zero,
    P1,
    P1Append,
    P1Zero,
    ({ type MX[B <: P1, C <: P1] = M2[C] })#MX
  ]

  object ProductType22AppenderImpl1 {
    def gen[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, M2[
      _ <: P1
    ]](a: ABCD1[P1, P1Append, P1Zero, M2]): ProductType22AppenderImpl1[P1, P1Append, P1Zero, M2] = utils.ProductType22AppenderGen.gen[
      P1,
      P1Append,
      P1Zero,
      P1,
      P1Append,
      P1Zero,
      P1,
      P1Append,
      P1Zero,
      ({ type MX[A <: P1, B <: P1, C <: P1] = M2[C] })#MX
    ](a)
  }

}
