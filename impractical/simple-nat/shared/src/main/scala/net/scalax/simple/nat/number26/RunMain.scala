package net.scalax.simple
package nat
package number26

object RunTest1 {

  def main1(arr: Array[String]): Unit = {
    val 人物抗性: 抗性 = 抗性(火焰抗性 = -21, 冰冷抗性 = -46, 闪电抗性 = -47, 毒素抗性 = -11, 穿刺抗性 = -15, 流血抗性 = -48, 活力抗性 = -22, 虚化抗性 = -87, 混乱抗性 = -57)

    val (result, list) = utils.count(
      fumo_sum = utils.马尔茅斯._2 ++: utils.索拉尔._2 ++: utils.拜斯迈._2 ++: utils.德里格._2,
      base = 人物抗性,
      fumo_list = Vector.fill(7)(("hahjahahah", 抗性.zero)),
      index = 2342,
      sumCount = 0
    )

    println(s"标的附魔：${(for x <- list yield x._1).mkString(','.toString)}")
    println(s"附魔后效果：$result")
  }

}
