package net.scalax.simple.codec

import cats.~>
import shapeless._

trait FuncTyped[F[_[_]]] {
  def fill[In[_], Out[_]](func: In ~> Out): F[In] => F[Out]
}

object FuncTyped {
  class TypeFunc[In[_], Out[_]] {
    type Func[T] = IOModel[In[T], Out[T]]
  }

  trait Impl1[F[_[_]]] extends FuncTyped[F] {
    type Set1[In[_], Out[_]] = DerivedApply[F, In, Out, F[In], F[Out], F[TypeFunc[In, Out]#Func]]
    type Set2[In[_], Out[_]] = FuncTypedImpl[F, In, Out]
    override def fill[In[_], Out[_]](func: In ~> Out): F[In] => F[Out] = setter[In, Out](FuncTyped[F, In, Out]).fill(func)
    def setter[In[_], Out[_]](set1: Set1[In, Out]): Set2[In, Out]
  }

  trait FuncTypedImpl[F[_[_]], In[_], Out[_]] {
    def fill(func: In ~> Out): F[In] => F[Out]
  }

  trait IOModel[-In, +Out] {
    def input(i: In): Out
  }

  trait FuncToModel[-In, -IOModel, +Out] {
    def input(i: In, ioModel: IOModel): Out
  }
  object FuncToModel {
    implicit def implicit1[Head1, HTail1 <: HList, HeadOut2, HList2 <: HList, HList3 <: HList](implicit
      v: FuncToModel[HTail1, HList2, HList3]
    ): FuncToModel[Head1 :: HTail1, IOModel[Head1, HeadOut2] :: HList2, HeadOut2 :: HList3] =
      new FuncToModel[Head1 :: HTail1, IOModel[Head1, HeadOut2] :: HList2, HeadOut2 :: HList3] {
        override def input(
          i: Head1 :: HTail1,
          ioModel: IOModel[Head1, HeadOut2] :: HList2
        ): HeadOut2 :: HList3 = ioModel.head.input(i.head) :: v.input(i.tail, ioModel.tail)
      }
    implicit val implicit2: FuncToModel[HNil, HNil, HNil] = new FuncToModel[HNil, HNil, HNil] {
      override def input(i: HNil, ioModel: HNil): HNil = i
    }
  }

  class DerivedApply[
    F[_[_]],
    In[_],
    Out[_],
    InModle >: F[In] <: F[In],
    OutModel >: F[Out] <: F[Out],
    FuncModel >: F[TypeFunc[In, Out]#Func] <: F[TypeFunc[In, Out]#Func]
  ] {
    def derived[H1, H2, H3 <: H4, H4](implicit
      fim: FillFuncInstance[F],
      generic1: Generic.Aux[InModle, H1],
      generic2: Generic.Aux[FuncModel, H2],
      funcToModel: FuncToModel[H1, H2, H3],
      generic3: Generic.Aux[OutModel, H4]
    ): FuncTypedImpl[F, In, Out] = new FuncTypedImpl[F, In, Out] {
      override def fill(func: In ~> Out): F[In] => F[Out] = { inModel =>
        val funcModel: F[TypeFunc[In, Out]#Func] = fim.fill[TypeFunc[In, Out]#Func](new IdentityGetter.FGen[TypeFunc[In, Out]#Func] {
          override def gen[U]: IOModel[In[U], Out[U]] = new IOModel[In[U], Out[U]] {
            override def input(i: In[U]): Out[U] = func(i)
          }
        })
        val tempHList = funcToModel.input(
          generic1.to(inModel),
          generic2.to(funcModel)
        )
        generic3.from(tempHList)
      }
    }

    def derivedWithContext[H1, H2, H3 <: H4, H4](fim: FillFuncInstance[F])(implicit
      generic1: Generic.Aux[InModle, H1],
      generic2: Generic.Aux[FuncModel, H2],
      funcToModel: FuncToModel[H1, H2, H3],
      generic3: Generic.Aux[OutModel, H4]
    ): FuncTypedImpl[F, In, Out] = new FuncTypedImpl[F, In, Out] {
      override def fill(func: In ~> Out): F[In] => F[Out] = { inModel =>
        val funcModel: F[TypeFunc[In, Out]#Func] = fim.fill[TypeFunc[In, Out]#Func](new IdentityGetter.FGen[TypeFunc[In, Out]#Func] {
          override def gen[U]: IOModel[In[U], Out[U]] = new IOModel[In[U], Out[U]] {
            override def input(i: In[U]): Out[U] = func(i)
          }
        })
        val tempHList = funcToModel.input(
          generic1.to(inModel),
          generic2.to(funcModel)
        )
        generic3.from(tempHList)
      }
    }

    object law {
      def apply[InModleImpl >: InModle <: InModle, OutModelImpl >: OutModel <: OutModel, FuncModelImpl >: FuncModel <: FuncModel]
        : DerivedApply[F, In, Out, InModleImpl, OutModelImpl, FuncModelImpl] =
        new DerivedApply[F, In, Out, InModleImpl, OutModelImpl, FuncModelImpl]
    }
  }

  def apply[F[_[_]], U1[_], U2[_]]: DerivedApply[F, U1, U2, F[U1], F[U2], F[TypeFunc[U1, U2]#Func]] =
    new DerivedApply[F, U1, U2, F[U1], F[U2], F[TypeFunc[U1, U2]#Func]]
}
