package net.scalax.simple.nat.sbt

import sbt._
import sbt.Keys._

import scala.collection.compat._

object ProjectKeys extends AutoPlugin {

  object autoImport {
    val baseFilesToCross = settingKey[Seq[File]]("Files to cross.")
    val baseCrossFile    = settingKey[File => Seq[File]]("Files to cross.")
    val RCScalaVersion   = "3.2.2-RC1-bin-20221024-45ac398-NIGHTLY"
  }

}
