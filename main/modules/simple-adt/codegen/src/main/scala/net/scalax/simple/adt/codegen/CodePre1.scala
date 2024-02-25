package net.scalax.simple.adt.codegen

object CodePre1:

  def repeat(count: Int)(text: Int => String): String = {
    val textVector1 = for i1 <- 1 to count yield text(i1)
    textVector1.mkString
  }

  val text1: String = s"""
package net.scalax.simple.adt
package impl

trait ADTPassedFunctionImpl extends ADTPassedFunction {
  ${repeat(22)(i1 => s"""def extraFunctionAdt$i1 = {
    //
    //
    1
  }
  """.stripMargin)}
}
""".stripMargin

end CodePre1
