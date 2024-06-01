package net.scalax.simple.nat
package 基础结构

// 基础结构，第一版
object 基础结构 {

  trait 本族人 {
    def tail1: 本族人
    def tail2: 外族人
  }

  trait 外族人 {
    def tail1: 本族人
    def tail2: 外族人
  }

  case class 本族人Impl(override val tail1: 本族人, override val tail2: 外族人) extends 本族人
  case class 外族人Impl(override val tail1: 本族人, override val tail2: 外族人) extends 外族人

  case object 本族人Zero extends 本族人 {
    override lazy val tail1: 本族人 = 本族人Zero
    override lazy val tail2: 外族人 = 外族人Zero
  }
  case object 外族人Zero extends 外族人 {
    override lazy val tail1: 本族人 = 本族人Zero
    override lazy val tail2: 外族人 = 外族人Zero
  }

}

// 简化结构，第二版
object 简化结构 {

  case class 本族人(本: () => 本族人, 外: () => 外族人)
  case class 外族人(本: () => 本族人, 外: () => 外族人)

  lazy val ZeroSelf: 本族人  = 本族人(本 = () => ZeroSelf, 外 = () => ZeroOther)
  lazy val ZeroOther: 外族人 = 外族人(本 = () => ZeroSelf, 外 = () => ZeroOther)

}

// 带数据的结构，第三版
object 带数据的结构 {

  case class 本族人(本: () => 本族人, 外: () => 外族人, info: String)
  case class 外族人(本: () => 本族人, 外: () => 外族人, info: String)

  lazy val ZeroSelf: 本族人 =
    本族人(本 = () => ZeroSelf, 外 = () => ZeroOther, info = "奈伊，zhen zhen奈伊")
  lazy val ZeroOther: 外族人 =
    外族人(本 = () => ZeroSelf, 外 = () => ZeroOther, info = "奈伊，zhen zhen奈伊")

  // 当前例子讨论范围外
  def 不讨论: Nothing = ???

}

object Demo {

  // 例子1：老公有一个老婆
  locally {

    import 带数据的结构._

    val 老婆1: 外族人 = 外族人(本 = () => 不讨论, 外 = () => ZeroOther, info = "老婆1的身份证号")
    val 老公1: 本族人 = 本族人(本 = () => 不讨论, 外 = () => 老婆1, info = "老公1的身份证号")

  }

  // 例子2：老公有两个老婆（在第一个老婆离婚后，又娶了第二个）
  locally {

    import 带数据的结构._

    val 前妻1: 外族人   = 外族人(本 = () => 不讨论, 外 = () => ZeroOther, info = "前妻1的身份证号")
    val 当前老婆2: 外族人 = 外族人(本 = () => 不讨论, 外 = () => 前妻1, info = "当前老婆2的身份证号")
    val 老公1: 本族人   = 本族人(本 = () => 不讨论, 外 = () => 当前老婆2, info = "老公1的身份证号")

  }

  // 例子3：老公视觉，老公有1个老婆，老婆有1个儿子，未嫁娶
  locally {

    import 带数据的结构._

    val 父母儿子1: 本族人 =
      本族人(本 = () => ZeroSelf, 外 = () => ZeroOther, info = "父母儿子1的身份证号")
    val 老婆1: 外族人 = 外族人(本 = () => 父母儿子1, 外 = () => ZeroOther, info = "老婆1的身份证号")
    val 老公1: 本族人 = 本族人(本 = () => 不讨论, 外 = () => 老婆1, info = "老公1的身份证号")

  }

  // 例子4：老公母亲有2个儿子，都已经娶了1个老婆，不讨论两个儿子的子女
  locally {

    import 带数据的结构._

    val 儿子1的老婆1: 外族人 =
      外族人(本 = () => 不讨论, 外 = () => ZeroOther, info = "儿子1的老婆1的身份证号")
    val 儿子1: 本族人 = 本族人(本 = () => ZeroSelf, 外 = () => 儿子1的老婆1, info = "儿子1的身份证号")

    val 儿子2的老婆1: 外族人 =
      外族人(本 = () => 不讨论, 外 = () => ZeroOther, info = "儿子2的老婆1的身份证号")
    val 儿子2: 本族人 = 本族人(本 = () => 儿子1, 外 = () => 儿子2的老婆1, info = "儿子2的身份证号")

    val 老婆1: 外族人 = 外族人(本 = () => 儿子2, 外 = () => ZeroOther, info = "老婆1的身份证号")
    val 老公1: 本族人 = 本族人(本 = () => 不讨论, 外 = () => 老婆1, info = "老公1的身份证号")

  }

  // 例子5：两兄弟，都有一个老婆，不考虑两兄弟的子女
  locally {

    import 带数据的结构._

    val 兄长1的老婆1: 外族人 =
      外族人(本 = () => 不讨论, 外 = () => ZeroOther, info = "兄长1的老婆1的身份证号")
    val 兄长1: 本族人 = 本族人(本 = () => ZeroSelf, 外 = () => 兄长1的老婆1, info = "兄长1的身份证号")

    val 弟弟1的老婆1: 外族人 =
      外族人(本 = () => 不讨论, 外 = () => ZeroOther, info = "弟弟1的老婆1的身份证号")
    val 弟弟1: 本族人 = 本族人(本 = () => 兄长1, 外 = () => 弟弟1的老婆1, info = "弟弟1的身份证号")

  }

  // 例子6：母亲3个子女，大儿子夭折，二儿子一个老婆,二儿子不讨论子女状况，三女儿已外嫁，4女儿年幼
  locally {

    import 带数据的结构._

    val 大儿子1: 本族人 =
      本族人(本 = () => ZeroSelf, 外 = () => ZeroOther, info = "大儿子1的身份证号")

    val 二儿子1老婆1: 外族人 =
      外族人(本 = () => 不讨论, 外 = () => ZeroOther, info = "二儿子1老婆1的身份证号")
    val 二儿子1: 本族人 = 本族人(本 = () => 大儿子1, 外 = () => 二儿子1老婆1, info = "二儿子1的身份证号")

    val 三女儿1: 本族人 = 本族人(本 = () => 二儿子1, 外 = () => ZeroOther, info = "三女儿1的身份证号")
    val 四女儿1: 本族人 = 本族人(本 = () => 三女儿1, 外 = () => ZeroOther, info = "四女儿1的身份证号")

  }

}
