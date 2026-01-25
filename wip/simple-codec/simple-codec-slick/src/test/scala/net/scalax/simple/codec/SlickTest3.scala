package net.scalax.simple.codec

import net.scalax.simple.codec.aa.SlickUtils
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink}
import slick.ast.TypedType
import slick.jdbc.JdbcProfile
import slick.lifted.{FlatShapeLevel, Rep, Shape}

case class User3Cat(id: Option[Int], first: String, last: String, nickName: String, age: Long)
object User3Cat {
  implicit def appender: ModelLink.Pojo[User3Cat] = ModelLink.Pojo[User3Cat].derived

  type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]]

  abstract class User3CatTable[V <: JdbcProfile] extends SlickUtils[V] {
    override val slickProfile: V

    import slickProfile.api._

    implicit def userTypedTypeGeneric: FillIdentity.Pojo[TypedType, User3Cat] = FillIdentity.Pojo[TypedType, User3Cat].derived
    implicit def userShapeGeneric: FillIdentity.Pojo[ShapeF, User3Cat]        = FillIdentity.Pojo[ShapeF, User3Cat].derived

    class CommonT(tag: Tag) extends CommonTablePojo[User3Cat](tag, "person") {
      override def columnOption: ColOpt => ColOpt =
        _.copy(_.id)(_.column("id", O.AutoInc, O.PrimaryKey))
          .copy(_.first)(_.column("first_name"))
          .copy(_.last)(_.column("last_name"))
          .copy(_.nickName)(_.column("nick_name"))
    }

    def CommonTq: TableQuery[CommonT] = TableQuery(cons => new CommonT(cons))
  }
}

object Runner3 {
  type Id[T] = T

  def main(arr: Array[String]): Unit = {
    val p = slick.jdbc.MySQLProfile

    import p.api._

    object newTB extends User3Cat.User3CatTable[slick.jdbc.H2Profile] {
      override val slickProfile = slick.jdbc.H2Profile
    }

    val db: Database = Database.forURL(url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", user = "sa", password = "", driver = "org.h2.Driver")
    val sql1         = newTB.CommonTq.schema.create
    val sql2 = newTB.CommonTq += User3Cat(id = None, first = "first_name1", last = "1_last_name", nickName = "nick_name1", age = 5201314)
    val sql3 = newTB.CommonTq += User3Cat(id = None, first = "first_name2", last = "2_last_name", nickName = "nick_name2", age = 114514)
    val sql4 = newTB.CommonTq += User3Cat(id = None, first = "first_name3", last = "3_last_name", nickName = "nick_name3", age = 314159)

    val action1 = DBIO.seq(sql1, sql2, sql3, sql4)
    val action2 = newTB.CommonTq.result
    val action3 = newTB.CommonTq.filter(_.get(_.first) endsWith "3").filter(_.get(_.last) startsWith "3").result

    import scala.concurrent.ExecutionContext.Implicits.global

    val futureAction = for {
      _     <- action1
      list1 <- action2
      list2 <- action3
    } yield {
      println(list1)
      println(list2)
      println("// ===")
      println(list1.map(x1 => x1.copy(first = "new_new_name")).map(x1 => x1.copy(age = 2121213)))
      println(list1.map(x1 => x1.copy(last = "new_new_name")).map(x1 => x1.copy(age = 114514)))
    }

    scala.concurrent.Await.result(db.run(futureAction), scala.concurrent.duration.Duration.Inf)

    println(newTB.CommonTq.result.statements)
    println(action2.statements)
    println(action3.statements)
  }

}
