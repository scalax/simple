import sbt._
import sbt.Keys._

object ProjectKeys {
  val baseFilesToCross = settingKey[Seq[File]]("Files to cross.")
  val baseCrossFile    = settingKey[File => Seq[File]]("Files to cross.")
}
