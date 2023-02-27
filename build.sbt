val `module/file`      = `root/file` / "modules"
val `impractical/file` = `module/file` / "impractical"

val `nat/file` = `impractical/file` / "simple-nat"

val `test/file` = `module/file` / "test"
val `main/file` = `module/file` / "main"

val `core/file`                     = `main/file` / "simple-core"
val `wire/file`                     = `main/file` / "simple-wire"
val `wire-core/file`                = `wire/file` / "core"
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

lazy val core = crossProject(JSPlatform, JVMPlatform) in `core/file`

lazy val coreJVM = core.jvm
lazy val coreJS  = core.js

lazy val adt = crossProject(JSPlatform, JVMPlatform) in `adt/file` dependsOn `adt-core`

lazy val `adt-codegen` = project in `adt-codegen/file`
lazy val `adt-core`    = crossProject(JSPlatform, JVMPlatform) in `adt-core/file` dependsOn (nat, `test-common` % Test)

lazy val `adt-coreJVM` = `adt-core`.jvm
lazy val `adt-coreJS`  = `adt-core`.js

lazy val list = crossProject(JSPlatform, JVMPlatform) in `list/file` dependsOn (core, `test-common` % Test)

lazy val listJVM = list.jvm
lazy val listJS  = list.js

lazy val wire = project in `wire/file`

lazy val `wire-web-app`   = project in `wire-web-app/file`
lazy val `wire-web-scala` = project in `wire-web-app-scala-style/file`

lazy val codec = crossProject(JSPlatform, JVMPlatform) in `codec/file` dependsOn (core, `test-common` % Test)

lazy val codecJVM = codec.jvm
lazy val codecJS  = codec.js

lazy val nat    = crossProject(JSPlatform, JVMPlatform) in `nat/file` dependsOn core
lazy val natJVM = nat.jvm
lazy val natJS  = nat.js

lazy val generic    = crossProject(JSPlatform, JVMPlatform) in `generic/file` dependsOn (core, `test-common` % Test)
lazy val genericJVM = generic.jvm
lazy val genericJS  = generic.js

lazy val `test-common` = crossProject(JSPlatform, JVMPlatform) in `test-common/file`

`adt-codegen` / rootCodegenPath := (`adt-core`.jvm / baseDirectory).value / ".." / "shared" / "src" / "codegen"

val adtTestAll     = adt.componentProjects.map(t => t / Test / test)
val adtCoreTestAll = `adt-core`.componentProjects.map(t => t / Test / test)
val listTestAll    = list.componentProjects.map(t => t / Test / test)
val wireTestAll    = Seq.empty
val codecTestAll   = codec.componentProjects.map(t => t / Test / test)
val genericTestAll = generic.componentProjects.map(t => t / Test / test)

val adtTestAction     = adtTestAll ++: adtCoreTestAll
val listTestAction    = listTestAll
val wireTestAction    = wireTestAll
val codecTestAction   = codecTestAll
val genericTestAction = genericTestAll

mainProjects / Test / test := (mainProjects / Test / test)
  .dependsOn(adtTestAction: _*)
  .dependsOn(listTestAction: _*)
  .dependsOn(wireTestAction: _*)
  .dependsOn(codecTestAction: _*)
  .dependsOn(genericTestAction: _*)
  .value

addCommandAlias("preCodegen", s";++${scalaV.v3}!;adt-codegen/preCodegenImpl")
addCommandAlias("codegen", s";++${scalaV.v3}!;adt-codegen/codegenImpl")
addCommandAlias("executeTest", "+mainProjects/test")

Global / onChangedBuildSource := ReloadOnSourceChanges

addCommandAlias(
  "releaseSimple",
  "; +coreJVM/publishSigned; +coreJS/publishSigned; +adt-coreJVM/publishSigned; +adt-coreJS/publishSigned; +adtJVM/publishSigned; +adtJS/publishSigned;"
)
