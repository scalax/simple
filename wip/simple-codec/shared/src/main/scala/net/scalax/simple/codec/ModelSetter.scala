package net.scalax.simple.codec

import scala.collection.compat._

trait ModelSetter[F[_[_]]] {
  def input[U[_]](data: ModelSetter.GetItem): F[U]
  def inputList[U[_]](data: List[Any]): F[U] = {
    var listData: List[Any] = data
    val listGetItem = new ModelSetter.GetItem {
      override def get[T]: T = {
        val curr = listData.head.asInstanceOf[T]
        listData = listData.tail
        curr
      }
    }
    input(listGetItem)
  }
  def inputSingleton[U[_]](obj: Any): F[U] = {
    val objImpl: Any = obj
    val singletonGetItem = new ModelSetter.GetItem {
      override def get[T]: T = objImpl.asInstanceOf[T]
    }
    input(singletonGetItem)
  }
}

object ModelSetter {
  type Aux[_] = Any

  def apply[F[_[_]]](dataFunc: ModelSetter.GetItem => F[ModelSetter.Aux]): ModelSetter[F] = new ModelSetter[F] {
    override def input[U[_]](data: ModelSetter.GetItem): F[U] = dataFunc(data).asInstanceOf[F[U]]
  }

  trait GetItem {
    def get[T]: T
  }
}
