package net.scalax.simple
package adt

import implemention.AdtNumber
import net.scalax.simple.ghdmzsk.ghdmzsk

object FoldListAppender {
  def appendAll(list: List[Any => Any]): VarSetting[TypeAdtGetter] => ghdmzsk = { getterBinding =>
    def appendAllInnerList(innerList: List[Any => Any]): ghdmzsk = innerList match {
      case head :: hTail =>
        val tailNext = appendAllInnerList(hTail)
        AdtNumber.NumberB.setPositive(() => getterBinding.value = TypeAdtGetter(head))(() => tailNext)
      case Nil => AdtNumber.NumberB.Zero
    }
    appendAllInnerList(list)
  }

  def result[T](
    foldList: VarSetting[TypeAdtGetter] => ghdmzsk,
    adtList: VarSetting[TypeAdt.Context[Any, Any, Any]] => ghdmzsk,
    data: Any
  ): T = {
    val adtContextVar: VarSetting[TypeAdt.Context[Any, Any, Any]] = VarSetting.init
    val typeGetterVar: VarSetting[TypeAdtGetter]                  = VarSetting.init

    val adtNumber  = adtList(adtContextVar)
    val foldNumber = foldList(typeGetterVar)

    foldNumber(() => adtNumber)

    val convert: TypeAdt.Context[Any, Any, Any] = adtContextVar.value
    val getter: TypeAdtGetter                   = typeGetterVar.value

    getter.executeFunction(convert.input(data)).asInstanceOf[T]
  }

}
