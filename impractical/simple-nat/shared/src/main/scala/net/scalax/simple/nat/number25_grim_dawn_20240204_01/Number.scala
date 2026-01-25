package net.scalax.simple
package nat.number25_grim_dawn_20240204_01

// ====== 选项设置 ======

object GlobalContext {
  val 是否凯蒙神选: Boolean = true // true为凯蒙神选友好，false为死亡守夜人友好，假定一定加入了一个势力

  val 是否放逐者敌对: Boolean = false // true为放逐者敌对，false为放逐者友好

  val 是否使用放逐者的守护之力: Boolean = false // true为使用，false为不使用，如果放逐者敌对，则无论true或false都不使用

  val 是否使用灵魂向导粉末: Boolean =
    true // true为使用，false为不使用，如果死亡守夜人敌对，则不使用，请注意，如果巴罗霍尔姆敌对，灵魂向导粉末提供的12%活力抗性为单个附魔能提供的最高活力抗性

  val 是否巴罗霍尔姆敌对: Boolean = false // true为巴罗霍尔姆敌对，false为巴罗霍尔姆友好

  val 一共使用多少个抗性相关的附魔: Int = 7 // 7件护甲都附魔为最大值，若输入5件，则有两件附魔由玩家自行决定（一般指非抗性类附魔）

  val 人物抗性: 抗性 = 抗性( // 和最大抗性的差，例如最大抗性为87%，如果原始抗性是50%，则输入-37%，如果原始抗性是105%，则输入18%
    火焰抗性 = -21,
    冰冷抗性 = -46,
    闪电抗性 = -47,
    毒素抗性 = -11,
    穿刺抗性 = -15,
    流血抗性 = -48,
    活力抗性 = -22,
    虚化抗性 = -87,
    混乱抗性 = -57
  )
}

// ======
// ======
// ======
// === 计算开始 ===
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
import scala.annotation.tailrec

case class 抗性(
  火焰抗性: Int,
  冰冷抗性: Int,
  闪电抗性: Int,
  毒素抗性: Int,
  穿刺抗性: Int,
  流血抗性: Int,
  活力抗性: Int,
  虚化抗性: Int,
  混乱抗性: Int,
  enable: Boolean
)

object 抗性Collection {

  import GlobalContext._

  val 马尔茅斯: (String, Vector[(String, 抗性)]) = "马尔茅斯" -> Vector(
    "马尔茅斯的灵魂守护粉末" -> 抗性.default.copy(穿刺抗性 = 10, 虚化抗性 = 10),
    "马尔茅斯的灼伤粉末"   -> 抗性.default.copy(活力抗性 = 10, 流血抗性 = 10),
    "马尔茅斯的筑防粉末"   -> 抗性.default.copy(活力抗性 = 10)
  )

  val 索拉尔: (String, Vector[(String, 抗性)]) = "索拉尔" -> Vector(
    "索拉尔的缚血尘"  -> 抗性.zero,
    "索拉尔的缚魂尘"  -> 抗性.default.copy(穿刺抗性 = 10, 活力抗性 = 10),
    "索拉尔的虚空守护" -> 抗性.default.copy(混乱抗性 = 15)
  )

  val 拜斯迈: (String, Vector[(String, 抗性)]) = "拜斯迈" -> Vector(
    "拜斯迈的帷幕之触" -> 抗性.default.copy(毒素抗性 = 12, 虚化抗性 = 10),
    "拜斯迈的沙语"   -> 抗性.default.copy(穿刺抗性 = 15),
    "拜斯迈的银沙"   -> 抗性.zero
  )

  val 德里格: (String, Vector[(String, 抗性)]) = "德里格" -> Vector(
    "德里格的帷幕守护" -> 抗性.default.copy(虚化抗性 = 15),
    "德里格的恶魔血"  -> 抗性.default.copy(毒素抗性 = 12, 混乱抗性 = 10),
    "德里格的预知"   -> 抗性.zero
  )

  val 巴罗霍尔姆: (String, Vector[(String, 抗性)]) = "巴罗霍尔姆" -> Vector(
    "温迪戈的命息粉末" -> 抗性.zero,
    "温迪戈的血气粉末" -> 抗性.default.copy(流血抗性 = 15, enable = !是否巴罗霍尔姆敌对),
    "温迪戈的魂香粉末" -> 抗性.default.copy(活力抗性 = 15, enable = !是否巴罗霍尔姆敌对)
  )

  val 巫登沼泽女巫团: (String, Vector[(String, 抗性)]) = "巫登沼泽女巫团" -> Vector(
    "女巫团的守护粉末" -> 抗性.default.copy(火焰抗性 = 9, 冰冷抗性 = 9, 闪电抗性 = 9),
    "女巫团的血腥灰烬" -> 抗性.default.copy(流血抗性 = 10),
    "女巫团的黑色灰烬" -> 抗性.default.copy(混乱抗性 = 10, 穿刺抗性 = 10)
  )

  val 放逐者: (String, Vector[(String, 抗性)]) = "放逐者" -> Vector(
    "放逐者的元素平衡"   -> 抗性.default.copy(火焰抗性 = 12, 冰冷抗性 = 12, enable = !是否放逐者敌对),
    "放逐者的天空卫士粉末" -> 抗性.default.copy(冰冷抗性 = 12, 闪电抗性 = 12, enable = !是否放逐者敌对),
    "放逐者的守护之力"   -> 抗性.default.copy(虚化抗性 = 10, enable = 是否使用放逐者的守护之力 && !是否放逐者敌对)
  )

  val 恶魔十字: (String, Vector[(String, 抗性)]) = "恶魔十字" -> Vector(
    "刀锋护卫魔药"  -> 抗性.default.copy(穿刺抗性 = 12),
    "莫格卓根的触摸" -> 抗性.default.copy(毒素抗性 = 12, 活力抗性 = 9)
  )

  val 死亡守夜人教团: (String, Vector[(String, 抗性)]) = "死亡守夜人教团" ->
    Vector(
      "幽魂之触粉末"  -> 抗性.default.copy(冰冷抗性 = 18, enable = !是否凯蒙神选),
      "灵魂向导粉末"  -> 抗性.default.copy(活力抗性 = 12, enable = 是否使用灵魂向导粉末 && !是否凯蒙神选),
      "符咒守护者粉末" -> 抗性.default.copy(活力抗性 = 9, 虚化抗性 = 9, enable = !是否凯蒙神选)
    )

  val 黑色军团: (String, Vector[(String, 抗性)]) = "黑色军团" -> Vector(
    "人族的监视"  -> 抗性.default.copy(虚化抗性 = 9, 混乱抗性 = 9),
    "皇家护卫粉末" -> 抗性.default.copy(穿刺抗性 = 9, 毒素抗性 = 12)
  )

  val 霍姆斯特德: (String, Vector[(String, 抗性)]) = "霍姆斯特德" -> Vector(
    "日光风暴魔尘" -> 抗性.default.copy(火焰抗性 = 12, 闪电抗性 = 12),
    "火焰编织魔尘" -> 抗性.default.copy(穿刺抗性 = 9, 火焰抗性 = 12)
  )

  val 流浪者: (String, Vector[(String, 抗性)]) = "流浪者" -> Vector(
    "恶毒守卫粉末" -> 抗性.default.copy(毒素抗性 = 18),
    "暗夜之影粉末" -> 抗性.default.copy(穿刺抗性 = 9, 冰冷抗性 = 12)
  )

  val 凯蒙的神选者: (String, Vector[(String, 抗性)]) = "凯蒙的神选者" -> Vector(
    "凯蒙的引线"  -> 抗性.default.copy(闪电抗性 = 18, enable = 是否凯蒙神选),
    "凯蒙的祝福"  -> 抗性.default.copy(火焰抗性 = 18, enable = 是否凯蒙神选),
    "恶魔之祸魔尘" -> 抗性.default.copy(活力抗性 = 9, 混乱抗性 = 9, enable = 是否凯蒙神选)
  )

}

object 抗性 {
  def apply(
    元素抗性: Int = 0,
    火焰抗性: Int = 0,
    冰冷抗性: Int = 0,
    闪电抗性: Int = 0,
    毒素抗性: Int = 0,
    穿刺抗性: Int = 0,
    流血抗性: Int = 0,
    活力抗性: Int = 0,
    虚化抗性: Int = 0,
    混乱抗性: Int = 0
  ): 抗性 = 抗性(
    火焰抗性 = 元素抗性 + 火焰抗性,
    冰冷抗性 = 元素抗性 + 冰冷抗性,
    闪电抗性 = 元素抗性 + 闪电抗性,
    毒素抗性 = 毒素抗性,
    穿刺抗性 = 穿刺抗性,
    流血抗性 = 流血抗性,
    活力抗性 = 活力抗性,
    虚化抗性 = 虚化抗性,
    混乱抗性 = 混乱抗性,
    enable = true
  )

  def default: 抗性 = 抗性()
  def zero: 抗性    = default.copy(enable = false)
}

object utils {

  def merge(ks1: 抗性, ks2: 抗性): 抗性 = 抗性(
    火焰抗性 = ks1.火焰抗性 + ks2.火焰抗性,
    冰冷抗性 = ks1.冰冷抗性 + ks2.冰冷抗性,
    闪电抗性 = ks1.闪电抗性 + ks2.闪电抗性,
    毒素抗性 = ks1.毒素抗性 + ks2.毒素抗性,
    穿刺抗性 = ks1.穿刺抗性 + ks2.穿刺抗性,
    流血抗性 = ks1.流血抗性 + ks2.流血抗性,
    活力抗性 = ks1.活力抗性 + ks2.活力抗性,
    虚化抗性 = ks1.虚化抗性 + ks2.虚化抗性,
    混乱抗性 = ks1.混乱抗性 + ks2.混乱抗性
  )

  val mapSum: Vector[(String, Vector[(String, 抗性)])] =
    Vector(
      抗性Collection.马尔茅斯,
      抗性Collection.索拉尔,
      抗性Collection.拜斯迈,
      抗性Collection.德里格,
      抗性Collection.巴罗霍尔姆,
      抗性Collection.巫登沼泽女巫团,
      抗性Collection.放逐者,
      抗性Collection.恶魔十字,
      抗性Collection.死亡守夜人教团,
      抗性Collection.黑色军团,
      抗性Collection.霍姆斯特德,
      抗性Collection.流浪者,
      抗性Collection.凯蒙的神选者
    )

  val fumoSum: Vector[(String, 抗性)] = for {
    a <- mapSum
    b <- a._2
  } yield b

  @tailrec
  def count(
    fumo_sum: Vector[(String, 抗性)],
    base: 抗性,
    fumo_list: Vector[(String, 抗性)],
    index: Long,
    sumCount: Long,
    result: Vector[(抗性, Vector[(String, 抗性)])]
  ): Vector[(抗性, Vector[(String, 抗性)])] = {
    val co: Vector[(抗性, Vector[(String, 抗性)], Double)] =
      for (item <- fumo_sum)
        yield {
          val newList                     = fumo_list.updated((index % fumo_list.size).toInt, item)
          val result: 抗性                  = newList.foldLeft(base)((a, b) => merge(b._2, a))
          val stat: DescriptiveStatistics = new DescriptiveStatistics
          stat.addValue(result.火焰抗性)
          stat.addValue(result.冰冷抗性)
          stat.addValue(result.闪电抗性)
          stat.addValue(result.毒素抗性)
          stat.addValue(result.穿刺抗性)
          stat.addValue(result.流血抗性)
          stat.addValue(result.活力抗性)
          stat.addValue(result.虚化抗性)
          stat.addValue(result.混乱抗性)
          val fc: Double = stat.getStandardDeviation
          (result, newList, fc)
        }

    val (r1, newList: Vector[(String, 抗性)], fangcha) = co.minBy(_._3)

    if (sumCount < 2000) {
      count(
        fumo_sum = fumo_sum,
        base = base,
        fumo_list = newList,
        index = index + 1,
        sumCount = sumCount + 1,
        result = result
      )
    } else if (sumCount < 2200) {
      count(
        fumo_sum = fumo_sum,
        base = base,
        fumo_list = newList,
        index = index + 1,
        sumCount = sumCount + 1,
        result = (r1 -> fumo_list) +: result
      )
    } else result
  }

}
