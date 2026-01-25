package nat.scalax.simple.append.Codegen
package v1

class TypeArgCodegen(index: Int) {
  TypeArgCodegenSelf =>

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  val EmptyArg: Seq[String]                 = for i1 <- 1 to TypeArgCodegenSelf.index yield s"_ <: Col$i1"
  val CollectionDef: Seq[String]            = for i1 <- 1 to TypeArgCodegenSelf.index yield s"Col$i1"
  def MWithArg(strSeq: Seq[String]): String = if (TypeArgCodegenSelf.index == 0) "M0" else s"M$index[${strSeq.mkString(',')}]"
  val MName: String                         = s"M$index"

  class ColCountCodegen(index: Int) {
    ColCountCodegenSelf =>
    val TName: Seq[String]      = for i1 <- 1 to ColCountCodegenSelf.index yield s"T$i1"
    val EmptyTName: Seq[String] = for _ <- 1 to ColCountCodegenSelf.index yield '_'.toString

    val CollectionAppendDef: Seq[String] = if (ColCountCodegenSelf.index == 0) {
      for i1 <- 1 to TypeArgCodegenSelf.index yield s"App$i1[_ <: Col$i1] <: Col$i1"
    } else {
      for i1 <- 1 to TypeArgCodegenSelf.index yield s"App$i1[${EmptyTName.mkString(',')}, _ <: Col$i1] <: Col$i1"
    }

    val InsDef: Seq[String]               = for i1 <- 1 to TypeArgCodegenSelf.index yield s"ColIns$i1 <: Col$i1"
    val InsName: Seq[String]              = for i1 <- 1 to TypeArgCodegenSelf.index yield s"ColIns$i1"
    val CollectionAppendName: Seq[String] = for i1 <- 1 to TypeArgCodegenSelf.index yield s"App$i1"
    val NextName: Seq[String] = if (ColCountCodegenSelf.index == 0) {
      for i1 <- 1 to TypeArgCodegenSelf.index yield s"App$i1[ColIns$i1]"
    } else {
      for i1 <- 1 to TypeArgCodegenSelf.index yield s"App$i1[${TName.mkString(',')}, ColIns$i1]"
    }

    val nextParam: String = if (ColCountCodegenSelf.index == 0) {
      ""
    } else {
      s"[${TName.mkString(',')}]"
    }

    val text: String = s"""
      package nat.scalax.simple.append.support
      package collectioncount${TypeArgCodegenSelf.index}
      package typeparameter${ColCountCodegenSelf.index}

      trait SimpleAppender[
        ${(MWithArg(EmptyArg) +:
        CollectionDef ++:
        CollectionAppendDef ++:
        InsDef).mkString(",")}
      ] {
        def current: ${MWithArg(InsName)}
        def next$nextParam: SimpleAppender[
          ${(MName +:
        CollectionDef ++:
        CollectionAppendName ++:
        NextName).mkString(',')}
        ]
      }
    """

  }

}
