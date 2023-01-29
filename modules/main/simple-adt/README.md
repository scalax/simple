# simple-adt

## Usage of @djx314
Match type by `TypeOptionsX`(The type will be match first if it's declaring first).
``` scala
def inputOptData[T: TypeOptions3[*, None.type, Some[Int], Option[Int]]](t: T): TempForData = {
  type Tpe[T] = TypeOptions3[T, None.type, Some[Int], Option[Int]]
  val applyM                       = getAdtApply[Tpe]
  applyM.input(t).fold(n => TempForData("None", n), n => TempForData("Some", Some(n.get + 1)), n => TempForData("Option", n.map(_ + 2)))
}

assert(inputOptDat(None) == TempForData("None", None))
assert(inputOptDat(Option(2)) == TempForData("Option", Some(4)))
assert(inputOptDat(Some(6)) == TempForData("Some", Some(7)))
```

## Usage of @MarchLiu
Match type for parameter list.
``` scala
type TypeOpt[T] = TypeOptions3[Seq[T], Seq[String], Seq[Int], Seq[Option[Long]]]
def inputOptData[T: TypeOpt](t: T*): Seq[Option[Long]] = {
  type Tpe[T] = TypeOptions3[T, Seq[String], Seq[Int], Seq[Option[Long]]]
  val applyM = getAdtApply[Tpe]
  applyM
    .input(t)
    .fold(
      t1 => t1.map(t => Some(t.length.toLong)),
      t2 => t2.map(t => Some(t.toLong)),
      t3 => t3
    )
}

assert(inputOptData("abc", "aabbcc", "aabbbcc") == List("abc", "aabbcc", "aabbbcc").map(t => Some(t.length.toLong)))
```