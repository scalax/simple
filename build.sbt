scalaVersion := scalaV.v213
name         := "simple"

val `root/file`        = file(".").getCanonicalFile
val `main/file`        = `root/file` / "main"
val `impractical/file` = `root/file` / "impractical"
val `wip/file`         = `root/file` / "wip"

val `modules/file`  = `main/file` / "modules"
val `test/file`     = `main/file` / "test"
val `doc-only/file` = `main/file` / "doc-only"

val `ghdmzsk/file`                        = `modules/file` / "simple-ghdmzsk"
val ghdmzsk: sbtcrossproject.CrossProject = crossProject(JSPlatform, JVMPlatform) in `ghdmzsk/file`
val ghdmzskJVM: Project                   = ghdmzsk.jvm
val ghdmzskJS: Project                    = ghdmzsk.js

val `adt/file`                        = `modules/file` / "simple-adt"
val adt: sbtcrossproject.CrossProject = crossProject(JSPlatform, JVMPlatform) in `adt/file`
lazy val adtJVM: Project              = adt.jvm dependsOn (`adt-implementionJVM`, `test-commonJVM` % Test) aggregate `adt-implementionJVM`
lazy val adtJS: Project               = adt.js dependsOn (`adt-implementionJS`, `test-commonJS`    % Test) aggregate `adt-implementionJS`

val `adt-codegen/file` = `adt/file` / "codegen"
val `adt-codegen`      = project in `adt-codegen/file`

val `adt-implemention/file`    = `adt/file` / "implemention"
val `adt-implemention`         = crossProject(JSPlatform, JVMPlatform) in `adt-implemention/file`
lazy val `adt-implementionJVM` = `adt-implemention`.jvm dependsOn (`ghdmzskJVM`, `test-commonJVM` % Test) aggregate `ghdmzskJVM`
lazy val `adt-implementionJS`  = `adt-implemention`.js dependsOn (`ghdmzskJS`, `test-commonJS`    % Test) aggregate `ghdmzskJS`

val `list/file`  = `wip/file` / "simple-list"
val list         = crossProject(JSPlatform, JVMPlatform) in `list/file`
lazy val listJVM = list.jvm dependsOn (ghdmzskJVM, `test-commonJVM` % Test) aggregate ghdmzskJVM
lazy val listJS  = list.js dependsOn (ghdmzskJS, `test-commonJS`    % Test) aggregate ghdmzskJS

val `wire/file` = `doc-only/file` / "simple-wire"

val `wire-web-app/file` = `wire/file` / "web-app"
lazy val `wire-web-app` = project in `wire-web-app/file`

val `codec/file`  = `wip/file` / "simple-codec"
val codec         = crossProject(JSPlatform, JVMPlatform) in `codec/file`
lazy val codecJVM = codec.jvm dependsOn (ghdmzskJVM, `test-commonJVM` % Test) aggregate ghdmzskJVM
lazy val codecJS  = codec.js dependsOn (ghdmzskJS, `test-commonJS`    % Test) aggregate ghdmzskJS

val `codec-codegen/file` = `codec/file` / "codegen"
val `codec-codegen`      = project in `codec-codegen/file`

val `codec-slick/file` = `codec/file` / "simple-codec-slick"
lazy val `codec-slick` = project in `codec-slick/file` dependsOn (codecJVM, `test-commonJVM` % Test) aggregate codecJVM

val `nat/file`  = `impractical/file` / "simple-nat"
val nat         = crossProject(JSPlatform, JVMPlatform) in `nat/file`
lazy val natJVM = nat.jvm
lazy val natJS  = nat.js

val `test-common/file`                          = `test/file` / "test-common"
val `test-common`: sbtcrossproject.CrossProject = crossProject(JSPlatform, JVMPlatform) in `test-common/file`
lazy val `test-commonJVM`: Project              = `test-common`.jvm
lazy val `test-commonJS`: Project               = `test-common`.js

`adt-codegen` / rootCodegenPath   := (adtJVM / baseDirectory).value / ".." / "shared" / "src" / "codegen"
`codec-codegen` / rootCodegenPath := (codecJVM / baseDirectory).value / ".." / "shared" / "src" / "codegen"

addCommandAlias("codegen", s"; ++${scalaV.v3}; adt-codegen/preCodegenImpl; adt-codegen/codegenImpl")
addCommandAlias("releaseSimple", "; +adtJVM/publishSigned; +adtJS/publishSigned;")

Global / onChangedBuildSource := ReloadOnSourceChanges
