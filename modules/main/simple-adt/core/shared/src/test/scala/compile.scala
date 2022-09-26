import net.scalax.simple.nat.adt.TypeAdt.{alias => adtAlias, get => getAdtApply}
import adtAlias._
import net.scalax.simple.nat.adt.impl.FetchAdtApply
import scala.collection.compat._

object TypeConfirm {

  class Tag[T]
  object Tag {
    def apply[T]: Tag[T]       = new Tag[T]
    def apply[T](t: T): Tag[T] = new Tag[T]
  }

  def assertType[T](t1: Tag[T], t2: Tag[T]): List[Tag[T]] = List(t1, t2)

  {
    def assertTypeMethod1[T: TypeOptions2F[List, *, List[String], List[Int]]](t: T*): List[String] = {
      val b = getAdtApply[TypeOptions2[*, List[String], List[Int]]]
      locally {
        val t1 = Tag(b)
        val t2 = Tag[FetchAdtApply[TypeOptions2[*, List[String], List[Int]]]]
        assertType(t1, t2)
      }

      val r = b.input(t.to(List)).fold(identity, _.map(_.toString))
      locally {
        val t1 = Tag(r)
        val t2 = Tag[List[String]]
        assertType(t1, t2)
      }

      r
    }
  }

}
