import Settings._
import ProjectKeys._

common.collect

val injectionCore = project in file(".") / "core"

name                 := "simple-injection"
injectionCore / name := "simple-injection-core"

Test / test := (Test / test).dependsOn(injectionCore / Test / test).value
