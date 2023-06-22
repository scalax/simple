package net.scalax.simple.codec

import scala.collection.compat.*
import shapeless3.deriving.*

trait ModelSetterImplicitImpl:
  type AuxN[_] = Any

  def generic[F[_[_]]](modelLength: ModelLength[F])(using p: K0.ProductGeneric[F[AuxN]]): ModelSetter[F] =

    new ModelSetter[F]:

      override def input[U[_]](data: List[Any]): F[U] =

        def genProduct(list: List[Any], length: Int): Tuple =
          if (length > 0)
            list.head *: genProduct(list.tail, length - 1)
          else EmptyTuple
          end if
        end genProduct

        val dataStruct = genProduct(data, modelLength.size)

        p.asInstanceOf[K0.ProductGeneric[F[U]]].fromProduct(dataStruct)

      end input

    end new

  end generic

end ModelSetterImplicitImpl
