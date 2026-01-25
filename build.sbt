val `root/file`        = file(".").getCanonicalFile
val `main/file`        = `root/file` / "main"
val `impractical/file` = `root/file` / "impractical"
val `wip/file`         = `root/file` / "wip"

val `modules/file`  = `main/file` / "modules"
val `test/file`     = `main/file` / "test"
val `doc-only/file` = `main/file` / "doc-only"

val `ghdmzsk/file`                             = `modules/file` / "simple-ghdmzsk"
lazy val ghdmzsk: sbtcrossproject.CrossProject = crossProject(JSPlatform, JVMPlatform) in `ghdmzsk/file`

val `adt/file` = `modules/file` / "simple-adt"

val `nat-support/file` = `adt/file` / "nat-support"
lazy val `nat-support`: sbtcrossproject.CrossProject =
  crossProject(JSPlatform, JVMPlatform) in `nat-support/file` dependsOn (`test-common` % Test)

val `adt-main/file` = `adt/file` / "adt-main"
lazy val `adt-main`: sbtcrossproject.CrossProject =
  crossProject(JSPlatform, JVMPlatform) in `adt-main/file` dependsOn (`test-common` % Test)

val `adt-codegen/file` = `adt/file` / "codegen"
val `adt-codegen`      = project in `adt-codegen/file`

val `list/file` = `wip/file` / "simple-list"
lazy val list   = crossProject(JSPlatform, JVMPlatform) in `list/file` dependsOn (ghdmzsk, `test-common` % Test) aggregate ghdmzsk

val `wire/file` = `doc-only/file` / "simple-wire"

val `wire-web-app/file` = `wire/file` / "web-app"
lazy val `wire-web-app` = project in `wire-web-app/file`

val `codec/file` = `wip/file` / "simple-codec"
lazy val codec =
  crossProject(JSPlatform, JVMPlatform) in `codec/file` dependsOn (ghdmzsk, `nat-support`, `test-common` % Test) aggregate ghdmzsk

val `codec-slick/file` = `codec/file` / "simple-codec-slick"
lazy val `codec-slick` = project in `codec-slick/file` dependsOn (codec.jvm, `test-common`.jvm % Test) aggregate codec.jvm

val `codec-circe/file` = `codec/file` / "simple-codec-circe"
lazy val `codec-circe` = crossProject(JSPlatform, JVMPlatform) in `codec-circe/file` dependsOn (codec, `test-common` % Test) aggregate codec

val `nat/file` = `impractical/file` / "simple-nat"
lazy val nat   = crossProject(JSPlatform, JVMPlatform) in `nat/file` dependsOn ghdmzsk aggregate ghdmzsk

val `append-support/file` = `modules/file` / "simple-append-support" / "append-main"
lazy val `append-support` = crossProject(JSPlatform, JVMPlatform) in `append-support/file` dependsOn (`test-common` % Test)

val `append-codegen/file` = `modules/file` / "simple-append-support" / "codegen"
lazy val `append-codegen` = project in `append-codegen/file`

val `test-common/file`                               = `test/file` / "test-common"
lazy val `test-common`: sbtcrossproject.CrossProject = crossProject(JSPlatform, JVMPlatform) in `test-common/file`

`adt-codegen` / rootCodegenPath := (`adt-main`.jvm / baseDirectory).value / ".." / ".." / "shared" / "src" / "codegen"

addCommandAlias("adtCodegen", s"; ++${scalaV.v3}; adt-codegen/codegenImpl;")
addCommandAlias("cleanSimpleAdt", "; clean; nat-supportJVM/clean; nat-supportJS/clean; adt-mainJVM/clean; adt-mainJS/clean;")
addCommandAlias("testSimpleAdt", "; +adt-mainJVM/test; +adt-mainJS/test;")
addCommandAlias("releaseSimpleAdtWithOutTest", "; all clean; +adt-mainJVM/compile; +adt-mainJS/compile; +adt-mainJVM/doc; +adt-mainJS/doc; +adt-mainJVM/publishSigned; +adt-mainJS/publishSigned; sonaBundle;")
addCommandAlias("releaseCodecLocal", "; +codecJVM/publishLocal ; +codecJS/publishLocal ;")

Global / onChangedBuildSource := ReloadOnSourceChanges

// Configure
val `simple-adt-version` = "0.0.2-M26"

// ===
scalaVersion := scalaV.v213
name         := "simple"

// ===
ghdmzsk.jvm / version            := `simple-adt-version`
ghdmzsk.js / version             := `simple-adt-version`
ghdmzsk.jvm / scalaVersion       := scalaV.v213
ghdmzsk.js / scalaVersion        := scalaV.v213
ghdmzsk.jvm / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
ghdmzsk.js / crossScalaVersions  := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
ghdmzsk.jvm / publishTo          := localStaging.value
ghdmzsk.js / publishTo           := localStaging.value

// ===
`nat-support`.jvm / version            := `simple-adt-version`
`nat-support`.js / version             := `simple-adt-version`
`nat-support`.jvm / scalaVersion       := scalaV.v213
`nat-support`.js / scalaVersion        := scalaV.v213
`nat-support`.jvm / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
`nat-support`.js / crossScalaVersions  := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
`nat-support`.jvm / publishTo          := localStaging.value
`nat-support`.js / publishTo           := localStaging.value

// ===
`adt-main`.jvm / version            := `simple-adt-version`
`adt-main`.js / version             := `simple-adt-version`
`adt-main`.jvm / scalaVersion       := scalaV.v213
`adt-main`.js / scalaVersion        := scalaV.v213
`adt-main`.jvm / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
`adt-main`.js / crossScalaVersions  := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
`adt-main`.jvm / publishTo          := localStaging.value
`adt-main`.js / publishTo           := localStaging.value

// ===
`adt-codegen` / scalaVersion := scalaV.v3

// ===
list.jvm / scalaVersion := scalaV.v213
list.js / scalaVersion  := scalaV.v213

// ===
`wire-web-app` / scalaVersion       := scalaV.v213
`wire-web-app` / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

// ===
codec.jvm / scalaVersion       := scalaV.v213
codec.js / scalaVersion        := scalaV.v213
codec.jvm / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
codec.js / crossScalaVersions  := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

// ===
`codec-slick` / scalaVersion       := scalaV.v213
`codec-slick` / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

// ===
`codec-circe`.jvm / scalaVersion       := scalaV.v213
`codec-circe`.js / scalaVersion        := scalaV.v213
`codec-circe`.jvm / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
`codec-circe`.js / crossScalaVersions  := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

// ===
nat.jvm / scalaVersion       := scalaV.v3
nat.js / scalaVersion        := scalaV.v3
nat.jvm / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
nat.js / crossScalaVersions  := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

// ===
`append-support`.jvm / version            := "0.0.1-M3"
`append-support`.js / version             := "0.0.1-M3"
`append-support`.jvm / scalaVersion       := scalaV.v213
`append-support`.js / scalaVersion        := scalaV.v213
`append-support`.jvm / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
`append-support`.js / crossScalaVersions  := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
`append-support`.jvm / publishTo          := localStaging.value
`append-support`.js / publishTo           := localStaging.value

// ===
addCommandAlias("appendPublish", "; +append-supportJVM/publishSigned; +append-supportJS/publishSigned; sonaBundle;")

// ===
`append-codegen` / scalaVersion := scalaV.v3
val codegenFile: File =
  `append-support/file` / "shared" / "src" / "codegen" / "scala" / "net" / "scalax" / "simple" / "append" / "support"
addCommandAlias("appendCodegen", s"+append-codegen/run ${codegenFile.toURI.toASCIIString}")

// ===
`test-common`.jvm / version            := `simple-adt-version`
`test-common`.js / version             := `simple-adt-version`
`test-common`.jvm / scalaVersion       := scalaV.v213
`test-common`.js / scalaVersion        := scalaV.v213
`test-common`.jvm / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
`test-common`.js / crossScalaVersions  := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
