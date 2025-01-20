package net.scalax.simple.codec

sealed trait CodingEnv {
  def fold[A, B >: A, C >: B](dev: => A, product: => B): C
}

object CodingEnv {
  implicit def defaultEnv: CodingEnv = ProductEnv
}

case object ProductEnv extends CodingEnv {
  override def fold[A, B >: A, C >: B](dev: => A, product: => B): C = product
}

case object DevEnv extends CodingEnv {
  override def fold[A, B >: A, C >: B](dev: => A, product: => B): C = dev
}
