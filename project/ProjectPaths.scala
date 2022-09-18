import sbt._

object ProjectPaths {
  self =>

  val root = file(".").getAbsoluteFile

  object projects {
    object simpleAdt {
      val root = self.root / "simple-adt"
      object subs {
        val codegen = simpleAdt.root / "codegen"
        val core    = simpleAdt.root / "core"
      }
    }
  }

}
