package net.scalax.simple.adt.test

import net.scalax.simple.test.Tag

object `Test Cases copy from documention in README.md` {

  println("Test cases for doc started.")

  def `Common usage - compare with Scala sealed trait`[T](body: => T): T = body

  `Common usage - compare with Scala sealed trait` {
    {
      // sealed trait style
      import scala.util.Try

      sealed trait AdtData
      case class IntAdtData(intValue: Int)           extends AdtData
      case class StringAdtData(strValue: String)     extends AdtData
      case class DoubleAdtData(decimalValue: Double) extends AdtData

      def inputAdtDataSealedTrait(adtData: AdtData): Option[BigDecimal] = adtData match {
        case IntAdtData(intValue)       => Some(BigDecimal(intValue))
        case StringAdtData(strValue)    => Try(BigDecimal(strValue)).toOption
        case DoubleAdtData(doubleValue) => Some(BigDecimal(doubleValue))
      }

      assert(inputAdtDataSealedTrait(IntAdtData(2)).get == BigDecimal("2"))
      assert(inputAdtDataSealedTrait(StringAdtData("6")).get == BigDecimal("6"))
      assert(inputAdtDataSealedTrait(DoubleAdtData(2.3620)).get == BigDecimal("2.362"))
      assert(inputAdtDataSealedTrait(StringAdtData("error number")) == None)
    }

    {
      {
        // simple-adt common style
        import net.scalax.simple.adt.{TypeAdt => Adt}
        import scala.util.Try

        def inputAdtDataSimple[T: Adt.CoProducts3[*, Int, String, Double]](t: T): Option[BigDecimal] = {
          val applyM = Adt.CoProduct3[Int, String, Double](t)

          applyM.fold(
            intValue => Some(BigDecimal(intValue)),
            strValue => Try(BigDecimal(strValue)).toOption,
            doubleValue => Some(BigDecimal(doubleValue))
          )
        }

        assert(inputAdtDataSimple(2).get == BigDecimal("2"))
        assert(inputAdtDataSimple("6").get == BigDecimal("6"))
        assert(inputAdtDataSimple(2.3620).get == BigDecimal("2.362"))
        assert(inputAdtDataSimple("error number") == None)
      }

    }
  }
}
