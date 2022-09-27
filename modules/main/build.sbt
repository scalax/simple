import Settings._
import ProjectKeys._

common.collect

val adt       = project in file(".") / "simple-adt"
val injection = project in file(".") / "simple-injection"

adt / crossDepts ++= crossDepts.value
injection / crossDepts ++= crossDepts.value

Test / test := (Test / test).dependsOn(adt / Test / test, injection / Test / test).value
