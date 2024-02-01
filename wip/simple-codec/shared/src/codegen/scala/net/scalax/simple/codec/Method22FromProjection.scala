package net.scalax.simple.codec

import decode.projection._
trait Monad1TypeLevel[M1[_]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad2TypeLevel[M1[_, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad3TypeLevel[M1[_, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad4TypeLevel[M1[_, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad5TypeLevel[M1[_, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad6TypeLevel[M1[_, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad7TypeLevel[M1[_, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad8TypeLevel[M1[_, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad9TypeLevel[M1[_, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad10TypeLevel[M1[_, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad11TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad12TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad13TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad14TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad15TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad16TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad17TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad18TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad19TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad20TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad21TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
trait Monad22TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
