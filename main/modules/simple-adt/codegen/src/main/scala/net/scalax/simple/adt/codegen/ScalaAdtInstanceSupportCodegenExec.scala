package net.scalax.simple.adt.codegen

import net.scalax.simple.adt.text.v3.{
  ADTApplyFunction2,
  ADTTraitBuilder,
  ADTTraitBuilderHelper1,
  ADTTraitBuilderHelper2,
  ADTTypeAliasBuilder,
  ADTUnapplyBuilder
}

import java.net.URI

object ScalaAdtInstanceSupportCodegenExec {

  def main(arr: Array[String]): Unit = {

    val List(rootString) = arr.to(List)
    val rootPath         = os.Path(URI.create(rootString))
    val writePath        = rootPath / "net" / "scalax" / "simple" / "adt" / "instance" / "support"

    val parameterSize: Int = 22

    locally {
      val filePath             = writePath / "ADTTraitBuilder.scala"
      val linerContent: String = ADTTraitBuilder(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "ADTApplyFunction2.scala"
      val linerContent: String = ADTApplyFunction2(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "ADTUnapplyBuilder.scala"
      val linerContent: String = ADTUnapplyBuilder(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "ADTTypeAliasBuilder.scala"
      val linerContent: String = ADTTypeAliasBuilder(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "ADTTraitBuilderHelper1.scala"
      val linerContent: String = ADTTraitBuilderHelper1(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "ADTTraitBuilderHelper2.scala"
      val linerContent: String = ADTTraitBuilderHelper2(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

  }

}
