package net.scalax.simple.nat

import core._

package injection {

  trait ListData[+T] extends NumberParent {
    override val child: () => ListData[T]
  }

  trait ListDataPositive[+T] extends ListData[T] {
    def data: T
    override val child: () => ListData[T]
  }

}
