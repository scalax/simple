import sbt._

object rootProject {
  self =>

  val root = file(".").getAbsoluteFile

  object subs {
    object simpleAdt {
      val root = self.root / "simple-adt"
      object subs {
        val codegen = simpleAdt.root / "codegen"
        val core    = simpleAdt.root / "core"
      }
    }
  }

}
