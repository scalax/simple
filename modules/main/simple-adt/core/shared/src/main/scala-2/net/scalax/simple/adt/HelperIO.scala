package net.scalax.simple.adt

import net.scalax.simple.adt.core.AdtList

/** TODO
  *
  * @author
  *   djx314
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
abstract class HelperIO[Input] {
  type Out
  def helper(adtGetter: TypeAdtGetter, typeAdt: TypeAdt[Any, Any], data: Any): Out
}

object HelperIO extends impl.HelperIOImplicit {
  type Aux[I, O] = HelperIO[I] { type Out = O }
}
