package net.scalax.simple.nat.sbt

import sbt._
import sbt.Keys._

import scala.collection.compat._

object ProjectKeys extends AutoPlugin {

  object autoImport {
    val baseFilesToCross = settingKey[Seq[File]]("Files to cross.")
    val baseCrossFile    = settingKey[File => Seq[File]]("Files to cross.")
  }

}
