package nat.scalax.simple.append.Codegen

import java.net.URI

object Codegen1 {
  def main(str: Array[String]): Unit = {
    val List(file1) = str.to(List)
    val rootUrl     = new URI(file1)
    val pathRoot    = os.Path(rootUrl)

    for {
      typeParamIndex <- 22 to 22
      colCountIndex  <- 22 to 22
    } yield {
      val typeParam = v1.TypeArgCodegen(typeParamIndex)
      val colCount  = typeParam.ColCountCodegen(colCountIndex)

      val subPath1 = pathRoot / s"collectioncount$colCountIndex" / s"typeparameter$typeParamIndex"
      os.makeDir.all(subPath1)
      os.write.over(subPath1 / "SimpleAppender.scala", colCount.text)
    }
  }
}
