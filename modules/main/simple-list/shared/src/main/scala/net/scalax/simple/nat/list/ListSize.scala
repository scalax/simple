package net.scalax.simple.nat

import core._

package injection {

  trait ListSize extends NumberParent {
    def size: Int
  }
  trait ListSizePositive extends ListSize with NumberParent {
    override val child: () => ListSize
    override def size: Int = child().size + 1
    def index: Int         = size - 1
  }
  trait ListSizeZero extends ListSize {
    override val size: Int = 0
  }

}
