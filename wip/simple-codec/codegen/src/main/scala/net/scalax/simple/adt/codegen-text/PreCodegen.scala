package net.scalax.simple.codec.codegen
package text

import org.apache.commons.io.FileUtils

import java.nio.file.Paths

object PreCodegen:

  def repeat(times: Int)(text: Int => String): List[String] = {
    val listString = for (i <- 1 to times) yield text(i)
    listString.to(List)
  }

  def repeat_s(times: Int)(text: Int => String)(t: String): String = repeat(times)(text).mkString(t)

  def repeat_t(times: Int)(text: Int => String): String = repeat(times)(text).mkString

  def repeat_dot(times: Int)(text: Int => String): String = repeat_s(times)(text)(','.toString)

  def fromMIMpl(times: Int)(max: Int): String = if (times <= max)
    s"""trait DataHListImpl${times} extends DataHList {
      ${fromMIMpl(times + 1)(max)}
      override type DataType = X${times + 1}
      ${if (times > 1) s"override type DataTail = DataHListImpl${times + 1}" else ""}
    }"""
  else
    s"type DataHListImpl${times} = DataHListZero"

  def fromM(times: Int): String =
    s"""trait MFrom[${repeat_dot(times)(t1 => s"X$t1")}] extends DataHList {
        ${fromMIMpl(1)(times - 1)}
        override type DataType = X1
        override type DataTail = DataHListImpl1
      }""".stripMargin

  def text2: String = s"""
    trait MFrom1[I1] extends DataHList {
      override type DataType = I1
      override type DataTail = DataHListZero
    }

    ${repeat_t(21) { x1 =>
      val i = x1 + 1
      s"""
    trait MFrom$i[${repeat_dot(i)(t1 => s"I${t1}")}] extends DataHList {
      override type DataType = I1
      override type DataTail = MFrom${i - 1}[${repeat_dot(i - 1)(t1 => s"I${t1 + 1}")}]
    }
    """
    }}
  """

  def mapInstance(times: Int)(max: Int)(start1: String, start2: String): String =
    if (times <= max)
      s"new DFuncTypeImpl[$start1, $start2](ia$times, ib$times, ${mapInstance(times + 1)(max)(start1 + "#DataTail", start2 + "#DataTail")})"
    else "DFuncTypeZero"

  def text1_not_use: String =
    s"""
      package net.scalax.simple.codec

      import decode.projection._

      object TypeContext {
        $text2
      }

       ${repeat_t(22)(i =>
        s"""trait Monad${i}TypeLevel[M1[${repeat_dot(i)(_ => '_'.toString)}]] {

         def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

         type MSelfFrom[TX <: DataHList] = M1[${repeat_dot(i)(t1 => s"TX${repeat_t(t1 - 1)(_ => "#DataTail")}#DataType")}]

         def zip[
           ${repeat_dot(i)(i => "IA" + i)}
           ,
           ${repeat_dot(i)(i => "IB" + i)}
         ](
           m1: M1[${repeat_dot(i)(i => "IA" + i)}],
           m2: M1[${repeat_dot(i)(i => "IB" + i)}]
         ): M1[${repeat_dot(i)(i => s"(IA$i, IB$i)")}] = mImpl[MSelfFrom].zip[TypeContext.MFrom$i[${repeat_dot(i)(i =>
            "IA" + i
          )}], TypeContext.MFrom$i[${repeat_dot(
            i
          )(i => "IB" + i)}]](m1, m2)

         def map[
           ${repeat_dot(i)(i => s"IA$i")}
           ,
           ${repeat_dot(i)(i => s"IB$i")}
         ](
           ${repeat_dot(i)(i => s"ia$i: IA$i => IB$i")}
         )(
           ${repeat_dot(i)(i => s"ib$i: IB$i => IA$i")}
         ): M1[${repeat_dot(i)(i => s"IA$i")}]
           =>
         M1[${repeat_dot(i)(i => s"IB$i")}] = mImpl[MSelfFrom]
         .map[
           TypeContext.MFrom$i[${repeat_dot(i)(i => s"IA$i")}]
           ,
           TypeContext.MFrom$i[${repeat_dot(i)(i => s"IB$i")}]
         ](${mapInstance(1)(i)(
            s"TypeContext.MFrom$i[${repeat_dot(i)(i => s"IA$i")}]",
            s"TypeContext.MFrom$i[${repeat_dot(i)(i => s"IB$i")}]"
          )})

        def zero: M1[${repeat_dot(i)(_ => "Unit")}] = map(${repeat_dot(i)(_ => "(_: ZeroInstance) => (): Unit")})(${repeat_dot(i)(_ =>
            "(_: Unit) => ZeroInstance.instance"
          )})(mImpl[MSelfFrom].zero)

      }
    """
      )}
       """

end PreCodegen
