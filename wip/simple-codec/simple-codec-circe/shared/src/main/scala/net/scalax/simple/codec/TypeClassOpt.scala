package net.scalax.simple
package codec

import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct2}
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance}
import net.scalax.simple.codec.utils.ByNameImplicit

trait TypeClassOptCtx[En[_]] {
  case class TypeClassOpt[T](info: FieldsInfo)

  object TypeClassOpt {
    TypeClassOptSelf =>

    trait Builder[F[_[_]], Model] {
      def derived(implicit
        ins: F[({ type U1[T2] = EncoderGetter[T2] })#U1],
        labelled: BasedInstalledLabelled[F],
        simpleProduct: BasedInstalledSimpleProduct[F]
      ): TypeClassOpt[Model] = {
        val pro2 = simpleProduct.basedInstalled.simpleProduct2

        val appender2 = new SimpleProduct2.SimpleAppender[({ type U1[Str, Enc] = (Str, Enc) => TypeClassOpt[Model] })#U1] {
          override def append[A1, A2, B1, B2, C1, C2](f1: ABCFunc[A1, B1, C1], f2: ABCFunc[A2, B2, C2])(
            a: (A1, A2) => TypeClassOpt[Model],
            b: (B1, B2) => TypeClassOpt[Model]
          ): (C1, C2) => TypeClassOpt[Model] = (c1: C1, c2: C2) => {
            val a1Info = a(f1.takeHead(c1), f2.takeHead(c2))
            val a2Info = b(f1.takeTail(c1), f2.takeTail(c2))
            val fieldInfo: FieldsInfo =
              FieldsInfo(succeed = a1Info.info.succeed ::: a2Info.info.succeed, failed = a1Info.info.failed ::: a2Info.info.failed)

            TypeClassOpt[Model](info = fieldInfo)
          }

          override def zero[N1, N2](p1: N1, p2: N2): (N1, N2) => TypeClassOpt[Model] = (n1, n2) => {
            TypeClassOpt[Model](FieldsInfo(succeed = List.empty, failed = List.empty))
          }
        }

        val typeGen = new SimpleProduct2.TypeGen[
          ({ type U1[Str, Enc] = (Str, Enc) => TypeClassOpt[Model] })#U1,
          ({ type U1[_] = String })#U1,
          ({ type U1[T1] = EncoderGetter[T1] })#U1
        ] {
          override def gen[Item1]: (String, EncoderGetter[Item1]) => TypeClassOpt[Model] =
            (s1: String, s2: EncoderGetter[Item1]) => {
              val opt = s2.value.fold(ifEmpty = FieldsInfo(succeed = List.empty, failed = List(s1)))(t =>
                FieldsInfo(succeed = List(s1), failed = List.empty)
              )

              TypeClassOpt[Model](opt)
            }
        }

        pro2.append[
          ({ type U1[Str, Enc] = (Str, Enc) => TypeClassOpt[Model] })#U1,
          ({ type U1[_] = String })#U1,
          ({ type U1[T1] = EncoderGetter[T1] })#U1
        ](typeGen, appender2)(labelled.labelled.modelLabelled, ins)
      }
    }

    def Pojo[Model]: Builder[({ type X1[U1[_]] = PojoInstance[U1, Model] })#X1, Model] =
      new Builder[({ type X1[U1[_]] = PojoInstance[U1, Model] })#X1, Model] {
        //
      }

    def F[F[_[_]]]: Builder[F, F[({ type Id[T] = T })#Id]] = new Builder[F, F[({ type Id[T] = T })#Id]] {
      //
    }
  }

  case class EncoderGetter[T](value: Option[En[T]])

  object EncoderGetter extends EncoderGetterPoly {
    implicit def implicitImpl1[T](implicit nn: ByNameImplicit[En[T]]): EncoderGetter[T] = EncoderGetter(Some(nn.value))
  }

  trait EncoderGetterPoly {
    implicit def implicitImpl2[T]: EncoderGetter[T] = EncoderGetter(None)
  }

}

object TypeClassOptCtx {
  def apply[En[_]]: TypeClassOptCtx[En] = new TypeClassOptCtx[En] {
    //
  }
}

case class FieldsInfo(succeed: List[String], failed: List[String])
object FieldsInfo {
  implicit def codecJson: io.circe.Codec[FieldsInfo] = io.circe.generic.semiauto.deriveCodec
}
