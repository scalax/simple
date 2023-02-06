package inner

import sbt.*
import sbt.Keys.*

object CommonUtils {

  def genDirectory(sourceFile: File, parVersion: String): Seq[File] = {
    val crossV = CrossVersion.partialVersion(parVersion)
    val is2    = crossV.map(_._1 == 2L).getOrElse(false)
    val is211  = crossV.map(_._2 == 11L).getOrElse(false) && is2
    val is212  = crossV.map(_._2 == 12L).getOrElse(false) && is2
    val is213  = crossV.map(_._2 == 13L).getOrElse(false) && is2
    val is3    = crossV.map(_._1 == 3).getOrElse(false)

    val dir1 = sourceFile / "scala"
    val dir2 = Some(sourceFile / "scala-2").filter(_ => is2)
    val dir3 = Some(sourceFile / "scala-2.11").filter(_ => is211)
    val dir4 = Some(sourceFile / "scala-2.12").filter(_ => is212)
    val dir5 = Some(sourceFile / "scala-2.13").filter(_ => is213)
    val dir6 = Some(sourceFile / "scala-2.11-2.12").filter(_ => is211 || is212)
    val dir7 = Some(sourceFile / "scala-2.12-2.13").filter(_ => is212 || is213)
    val dir8 = Some(sourceFile / "scala-3").filter(_ => is3)

    Seq(Some(dir1), dir2, dir3, dir4, dir5, dir6, dir7, dir8).collect { case Some(s) => s }
  }

}
