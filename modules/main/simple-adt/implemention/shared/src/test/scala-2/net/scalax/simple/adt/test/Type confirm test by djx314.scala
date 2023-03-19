package net.scalax.simple.adt.test

import net.scalax.simple.adt.{TypeAdt => Adt}
import net.scalax.simple.adt.impl.InnerTypeAdtClass
import scala.collection.compat._
import net.scalax.simple.test._

object `Type confirm test by djx314` {

  locally {
    type TypeOpt2[T] = Adt.Options2[List[T], List[String], List[Int]]
    def assertTypeMethod1[T: TypeOpt2](t: T*): List[String] = {
      val b = Adt.Options2[List[String], List[Int]](t.to(List))
      locally {
        val t1 = Tag(b)
        val t2 = Tag[InnerTypeAdtClass.CusInnerApply2[List[String], List[Int]]]
        Tag.assertType(t1, t2)
      }

      val r = b.fold(identity, _.map(_.toString))
      locally {
        val t1 = Tag(r)
        val t2 = Tag[List[String]]
        Tag.assertType(t1, t2)
      }

      r
    }
  }

}
