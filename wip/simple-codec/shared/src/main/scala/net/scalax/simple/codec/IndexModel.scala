package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct1
import utils.SimpleP

trait IndexModel[F[_[_]]] {
  def model: F[({ type Id[_] = Int })#Id]
}

object IndexModel {

  class DerivedApply[F[_[_]]] {

    def derived(p: SimpleP.Appender[F]): IndexModel[F] = {
      val simpleProduct1 = SimpleProduct1.Appender[F].derived(p)

      val appendMonad: SimpleProduct1.AppendMonad[({ type IntFunc[t] = Int => (t, Int) })#IntFunc] =
        new SimpleProduct1.AppendMonad[({ type IntFunc[t] = Int => (t, Int) })#IntFunc] {
          override def zip[A, B](ma: Int => (A, Int), ms: Int => (B, Int)): Int => ((A, B), Int) = { (n: Int) =>
            val (b, index1) = ms(n)
            val (a, index2) = ma(index1)
            ((a, b), index2)
          }

          override def to[A, B](m1: Int => (A, Int))(in1: A => B)(out1: B => A): Int => (B, Int) = { n =>
            val (a, index) = m1(n)
            (in1(a), index)
          }
          override def zero: Int => (Unit, Int) = n => ((), n)
        }

      val typeGen: SimpleProduct1.TypeGen[({ type IntFunc[t] = Int => (t, Int) })#IntFunc, ({ type Id[_] = Int })#Id] =
        new SimpleProduct1.TypeGen[({ type IntFunc[t] = Int => (t, Int) })#IntFunc, ({ type Id[_] = Int })#Id] {
          override def apply[T]: Int => (Int, Int) = t => (t, t + 1)
        }

      val m: F[({ type Id[_] = Int })#Id] =
        simpleProduct1.toHList1[({ type IntFunc[t] = Int => (t, Int) })#IntFunc, ({ type Id[_] = Int })#Id](appendMonad)(typeGen)(0)._1

      new IndexModel[F] {
        override def model: F[({ type Id[_] = Int })#Id] = m
      }
    }

  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F] {
    //
  }

}
