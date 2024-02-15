package net.scalax.simple.adt.codegen_text1

import org.apache.commons.io.FileUtils

import java.nio.file.Paths

object Codegen50Text2:

  def repeat(times: Int)(text: Int => String): List[String] = {
    val listString = for (i <- 1 to times) yield text(i)
    listString.to(List)
  }

  extension (c: Char) {
    def charString: String = c.toString
  }

  def repeat_s(times: Int)(text: Int => String)(t: String): String = repeat(times)(text).mkString(t)

  def repeat_t(times: Int)(text: Int => String): String = repeat(times)(text).mkString

  def repeat_dot(times: Int)(text: Int => String): String = repeat_s(times)(text)(','.charString)
  def repeat50_dot(text: Int => String): String           = repeat_dot(50)(text)

  def trait1: String = "222"

  def render: String =
    s"""
        trait CompatFunction50[M[${repeat50_dot(_ => '_'.charString)}], ${repeat50_dot(i => s"Param$i[_]")}] {
          def model[T]: M[${repeat50_dot(i => s"Param$i[T]")}]
        }

        trait CompatTyper50[M[${repeat50_dot(_ => '_'.charString)}]] {
          def zip[${repeat50_dot(i => s"X$i")}, ${repeat50_dot(i => s"U$i")}]: M[${repeat50_dot(i => s"(X$i, U$i)")}]
          def zero: M[${repeat50_dot(_ => s"Unit")}]
        }

        trait CompatModel50[M[${repeat50_dot(_ => '_'.charString)}], F[_[_]]] {
          def compat[${repeat50_dot(i => s"Param$i[_]")}](m1: CompatFunction50[M, ${repeat50_dot(i =>
        s"Param$i"
      )}])(m2: CompatTyper50[M]): M[${repeat50_dot(i => s"F[Param$i]")}]
        }
       """.stripMargin

end Codegen50Text2
