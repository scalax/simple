package net.scalax.simple.codec

import scala.collection.compat._

trait ModelSetter[U] {
  def input(data: ModelSetter.GetItem): U
  def inputList(data: List[Any]): U = {
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
  def inputSingleton(obj: Any): U = {
    val objImpl: Any = obj
    val singletonGetItem = new ModelSetter.GetItem {
      override def get[T]: T = objImpl.asInstanceOf[T]
    }
    input(singletonGetItem)
  }
}

object ModelSetter {
  def apply[U](dataFunc: ModelSetter.GetItem => U): ModelSetter[U] = new ModelSetter[U] {
    override def input(data: ModelSetter.GetItem): U = dataFunc(data).asInstanceOf[U]
  }

  trait GetItem {
    def get[T]: T
  }
}
