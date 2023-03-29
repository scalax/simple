package net.scalax.simple
package codec

import doobie._
import cats._

object utils {

  implicit def apCusDoobieRead(implicit apImplicit: Apply[Read]): Applicative[Read] = new Applicative[Read] {
    override def pure[A](x: A): Read[A]                           = new Read(Nil, (_, _) => x)
    override def ap[A, B](ff: Read[A => B])(fa: Read[A]): Read[B] = apImplicit.ap(ff)(fa)
    override def map[A, B](fa: Read[A])(f: A => B): Read[B]       = apImplicit.map(fa)(f)
  }

}
