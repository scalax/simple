package net.scalax.simple.adt
package test

import TypeAdt.{alias => adtAlias, get => getAdtApply}, adtAlias._
import impl.FetchAdtApply
import scala.collection.compat._
import net.scalax.simple.test._

object `Type confirm test by djx314` {

  locally {
    def assertTypeMethod1[T: TypeOptions2F[List, *, List[String], List[Int]]](t: T*): List[String] = {
      val b = getAdtApply[TypeOptions2[*, List[String], List[Int]]]
      locally {
        val t1 = Tag(b)
        val t2 = Tag[FetchAdtApply[TypeOptions2[*, List[String], List[Int]]]]
        Tag.assertType(t1, t2)
      }

      val r = b.input(t.to(List)).fold(identity, _.map(_.toString))
      locally {
        val t1 = Tag(r)
        val t2 = Tag[List[String]]
        Tag.assertType(t1, t2)
      }

      r
    }
  }

}
