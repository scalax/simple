import net.scalax.simple.nat.adt.TypeAdt._
import alias._
import net.scalax.simple.nat.adt.impl.FetchAdtApply
import scala.collection.compat._

object AA {

  def fetchA[T: TypeOptions2F[List, *, List[String], List[Int]]](t: T*): List[String] = {
    val b = getAdtApply[TypeOptions2[*, List[String], List[Int]]]
    b: FetchAdtApply[TypeOptions2[*, List[String], List[Int]]]
    b.input(t.to(List)).fold(identity, _.map(_.toString))
  }

}
