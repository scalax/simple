scalaVersion := scalaV.v213
name         := "simple"

val `root/file`        = file(".").getCanonicalFile
val `main/file`        = `root/file` / "main"
val `impractical/file` = `root/file` / "impractical"

val `modules/file` = `main/file` / "modules"
val `test/file`    = `main/file` / "test"
val `wip/file` = `root/file` / "wip"

val `ghdmzsk/file` = `modules/file` / "simple-ghdmzsk"
val ghdmzsk        = crossProject(JSPlatform, JVMPlatform) in `ghdmzsk/file`
val ghdmzskJVM     = ghdmzsk.jvm
val ghdmzskJS      = ghdmzsk.js

val `adt/file`  = `modules/file` / "simple-adt"
val adt         = crossProject(JSPlatform, JVMPlatform) in `adt/file`
lazy val adtJVM = adt.jvm dependsOn (`adt-implementionJVM`, `test-commonJVM` % Test) aggregate `adt-implementionJVM`
lazy val adtJS  = adt.js dependsOn (`adt-implementionJS`, `test-commonJS`    % Test) aggregate `adt-implementionJS`

val `adt-codegen/file` = `adt/file` / "codegen"
val `adt-codegen`      = project in `adt-codegen/file`

val `adt-ghdmzsk/file`       = `adt/file` / "ghdmzsk"
val `adt-ghdmzsk`            = crossProject(JSPlatform, JVMPlatform) in `adt-ghdmzsk/file`
lazy val `adt-ghdmzskJVM` = `adt-ghdmzsk`.jvm dependsOn (ghdmzskJVM, `test-commonJVM` % Test) aggregate ghdmzskJVM
lazy val `adt-ghdmzskJS`  = `adt-ghdmzsk`.js dependsOn (ghdmzskJS, `test-commonJS`    % Test) aggregate ghdmzskJS

val `adt-implemention/file`    = `adt/file` / "implemention"
val `adt-implemention`         = crossProject(JSPlatform, JVMPlatform) in `adt-implemention/file`
lazy val `adt-implementionJVM` = `adt-implemention`.jvm dependsOn (`adt-ghdmzskJVM`, `test-commonJVM` % Test) aggregate `adt-ghdmzskJVM`
lazy val `adt-implementionJS`  = `adt-implemention`.js dependsOn (`adt-ghdmzskJS`, `test-commonJS`    % Test) aggregate `adt-ghdmzskJS`

val `list/file`  = `wip/file` / "simple-list"
val list         = crossProject(JSPlatform, JVMPlatform) in `list/file`
lazy val listJVM = list.jvm dependsOn (ghdmzskJVM, `test-commonJVM` % Test) aggregate ghdmzskJVM
lazy val listJS  = list.js dependsOn (ghdmzskJS, `test-commonJS`    % Test) aggregate ghdmzskJS

val `wire/file` = `wip/file` / "simple-wire"

val `wire-web-app/file` = `wire/file` / "web-app"
lazy val `wire-web-app` = project in `wire-web-app/file`

val `wire-web-scala/file` = `wire/file` / "web-app-scala-style"
lazy val `wire-web-scala` = project in `wire-web-scala/file`

val `codec/file`  = `wip/file` / "simple-codec"
val codec         = crossProject(JSPlatform, JVMPlatform) in `codec/file`
lazy val codecJVM = codec.jvm dependsOn (ghdmzskJVM, `test-commonJVM` % Test) aggregate ghdmzskJVM
lazy val codecJS  = codec.js dependsOn (ghdmzskJS, `test-commonJS`    % Test) aggregate ghdmzskJS

val `nat/file`  = `impractical/file` / "simple-nat"
val nat         = crossProject(JSPlatform, JVMPlatform) in `nat/file`
lazy val natJVM = nat.jvm dependsOn ghdmzskJVM aggregate ghdmzskJVM
lazy val natJS  = nat.js dependsOn ghdmzskJS aggregate ghdmzskJS

val `generic/file`  = `wip/file` / "simple-generic"
val generic         = crossProject(JSPlatform, JVMPlatform) in `generic/file`
lazy val genericJVM = generic.jvm dependsOn (ghdmzskJVM, `test-commonJVM` % Test) aggregate ghdmzskJVM
lazy val genericJS  = generic.js dependsOn (ghdmzskJS, `test-commonJS`    % Test) aggregate ghdmzskJS

val `test-common/file`    = `test/file` / "test-common"
val `test-common`         = crossProject(JSPlatform, JVMPlatform) in `test-common/file`
lazy val `test-commonJVM` = `test-common`.jvm
lazy val `test-commonJS`  = `test-common`.js

`adt-codegen` / rootCodegenPath := (adtJVM / baseDirectory).value / ".." / "shared" / "src" / "codegen"

addCommandAlias("codegen", s"; ++${scalaV.v3}!; adt-codegen/preCodegenImpl; adt-codegen/codegenImpl")
addCommandAlias("releaseSimple", "; +adtJVM/publishSigned; +adtJS/publishSigned;")

Global / onChangedBuildSource := ReloadOnSourceChanges
