import Settings._
import ProjectKeys._
import rootProject.subs.simpleAdt.subs.{codegen => codegenPath, core => corePath}

common.collect

val codegen = project in codegenPath
val core    = project in corePath

name        := "simple-adt"
core / name := "simple-adt-core"

codegen / rootCodegenPath := corePath / "src" / "codegen"

preGen := (codegen / preGen).evaluated
runGen := (codegen / runGen).evaluated

Test / test := ((Test / test).dependsOn(core / Test / test)).value
