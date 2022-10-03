import sbt._
import sbt.Keys._

import scala.collection.compat._

object ProjectKeys extends AutoPlugin {

  object autoImport {
    val baseFilesToCross = settingKey[Seq[File]]("Files to cross.")
    val baseCrossFile    = settingKey[File => Seq[File]]("Files to cross.")

    object scalaV {
      val v211    = "2.11.12"
      val v212    = "2.12.15"
      val v213    = "2.13.8"
      val v3      = "3.2.0"
      val v3RC    = "3.2.2-RC1-bin-20220920-b1b1dfd-NIGHTLY"
      val collect = Seq(v211, v212, v213, v3)
    }
  }

}
