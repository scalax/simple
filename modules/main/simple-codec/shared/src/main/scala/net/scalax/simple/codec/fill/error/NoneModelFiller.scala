package net.scalax.simple
package codec
package fill
package error

case class FillTestOnPrepare[F[_]](i1: F[String], i2: F[String], i3: F[String], i4: F[String])

case class ExceptionInfo(classInfo: Class[_ <: Throwable], message: Option[String])

object FillErrorCompat {

  val notNeedCompatMessageExceptionSet: Set[Class[_ <: Throwable]] = Set(classOf[IndexOutOfBoundsException])

  private def equalsItem(obj1: ExceptionInfo, obj2: ExceptionInfo): Boolean = {
    def confirm1 = obj1.classInfo eq obj2.classInfo
    def confirm2 = notNeedCompatMessageExceptionSet.contains(obj1.classInfo)
    if (confirm1 && confirm2) true else obj1 == obj2
  }

  private def equalsException(e1: Throwable, info2: List[ExceptionInfo]): Boolean =
    toInfo(e1).zip(info2).forall(u => equalsItem(u._1, u._2))

  private def equalsList(info1: List[ExceptionInfo], info2: List[ExceptionInfo]): Boolean =
    info1.zip(info2).forall(u => equalsItem(u._1, u._2))

  private def asssertExceptionEquals(t: Throwable): Boolean = equalsException(t, simpleException1)

  type UModel[F[_]] = FillTestOnPrepare[F]

  private val filler: Setter[UModel] = Setter.from

  private def toInfo(exception: Throwable): List[ExceptionInfo] = Option(exception) match {
    case None     => List.empty
    case Some(ex) => ExceptionInfo(ex.getClass, Option(ex.getMessage)) :: toInfo(ex.getCause)
  }

  private val simpleException1: List[ExceptionInfo] =
    try {
      filler.input[ContextI#NoneF](List.empty)
      null
    } catch {
      case t: Throwable => toInfo(t)
    }

  private val simpleException2: List[ExceptionInfo] =
    try {
      filler.input[ContextI#NoneF](List(Option.empty))
      null
    } catch {
      case t: Throwable => toInfo(t)
    }

  private val simpleException3: List[ExceptionInfo] =
    try {
      filler.input[ContextI#NoneF](List(Option.empty, Option.empty))
      null
    } catch {
      case t: Throwable => toInfo(t)
    }

  private val simpleException4: List[ExceptionInfo] =
    try {
      filler.input[ContextI#NoneF](List(Option.empty, Option.empty, Option.empty))
      null
    } catch {
      case t: Throwable => toInfo(t)
    }

  assert(equalsList(simpleException1, simpleException2))
  assert(equalsList(simpleException2, simpleException3))
  assert(equalsList(simpleException3, simpleException4))

  def fillerWithError[T](exec: => T): Either[Throwable, Option[T]] = try {
    Right(Some(exec))
  } catch {
    case t: Throwable if asssertExceptionEquals(t) => Right(Option.empty)
    case t: Throwable                              => Left(t)
  }

}
