package net.scalax.simple.codec
package to_list_generic

import shapeless.::

trait PojoInstance[U[_], Model] {
  PojoInstanceSelf =>

  def instance: Any

  def forCopy(implicit
    basedInstalledInput: BasedInstalledSimpleProduct[({ type F1[T[_]] = PojoInstance[T, Model] })#F1],
    basedLabelledInput: BasedInstalledLabelled[({ type F1[T[_]] = PojoInstance[T, Model] })#F1]
  ): PojoInstance.CopyAble[U, Model] = new PojoInstance.CopyAble[U, Model] {
    override def value: PojoInstance[U, Model]                                                                   = PojoInstanceSelf
    override def basedInstalled: BasedInstalledSimpleProduct[({ type F1[T[_]] = PojoInstance[T, Model] })#F1]    = basedInstalledInput
    override def basedInstalledLabelled: BasedInstalledLabelled[({ type F1[T[_]] = PojoInstance[T, Model] })#F1] = basedLabelledInput
  }

  def copyImpl[T](proName: String, func: Model => T)(data: U[T])(implicit
    basedInstalledInput: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1],
    basedLabelledInput: BasedInstalledLabelled[({ type F1[X[_]] = PojoInstance[X, Model] })#F1]
  ): PojoInstance[U, Model] = forCopy(basedInstalledInput, basedLabelledInput).copySelfImpl(proName = proName, func = func)(data).value

  def applyImpl[T](proName: String, func: Model => T)(implicit
    basedInstalledInput: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1],
    basedLabelledInput: BasedInstalledLabelled[({ type F1[X[_]] = PojoInstance[X, Model] })#F1]
  ): U[T] = forCopy(basedInstalledInput, basedLabelledInput).getSelfImpl3(proName = proName, func = func)

  import scala.language.experimental.macros
  def copy[MP](expr: Model => MP)(data: U[MP])(implicit
    bInstall: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1],
    lInstall: BasedInstalledLabelled[({ type F1[X[_]] = PojoInstance[X, Model] })#F1]
  ): PojoInstance[U, Model] = macro macrosImpl.NameOfImpl.nameOf[Model, MP, U]
  def apply[MP](expr: Model => MP)(implicit
    bInstall: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1],
    lInstall: BasedInstalledLabelled[({ type F1[X[_]] = PojoInstance[X, Model] })#F1]
  ): U[MP] = macro macrosImpl.NameOfImpl.nameOf2222[Model, MP, U]
  def get[MP](expr: Model => MP)(implicit
    bInstall: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1],
    lInstall: BasedInstalledLabelled[({ type F1[X[_]] = PojoInstance[X, Model] })#F1]
  ): U[MP] = macro macrosImpl.NameOfImpl.nameOf2222[Model, MP, U]

}

object PojoInstance {

  private trait ReplaceImpl[Model] {
    def re[T[_]](r: PojoInstance[T, Model]): PojoInstance[T, Model]
  }

  private def copyImpl1[Model](proName: String, data: Any)(
    basedInstalled: BasedInstalledSimpleProduct[({ type F1[T[_]] = PojoInstance[T, Model] })#F1],
    labelled: BasedInstalledLabelled[({ type F1[T[_]] = PojoInstance[T, Model] })#F1]
  ): ReplaceImpl[Model] = {
    val replaceByPropertyName: ReplaceByPropertyName[({ type F1[T[_]] = PojoInstance[T, Model] })#F1] =
      ReplaceByPropertyName[({ type F1[T[_]] = PojoInstance[T, Model] })#F1].derived(basedInstalled, labelled)
    new ReplaceImpl[Model] {
      override def re[T[_]](r: PojoInstance[T, Model]): PojoInstance[T, Model] = replaceByPropertyName.replace[T](proName, data)(r)
    }
  }

  private def copyImpl2[Model, MP, XX1[_]](
    proName: String,
    func: Model => MP
  )(data: XX1[MP])(
    basedInstalled: BasedInstalledSimpleProduct[({ type F1[T[_]] = PojoInstance[T, Model] })#F1],
    labelled: BasedInstalledLabelled[({ type F1[T[_]] = PojoInstance[T, Model] })#F1]
  ): ReplaceImpl[Model] =
    copyImpl1(proName, data)(basedInstalled, labelled)

  trait CopyAble[U[_], Model] {
    CopyAbleSelf =>
    def value: PojoInstance[U, Model]
    def basedInstalled: BasedInstalledSimpleProduct[({ type F1[T[_]] = PojoInstance[T, Model] })#F1]
    def basedInstalledLabelled: BasedInstalledLabelled[({ type F1[T[_]] = PojoInstance[T, Model] })#F1]
    private def copyImpl3[MP](proName: String, func: Model => MP)(data: U[MP]): PojoInstance[U, Model] =
      copyImpl2[Model, MP, U](proName, func)(data)(basedInstalled, basedInstalledLabelled).re(value)
    def copySelfImpl[MP](proName: String, func: Model => MP)(data: U[MP]): CopyAble[U, Model] = new CopyAble[U, Model] {
      override def value: PojoInstance[U, Model] = CopyAbleSelf.copyImpl3(proName = proName, func = func)(data)
      override def basedInstalled: BasedInstalledSimpleProduct[({ type F1[T[_]] = PojoInstance[T, Model] })#F1] =
        CopyAbleSelf.basedInstalled
      override def basedInstalledLabelled: BasedInstalledLabelled[({ type F1[T[_]] = PojoInstance[T, Model] })#F1] =
        CopyAbleSelf.basedInstalledLabelled
    }

    private val getPropertyByPropertyName: GetPropertyByPropertyName[({ type F1[T[_]] = PojoInstance[T, Model] })#F1] =
      GetPropertyByPropertyName[({ type F1[T[_]] = PojoInstance[T, Model] })#F1].derived(basedInstalled, basedInstalledLabelled)

    def getSelfImpl3[MP](proName: String, func: Model => MP): U[MP] = getPropertyByPropertyName.getProperty[U, MP](proName)(value)
  }

  implicit def hlistAppendFetch[U[_], T, Tail <: shapeless.HList](implicit
    h: U[T],
    tailInstance: PojoInstance[U, Tail]
  ): PojoInstance[U, T :: Tail] = new PojoInstance[U, T :: Tail] {
    override def instance: Any = h :: tailInstance.instance.asInstanceOf[shapeless.HList]
  }
  implicit def hlistZeroFetch[U[_]]: PojoInstance[U, shapeless.HNil] = new PojoInstance[U, shapeless.HNil] {
    override val instance: Any = shapeless.HNil
  }

  /*def derived[Model, E[_], H <: shapeless.HList](implicit
    x: shapeless.Generic.Aux[Model, H],
    n: PojoInstance[E, H]
  ): PojoInstance[E, Model] = n.asInstanceOf[PojoInstance[E, Model]]*/

  /*trait Builder[E[_], Model] {
    def derived[H <: shapeless.HList](implicit
      x: shapeless.Generic.Aux[Model, H],
      n: PojoInstance[E, H]
    ): PojoInstance[E, Model] = n.asInstanceOf[PojoInstance[E, Model]]
  }

  def apply[E[_], Model]: Builder[E, Model] = new Builder[E, Model] {
    //
  }*/

}

package macrosImpl {
  import scala.language.experimental.macros
  import scala.reflect.macros.whitebox
  import scala.reflect.macros.blackbox
  import scala.annotation.tailrec

  object NameOfImpl {
    def nameOf[M, T, U[_]](
      c: blackbox.Context
    )(
      expr: c.Expr[M => T]
    )(
      data: c.Expr[U[T]]
    )(
      bInstall: c.Expr[BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, M] })#F1]],
      lInstall: c.Expr[BasedInstalledLabelled[({ type F1[XX[_]] = PojoInstance[XX, M] })#F1]]
    )(implicit w1: c.WeakTypeTag[M], w2: c.WeakTypeTag[T], w3: c.WeakTypeTag[U[_]]): c.Expr[PojoInstance[U, M]] = {
      import c.universe._

      @tailrec def extract(tree: c.Tree): String = tree match {
        case Ident(n)           => n.decodedName.toString
        case Select(_, n)       => n.decodedName.toString
        case Function(_, body)  => extract(body)
        case Block(_, expr)     => extract(expr)
        case Apply(func, _)     => extract(func)
        case TypeApply(func, _) => extract(func)
        case _ =>
          c.abort(c.enclosingPosition, s"Unsupported expression: ${expr.tree}")
      }

      /** Compile-time constants have already been replaced before this macro runs. For example, when calling `nameOf(Byte.MaxValue)`, the
        * macro will see `nameOf(127)`. We use the compiler APIs to solve this problem.
        */
      def nameOfConstant(): String = {
        val cc = c.asInstanceOf[reflect.macros.runtime.Context]
        import cc.universe._
        val macroName = cc.macroApplication.symbol.asTerm.name

        @tailrec def extractConstant(tree: cc.Tree): cc.Name = tree match {
          case Apply(RefTree(_, `macroName`), List(RefTree(_, name))) => name
          case Apply(func, _)                                         => extractConstant(func)
          case Select(qualifier, _)                                   => extractConstant(qualifier)
          case _ =>
            c.abort(c.enclosingPosition, s"Unsupported constant expression: ${expr.tree}")
        }

        extractConstant(cc.callsiteTyper.context.tree).decodedName.toString
      }

      val name = expr.tree match {
        case Literal(Constant(_)) => nameOfConstant()
        case _                    => extract(expr.tree)
      }

      c.Expr[PojoInstance[U, M]](
        q"${c.prefix}.copyImpl($name, $expr)($data)($bInstall, $lInstall)"
      )
    }

    def nameOf2222[M, T, U[_]](
      c: blackbox.Context
    )(
      expr: c.Expr[M => T]
    )(
      bInstall: c.Expr[BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, M] })#F1]],
      lInstall: c.Expr[BasedInstalledLabelled[({ type F1[XX[_]] = PojoInstance[XX, M] })#F1]]
    )(implicit w1: c.WeakTypeTag[M], w2: c.WeakTypeTag[T], w3: c.WeakTypeTag[U[_]]): c.Expr[U[T]] = {
      import c.universe._

      @tailrec def extract(tree: c.Tree): String = tree match {
        case Ident(n)           => n.decodedName.toString
        case Select(_, n)       => n.decodedName.toString
        case Function(_, body)  => extract(body)
        case Block(_, expr)     => extract(expr)
        case Apply(func, _)     => extract(func)
        case TypeApply(func, _) => extract(func)
        case _ =>
          c.abort(c.enclosingPosition, s"Unsupported expression: ${expr.tree}")
      }

      /** Compile-time constants have already been replaced before this macro runs. For example, when calling `nameOf(Byte.MaxValue)`, the
        * macro will see `nameOf(127)`. We use the compiler APIs to solve this problem.
        */
      def nameOfConstant(): String = {
        val cc = c.asInstanceOf[reflect.macros.runtime.Context]
        import cc.universe._
        val macroName = cc.macroApplication.symbol.asTerm.name

        @tailrec def extractConstant(tree: cc.Tree): cc.Name = tree match {
          case Apply(RefTree(_, `macroName`), List(RefTree(_, name))) => name
          case Apply(func, _)                                         => extractConstant(func)
          case Select(qualifier, _)                                   => extractConstant(qualifier)
          case _ =>
            c.abort(c.enclosingPosition, s"Unsupported constant expression: ${expr.tree}")
        }

        extractConstant(cc.callsiteTyper.context.tree).decodedName.toString
      }

      val name = expr.tree match {
        case Literal(Constant(_)) => nameOfConstant()
        case _                    => extract(expr.tree)
      }

      c.Expr[U[T]](
        q"${c.prefix}.applyImpl($name, $expr)($bInstall, $lInstall)"
      )
    }

    def qualifiedNameOf(c: whitebox.Context)(expr: c.Expr[Any]): c.Expr[String] = {
      import c.universe._

      def extract(tree: c.Tree): List[c.Name] = tree match {
        case Ident(n)           => List(n.decodedName)
        case Select(tree, n)    => extract(tree) :+ n.decodedName
        case Function(_, body)  => extract(body)
        case Block(_, expr)     => extract(expr)
        case Apply(func, _)     => extract(func)
        case TypeApply(func, _) => extract(func)
        case _                  => c.abort(c.enclosingPosition, s"Unsupported expression: ${expr.tree}}")
      }

      val name = extract(expr.tree)
        // drop sth like x$1
        .drop(1)
        .mkString(".")
      c.Expr[String](q"$name")
    }

    def nameOfType[T](c: whitebox.Context)(implicit tag: c.WeakTypeTag[T]): c.Expr[String] = {
      import c.universe._
      val name = showRaw(tag.tpe.typeSymbol.name)
      c.Expr[String](q"$name")
    }

    def qualifiedNameOfType[T](c: whitebox.Context)(implicit tag: c.WeakTypeTag[T]): c.Expr[String] = {
      import c.universe._
      val name = showRaw(tag.tpe.typeSymbol.fullName)
      c.Expr[String](q"$name")
    }
  }
}
