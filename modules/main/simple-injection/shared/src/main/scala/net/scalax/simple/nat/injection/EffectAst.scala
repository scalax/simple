package net.scalax.simple.nat

import core._

package injection {

  trait NatInjection {
    def exportInjection: Any
  }

  /*trait NeedPassInjection extends NatInjection with NeedPass {
    override val tail: () => NeedFutureInjection
  }
  trait NeedFutureInjection extends NatInjection with NeedFuture {
    override val future: () => NeedPassInjection
  }

  trait ValueInjection extends NeedFutureInjection {
    def value: Any
    override val future: () => NeedPassInjection
    override def exportInjection: Any
  }
  trait EffectInjection extends NeedPassInjection {
    type F[_]
    def effectValue: F[NatInjection]
    override val tail: () => NeedFutureInjection
    override def exportInjection: Any
  }
  trait FlatMappedInjection extends NatInjection with Current with FlatMapNeedFuture with FlatMapNeedPass {
    self =>
    override val provide: Any => NatInjection
    override def input: NatInjection
    override def exportInjection: Any
    override val future: () => NeedPassInjection = () => self
    override val tail: () => NeedFutureInjection = () => self
  }

  trait FlatMapNeedPass extends NeedPassInjection with NatInjection {
    def input: NatInjection
    override val tail: () => NeedFutureInjection
  }

  trait FlatMapNeedFuture extends NeedFutureInjection with (Any => NatInjection) {
    val provide: Any => NatInjection
    override val future: () => NeedPassInjection
    override def apply(any: Any): NatInjection = provide(any)
  }

  trait FlatMappedInjectionContext {
    val exportInjectionImpl: FlatMappedInjection => Any

    def apply(input: NatInjection, provide: Any => NatInjection): FlatMappedInjection = {
      val inputImpl: NatInjection          = input
      val provideImpl: Any => NatInjection = provide
      lazy val flatCurrent: FlatMappedInjection = new FlatMappedInjection {
        self =>
        override val provide: Any => NatInjection = provideImpl
        override def input: NatInjection          = inputImpl
        override def exportInjection: Any         = exportInjectionImpl(self)
      }

      flatCurrent
    }
  }*/

}
