package net.scalax.simple.codec
package to_list_generic

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

  transparent inline def copy[MP](inline expr: Model => MP)(data: U[MP])(implicit
    bInstall: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1],
    lInstall: BasedInstalledLabelled[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1]
  ): PojoInstance[U, Model] = ${ NameOfImpl.nameOf1('PojoInstanceSelf)('expr)('data)(using 'bInstall, 'lInstall) }

  transparent inline def apply[MP](inline expr: Model => MP)(implicit
    bInstall: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1],
    lInstall: BasedInstalledLabelled[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1]
  ): U[MP] = ${ NameOfImpl.nameOf2('PojoInstanceSelf)('expr)(using 'bInstall, 'lInstall) }

  transparent inline def get[MP](inline expr: Model => MP)(implicit
    bInstall: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1],
    lInstall: BasedInstalledLabelled[({ type F1[XX[_]] = PojoInstance[XX, Model] })#F1]
  ): U[MP] = ${ NameOfImpl.nameOf2('PojoInstanceSelf)('expr)(using 'bInstall, 'lInstall) }
}

object PojoInstance {
  PojoInstanceSelf =>

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

}

import scala.annotation.tailrec
import scala.quoted.*

object NameOfImpl {

  def nameOf1[M, T, U[_]](thisObj: Expr[PojoInstance[U, M]])(expr: Expr[M => T])(data: Expr[U[T]])(using
    bInstall: Expr[BasedInstalledSimpleProduct[[XX[_]] =>> PojoInstance[XX, M]]],
    lInstall: Expr[BasedInstalledLabelled[[XX[_]] =>> PojoInstance[XX, M]]]
  )(using Quotes, Type[U], Type[M], Type[T]): Expr[PojoInstance[U, M]] = {
    import quotes.reflect.*
    @tailrec def extract(tree: Tree): String = tree match {
      case Ident(name)                                                     => name
      case Select(_, name)                                                 => name
      case DefDef("$anonfun", _, _, Some(term))                            => extract(term)
      case Block(List(stmt), _)                                            => extract(stmt)
      case Block(_, term)                                                  => extract(term)
      case Apply(term, _) if term.symbol.fullName != "<special-ops>.throw" => extract(term)
      case TypeApply(term, _)                                              => extract(term)
      case Inlined(_, _, term)                                             => extract(term)
      case Typed(term, _)                                                  => extract(term)
      case _                                                               => throw new MatchError(s"Unsupported expression: ${expr.show}")
    }

    val name: String           = extract(expr.asTerm)
    val nameExpr: Expr[String] = Expr(name)

    '{ $thisObj.copyImpl($nameExpr, $expr)($data)(using $bInstall, $lInstall) }
  }

  def nameOf2[M, T, U[_]](thisObj: Expr[PojoInstance[U, M]])(expr: Expr[M => T])(using
    bInstall: Expr[BasedInstalledSimpleProduct[[XX[_]] =>> PojoInstance[XX, M]]],
    lInstall: Expr[BasedInstalledLabelled[[XX[_]] =>> PojoInstance[XX, M]]]
  )(using Quotes, Type[U], Type[M], Type[T]): Expr[U[T]] = {
    import quotes.reflect.*
    @tailrec def extract(tree: Tree): String = tree match {
      case Ident(name)                                                     => name
      case Select(_, name)                                                 => name
      case DefDef("$anonfun", _, _, Some(term))                            => extract(term)
      case Block(List(stmt), _)                                            => extract(stmt)
      case Block(_, term)                                                  => extract(term)
      case Apply(term, _) if term.symbol.fullName != "<special-ops>.throw" => extract(term)
      case TypeApply(term, _)                                              => extract(term)
      case Inlined(_, _, term)                                             => extract(term)
      case Typed(term, _)                                                  => extract(term)
      case _                                                               => throw new MatchError(s"Unsupported expression: ${expr.show}")
    }

    val name: String = extract(expr.asTerm)

    val nameExpr: Expr[String] = Expr(name)

    '{ $thisObj.applyImpl($nameExpr, $expr)(using $bInstall, $lInstall) }
  }

}
