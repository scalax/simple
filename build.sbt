val `module/file`      = `root/file` / "modules"
val `impractical/file` = `module/file` / "impractical"

val `nat/file` = `impractical/file` / "simple-nat"

val `test/file` = `module/file` / "test"
val `main/file` = `module/file` / "main"

val `core/file`                     = `main/file` / "simple-core"
val `wire/file`                     = `main/file` / "simple-wire"
val `wire-web-app/file`             = `wire/file` / "web-app"
val `wire-web-app-scala-style/file` = `wire/file` / "web-app-scala-style"
val `codec/file`                    = `main/file` / "simple-codec"
val `adt/file`                      = `main/file` / "simple-adt"
val `adt-codegen/file`              = `adt/file` / "codegen"
val `adt-core/file`                 = `adt/file` / "core"
val `generic/file`                  = `main/file` / "simple-generic"

val `list/file` = `main/file` / "simple-list"

val `test-common/file` = `test/file` / "test-common"

scalaVersion := scalaV.v213
name         := "simple"

lazy val testProjects = project in `test/file`
lazy val mainProjects = project in `main/file`

lazy val core    = crossProject(JSPlatform, JVMPlatform) in `core/file`
lazy val coreJVM = core.jvm
lazy val coreJS  = core.js

lazy val adt    = crossProject(JSPlatform, JVMPlatform) in `adt/file`
lazy val adtJVM = adt.jvm dependsOn `adt-coreJVM` aggregate `adt-coreJVM`
lazy val adtJS  = adt.js dependsOn `adt-coreJS` aggregate `adt-coreJS`

lazy val `adt-codegen` = project in `adt-codegen/file`

lazy val `adt-core`    = crossProject(JSPlatform, JVMPlatform) in `adt-core/file`
lazy val `adt-coreJVM` = `adt-core`.jvm dependsOn (coreJVM, `test-commonJVM` % Test) aggregate coreJVM
lazy val `adt-coreJS`  = `adt-core`.js dependsOn (coreJS, `test-commonJS`    % Test) aggregate coreJS

lazy val list    = crossProject(JSPlatform, JVMPlatform) in `list/file`
lazy val listJVM = list.jvm dependsOn (coreJVM, `test-commonJVM` % Test) aggregate coreJVM
lazy val listJS  = list.js dependsOn (coreJS, `test-commonJS`    % Test) aggregate coreJS

lazy val wire             = project in `wire/file`
lazy val `wire-web-app`   = project in `wire-web-app/file`
lazy val `wire-web-scala` = project in `wire-web-app-scala-style/file`

lazy val codec    = crossProject(JSPlatform, JVMPlatform) in `codec/file`
lazy val codecJVM = codec.jvm dependsOn (coreJVM, `test-commonJVM` % Test) aggregate coreJVM
lazy val codecJS  = codec.js dependsOn (coreJS, `test-commonJS`    % Test) aggregate coreJS

lazy val nat    = crossProject(JSPlatform, JVMPlatform) in `nat/file`
lazy val natJVM = nat.jvm dependsOn coreJVM aggregate coreJVM
lazy val natJS  = nat.js dependsOn coreJS aggregate coreJS

lazy val generic    = crossProject(JSPlatform, JVMPlatform) in `generic/file`
lazy val genericJVM = generic.jvm dependsOn (coreJVM, `test-commonJVM` % Test) aggregate coreJVM
lazy val genericJS  = generic.js dependsOn (coreJS, `test-commonJS`    % Test) aggregate coreJS

lazy val `test-common`    = crossProject(JSPlatform, JVMPlatform) in `test-common/file`
lazy val `test-commonJVM` = `test-common`.jvm
lazy val `test-commonJS`  = `test-common`.js

`adt-codegen` / rootCodegenPath := (`adt-coreJVM` / baseDirectory).value / ".." / "shared" / "src" / "codegen"

addCommandAlias("preCodegen", s";++${scalaV.v3}!;adt-codegen/preCodegenImpl")
addCommandAlias("codegen", s";++${scalaV.v3}!;adt-codegen/codegenImpl")
addCommandAlias("executeTest", "+mainProjects/test")

Global / onChangedBuildSource := ReloadOnSourceChanges

addCommandAlias(
  "releaseSimple",
  "; +coreJVM/publishSigned; +coreJS/publishSigned; +adt-coreJVM/publishSigned; +adt-coreJS/publishSigned; +adtJVM/publishSigned; +adtJS/publishSigned;"
)
