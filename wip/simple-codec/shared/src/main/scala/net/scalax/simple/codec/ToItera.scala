package net.scalax.simple.codec

import utils.SimpleP
import net.scalax.simple.codec.to_list_generic.{ConvertM3, SimpleProduct3}

trait ToItera[F[_[_]]] {
  def to[T]: SimpleProduct3.NotHList.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
}

object ToItera {

  class ApplyImpl[F[_[_]]] {

    def derived(implicit basedInstalled: SimpleProduct3.NotHList.Appender[F]): ToItera[F] = new ToItera[F] {
      override def to[T]: SimpleProduct3.NotHList.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        new SimpleProduct3.NotHList.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] {
          override def toHList[M[_ <: SimpleProduct3.NotHList.InputType], FT <: SimpleProduct3.NotHList.FType](
            monad: SimpleProduct3.NotHList.AppendMonad[M]
          )(
            func: SimpleProduct3.NotHList.TypeGen[M, FT]
          ): M[SimpleProduct3.NotHList.FGenericInputType[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1, FT]] = {
            class SelfFType[FUUU <: SimpleProduct3.NotHList.FType] extends SimpleProduct3.NotHList.FType {
              override type toF[U] = FUUU#toF[T]
              override type Next   = SelfFType[FUUU#Next]
            }

            class InnerSelfMapper1[VVX, FTXX <: SimpleProduct3.NotHList.FType]
                extends SimpleProduct3.NotHList.Mapper[
                  SimpleProduct3.NotHList.ItemInputType[T, FTXX],
                  SimpleProduct3.NotHList.ItemInputType[VVX, SelfFType[FTXX]]
                ] {
              override def map(ia: FTXX#toF[T]): FTXX#toF[T]        = ia
              override def reverseMap(ib: FTXX#toF[T]): FTXX#toF[T] = ib

              override def nextMapper: InnerSelfMapper1[VVX, FTXX#Next] = new InnerSelfMapper1[VVX, FTXX#Next]
            }

            val sTypeGen: SimpleProduct3.NotHList.TypeGen[M, SelfFType[FT]] = new SimpleProduct3.NotHList.TypeGen[M, SelfFType[FT]] {
              def apply[UX]: M[SimpleProduct3.NotHList.ItemInputType[UX, SelfFType[FT]]] = monad.to(func[T])(new InnerSelfMapper1[UX, FT])
            }

            val mTemp1: M[SimpleProduct3.NotHList.FGenericInputType[F, SelfFType[FT]]] =
              basedInstalled.toHList[M, SelfFType[FT]](monad)(sTypeGen)

            class InnerSelfMapper2[FTUA <: SimpleProduct3.NotHList.FType]
                extends SimpleProduct3.NotHList.Mapper[
                  SimpleProduct3.NotHList.FGenericInputType[F, SelfFType[FTUA]],
                  SimpleProduct3.NotHList.FGenericInputType[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1, FTUA]
                ] {
              override def map(ia: F[({ type U1[_] = FTUA#toF[T] })#U1]): F[({ type U1[_] = FTUA#toF[T] })#U1]        = ia
              override def reverseMap(ib: F[({ type U1[_] = FTUA#toF[T] })#U1]): F[({ type U1[_] = FTUA#toF[T] })#U1] = ib

              override def nextMapper: InnerSelfMapper2[FTUA#Next] = new InnerSelfMapper2[FTUA#Next]
            }

            monad.to[
              SimpleProduct3.NotHList.FGenericInputType[F, SelfFType[FT]],
              SimpleProduct3.NotHList.FGenericInputType[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1, FT]
            ](mTemp1)(new InnerSelfMapper2[FT])
          }
        }
    }

  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]
}
