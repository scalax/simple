import Settings._
import ProjectKeys._

forTest.collect
scalaVersion := scalaV.v213

copylibs    := (for (t <- (Compile / libraryDependencies).value) yield (crossProjectPlatform.value, t))
copyManages := (for (t <- (Compile / unmanagedSourceDirectories).value) yield (crossProjectPlatform.value, t))

name := "test-common"
