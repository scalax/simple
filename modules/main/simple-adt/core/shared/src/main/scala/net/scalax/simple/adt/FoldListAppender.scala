package net.scalax.simple.adt

import CoreInstance._

object FoldListAppender {
  @inline def append(data: Any, func: Any => Any): Core2 = Core2(tail =>
    new Core2 with TypeAdtGetter {
      override def runGetter: Any                   = func(data)
      override def apply(other: () => Core2): Core2 = FoldListPositive(tail)(other)
    }
  )
}
