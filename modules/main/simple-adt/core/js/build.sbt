import Settings._

val depts = Dependencies

common.collect

depts.scalaCollectionCompat

Test / compile := (Test / compile).dependsOn(Test / updateClassifiers).value
