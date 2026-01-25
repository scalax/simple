package net.scalax.simple.nat
package number25_grim_dawn_20240204_01

object RunTest1 {

  import GlobalContext._

  def main1(arr: Array[String]): Unit = locally {

    val resultPre = utils.count(
      fumo_sum = utils.fumoSum,
      base = 人物抗性,
      fumo_list = Vector.fill(一共使用多少个抗性相关的附魔)(utils.fumoSum(0)),
      index = 2342,
      sumCount = 0,
      result = Vector.empty
    )

    val result: Vector[(抗性, Vector[(String, 抗性)])] = resultPre.to(Set).to(Vector)

    println("=== 附魔方案 Printing... ===")
    println(' '.toString)

    for {
      eachR1 <- result.zipWithIndex
      ((kangxing, fumo), index) = eachR1
    } yield {
      println(s"===第${index + 1}条，共${result.size}条===")

      println(s"标的附魔：${(for (x <- fumo) yield x._1).mkString(','.toString)}")

      println(s"附魔后的效果：$kangxing")
    }

    println(' '.toString)
    println("=== 输出结束，如果不止1个附魔方案，则这几个附魔方案等价 ===")

  }

}
