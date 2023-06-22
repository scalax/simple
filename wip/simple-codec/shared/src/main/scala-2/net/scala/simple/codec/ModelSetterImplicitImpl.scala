package net.scalax.simple.codec

import scala.collection.compat._
import shapeless._

trait ModelSetterImplicitImpl {
  type AuxN[_] = Any

  def generic[F[_[_]]](modelLength: ModelLength[F])(implicit p: Generic.Aux[F[AuxN], _ <: HList]): ModelSetter[F] = {
    new ModelSetter[F] {
      override def input[U[_]](data: List[Any]): F[U] = {

        def genHList(list: List[Any], length: Int): HList = {
          if (length > 0) {
            list.head :: genHList(list.tail, length - 1)
          } else HNil
        }

        val dataStruct = genHList(data, modelLength.size)

        p.asInstanceOf[Generic.Aux[F[U], HList]].from(dataStruct)
      }
    }
  }
}
