package net.scalax.simple.adt.codegen

import net.scalax.simple.adt.text.v3.{
  SimpleAppenderPositiveX,
  SimpleAppenderZeroX,
  SimpleProductContextX,
  SimpleProductIt10Codengen,
  SimpleProductX,
  TypeGen10Codegen
}
import net.scalax.simple.adt.text.v4.{
  NatAppender3SupportCodegen,
  NatAppender4SupportCodegen,
  NatAppender5SupportCodegen,
  NatAppender6SupportCodegen,
  NatAppender7SupportCodegen
}

object ScalaNatSupportCodegenExec {

  def main(arr: Array[String]): Unit = {

    val List(rootString) = arr.to(List)
    val rootPath         = os.Path(rootString)
    val writePath        = rootPath / "net" / "scalax" / "simple" / "adt" / "nat" / "support"

    val parameterSize: Int = 22

    /*locally {
      val filePath             = writePath / "ParameterNatSupportX.scala"
      val linerContent: String = ParametersCodengen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    /*locally {
      val filePath             = writePath / "ParameterSingleNatSupportX.scala"
      val linerContent: String = ParameterSingleNatSupportX(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    /*locally {
      val filePath             = writePath / "AppenderNatSupportX.scala"
      val linerContent: String = FAppenderCodengen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    /*locally {
      val filePath             = writePath / "TypeGenX.scala"
      val linerContent: String = TypeGenCodegen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    /*locally {
      val filePath             = writePath / "SimpleAppenderX.scala"
      val linerContent: String = SimpleAppenderX(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    locally {
      val filePath             = writePath / "SimpleAppenderPositiveX.scala"
      val linerContent: String = SimpleAppenderPositiveX(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "SimpleAppenderZeroX.scala"
      val linerContent: String = SimpleAppenderZeroX(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "SimpleProductX.scala"
      val linerContent: String = SimpleProductX(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    /*locally {
      val filePath             = writePath / "ParametersSimpleSupportX.scala"
      val linerContent: String = ParametersSimpleCodengen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    /*locally {
      val filePath             = writePath / "Parameters10Codengen.scala"
      val linerContent: String = Parameters10Codengen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    locally {
      val filePath             = writePath / "Type10GenX.scala"
      val linerContent: String = TypeGen10Codegen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    /*locally {
      val filePath             = writePath / "ExtractProductX.scala"
      val linerContent: String = ExtractProductX(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    locally {
      val filePath             = writePath / "SimpleProductContextX.scala"
      val linerContent: String = SimpleProductContextX(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "SimpleProductIt10Codengen.scala"
      val linerContent: String = SimpleProductIt10Codengen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    /*locally {
      val filePath             = writePath / "v4" / "NatAppender1Support.scala"
      val linerContent: String = NatAppender1SupportCodegen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    /*locally {
      val filePath             = writePath / "v4" / "NatAppender2Support.scala"
      val linerContent: String = NatAppender2SupportCodegen(index = parameterSize - 1).text
      os.write.over(filePath, linerContent, createFolders = true)
    }*/

    locally {
      val filePath             = writePath / "v4" / "NatAppender3Support.scala"
      val linerContent: String = NatAppender3SupportCodegen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "v4" / "NatAppender4Support.scala"
      val linerContent: String = NatAppender4SupportCodegen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "v4" / "NatAppender5Support.scala"
      val linerContent: String = NatAppender5SupportCodegen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "v4" / "NatAppender6Support.scala"
      val linerContent: String = NatAppender6SupportCodegen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

    locally {
      val filePath             = writePath / "v4" / "NatAppender7Support.scala"
      val linerContent: String = NatAppender7SupportCodegen(index = parameterSize).text
      os.write.over(filePath, linerContent, createFolders = true)
    }

  }

}
