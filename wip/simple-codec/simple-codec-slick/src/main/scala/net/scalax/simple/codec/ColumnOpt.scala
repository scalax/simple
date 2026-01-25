package net.scalax.simple.codec

import slick.ast.{ColumnOption, TypedType}

trait ColumnOpt[T] extends (ColumnOpt.Opt[T] => ColumnOpt.ColumnOptAbs[T]) with ColumnOpt.ColumnOptAbs[T] {
  ColumnOptSelf =>

  override def name: Option[String]       = ColumnOptSelf.apply(ColumnOpt.Opt.value).name
  override def opts: Seq[ColumnOption[T]] = ColumnOptSelf.apply(ColumnOpt.Opt.value).opts

  override def apply(opt: ColumnOpt.Opt[T]): ColumnOpt.ColumnOptAbs[T]
}

object ColumnOpt {
  ColumnOptSelf =>

  def default[T]: ColumnOpt[T] = _.column()

  trait ColumnOptAbs[TR] {
    ColumnOptAbsSelf =>
    def name: Option[String]
    def opts: Seq[ColumnOption[TR]]
    def typedType: Option[TypedType[TR]] = Option.empty
    def withTypedType(implicit tt: TypedType[TR]): ColumnOptAbs[TR] = new ColumnOptAbs[TR] {
      override def name: Option[String]             = ColumnOptAbsSelf.name
      override def opts: Seq[ColumnOption[TR]]      = ColumnOptAbsSelf.opts
      override def typedType: Option[TypedType[TR]] = Option(tt)
    }
  }

  trait Opt[T] {
    def rawColumn(name: Option[String], opts: ColumnOption[T]*): ColumnOpt.ColumnOptAbs[T] = {
      val name1 = name
      val opts1 = opts
      new ColumnOpt.ColumnOptAbs[T] {
        override def name: Option[String]       = name1
        override def opts: Seq[ColumnOption[T]] = opts1
      }
    }

    def column(name: String, opts: ColumnOption[T]*): ColumnOpt.ColumnOptAbs[T] = rawColumn(Some(name), opts: _*)
    def column(opts: ColumnOption[T]*): ColumnOpt.ColumnOptAbs[T]               = rawColumn(None, opts: _*)
  }

  object Opt {
    def value[T]: ColumnOptSelf.Opt[T] = new ColumnOptSelf.Opt[T] {
      //
    }
  }

}
