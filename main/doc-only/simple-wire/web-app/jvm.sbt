name := "simple-wire-web-app"

libraryDependencies ++= libScalax.`http4s-Release-dsl`.value
libraryDependencies ++= libScalax.`http4s-Release-ember-server`.value
libraryDependencies ++= libScalax.`http4s-twirl`.value
libraryDependencies ++= libScalax.`cats-effect`.value
libraryDependencies ++= libScalax.`cats-core`.value
libraryDependencies ++= libScalax.`doobie`.value
libraryDependencies ++= libScalax.`doobie-h2`.value
libraryDependencies ++= libScalax.`h2`.value
libraryDependencies ++= libScalax.`zio-config`.value

libraryDependencies ++= libScalax.`better-monadic-for`.value
