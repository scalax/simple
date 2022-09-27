import Settings._
import ProjectKeys._

val depts = Dependencies

common.collect
scalaVersion := scalaV.v213

depts.scalaCollectionCompat

libraryDependencies ++= appendSeq(
  copylibs.value,
  crossProjectPlatform.value,
  libraryDependencies.value
)(compareModuleID).map(s => scala.util.Try(s % Test).toOption).collect { case Some(s) => s }

Test / unmanagedSourceDirectories ++= appendSeq(copyManages.value, crossProjectPlatform.value, (Test / unmanagedSourceDirectories).value)(
  compareFile
)
