scalaVersion := scalaV.v213
name         := "simple"

val `root/file`   = file(".").getCanonicalFile
val `module/file` = `root/file` / "modules"

val `test/file`        = `module/file` / "test"
val `impractical/file` = `module/file` / "impractical"
val `main/file`        = `module/file` / "main"

val `core/file` = `main/file` / "simple-core"
val core        = crossProject(JSPlatform, JVMPlatform) in `core/file`
val coreJVM     = core.jvm
val coreJS      = core.js

val `adt/file`  = `main/file` / "simple-adt"
val adt         = crossProject(JSPlatform, JVMPlatform) in `adt/file`
lazy val adtJVM = adt.jvm dependsOn (`adt-implementionJVM`, `test-commonJVM` % Test) aggregate `adt-implementionJVM`
lazy val adtJS  = adt.js dependsOn (`adt-implementionJS`, `test-commonJS`    % Test) aggregate `adt-implementionJS`

val `adt-codegen/file` = `adt/file` / "codegen"
val `adt-codegen`      = project in `adt-codegen/file`

val `adt-core/file`    = `adt/file` / "core"
val `adt-core`         = crossProject(JSPlatform, JVMPlatform) in `adt-core/file`
lazy val `adt-coreJVM` = `adt-core`.jvm dependsOn (coreJVM, `test-commonJVM` % Test) aggregate coreJVM
lazy val `adt-coreJS`  = `adt-core`.js dependsOn (coreJS, `test-commonJS`    % Test) aggregate coreJS

val `adt-implemention/file`    = `adt/file` / "implemention"
val `adt-implemention`         = crossProject(JSPlatform, JVMPlatform) in `adt-implemention/file`
lazy val `adt-implementionJVM` = `adt-implemention`.jvm dependsOn (`adt-coreJVM`, `test-commonJVM` % Test) aggregate `adt-coreJVM`
lazy val `adt-implementionJS`  = `adt-implemention`.js dependsOn (`adt-coreJS`, `test-commonJS`    % Test) aggregate `adt-coreJS`

val `list/file`  = `main/file` / "simple-list"
val list         = crossProject(JSPlatform, JVMPlatform) in `list/file`
lazy val listJVM = list.jvm dependsOn (coreJVM, `test-commonJVM` % Test) aggregate coreJVM
lazy val listJS  = list.js dependsOn (coreJS, `test-commonJS`    % Test) aggregate coreJS

val `wire/file` = `main/file` / "simple-wire"

val `wire-web-app/file` = `wire/file` / "web-app"
lazy val `wire-web-app` = project in `wire-web-app/file`

val `wire-web-scala/file` = `wire/file` / "web-app-scala-style"
lazy val `wire-web-scala` = project in `wire-web-scala/file`

val `codec/file`  = `main/file` / "simple-codec"
val codec         = crossProject(JSPlatform, JVMPlatform) in `codec/file`
lazy val codecJVM = codec.jvm dependsOn (coreJVM, `test-commonJVM` % Test) aggregate coreJVM
lazy val codecJS  = codec.js dependsOn (coreJS, `test-commonJS`    % Test) aggregate coreJS

val `nat/file`  = `impractical/file` / "simple-nat"
val nat         = crossProject(JSPlatform, JVMPlatform) in `nat/file`
lazy val natJVM = nat.jvm dependsOn coreJVM aggregate coreJVM
lazy val natJS  = nat.js dependsOn coreJS aggregate coreJS

val `generic/file`  = `main/file` / "simple-generic"
val generic         = crossProject(JSPlatform, JVMPlatform) in `generic/file`
lazy val genericJVM = generic.jvm dependsOn (coreJVM, `test-commonJVM` % Test) aggregate coreJVM
lazy val genericJS  = generic.js dependsOn (coreJS, `test-commonJS`    % Test) aggregate coreJS

val `test-common/file`    = `test/file` / "test-common"
val `test-common`         = crossProject(JSPlatform, JVMPlatform) in `test-common/file`
lazy val `test-commonJVM` = `test-common`.jvm
lazy val `test-commonJS`  = `test-common`.js

`adt-codegen` / rootCodegenPath := (`adt-coreJVM` / baseDirectory).value / ".." / "shared" / "src" / "codegen"

addCommandAlias("codegen", s"; ++${scalaV.v3}!; adt-codegen/preCodegenImpl; adt-codegen/codegenImpl")
addCommandAlias("releaseSimple", "; +adtJVM/publishSigned; +adtJS/publishSigned;")

Global / onChangedBuildSource := ReloadOnSourceChanges
