import Settings._

common.collect

val adt       = project in file(".") / "simple-adt"
val injection = project in file(".") / "simple-injection"

Test / test := (Test / test).dependsOn(adt / Test / test, injection / Test / test).value
