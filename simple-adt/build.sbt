import Settings._
import ProjectKeys._

common.collect

val adtCodegen = project in file(".") / "codegen"
val adtCore    = project in file(".") / "core"

name              := "simple-adt"
adtCodegen / name := "simple-adt-codegen"
adtCore / name    := "simple-adt-core"

adtCodegen / rootCodegenPath := (adtCore / sourceDirectory).value / "codegen"

preCodegenImpl := (adtCodegen / preCodegenImpl).evaluated
codegenImpl    := (adtCodegen / codegenImpl).evaluated

Test / test := (Test / test).dependsOn(adtCore / Test / test).value
