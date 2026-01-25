package net.scalax.simple.adt
package instance
package support

object AppendTail4 {
  AppendTailSelf =>

  trait AppendAdtHelper {
    implicit def appendAbs1[A, S, CA <: AdtCoProduct, CB <: AdtCoProduct](implicit
      tail: AppendTail2.AppenderAdt[A, CA, CB]
    ): AppendTail2.AppenderAdt[A, AdtCoProduct.UsePositive[S, CA], AdtCoProduct.UsePositive[S, CB]] = tail.append[S]

    implicit def zeroAppender[Item1, Zero]
      : AppendTail2.AppenderAdt[Item1, AdtCoProduct.UseOne[Zero], AdtCoProduct.UsePositive[Zero, AdtCoProduct.UseOne[Item1]]] =
      new AppendTail2.AppenderAdt[Item1, AdtCoProduct.UseOne[Zero], AdtCoProduct.UsePositive[Zero, AdtCoProduct.UseOne[Item1]]] {
        override def inputAbsAbs(
          param: Either[Item1, AdtCoProduct.UseOne[Zero]]
        ): AdtCoProduct.UsePositive[Zero, AdtCoProduct.UseOne[Item1]] = {
          param.fold[AdtCoProduct.UsePositive[Zero, AdtCoProduct.UseOne[Item1]]](
            (a1: Item1) =>
              AdtCoProduct.UsePositive.right[Zero, AdtCoProduct.UseOne[Item1]](new AdtCoProduct.UseOne[Item1] {
                override val value: Item1 = a1
              }),
            (a1: AdtCoProduct.UseOne[Zero]) => AdtCoProduct.UsePositive.left[Zero, AdtCoProduct.UseOne[Item1]](a1.value)
          )
        }
      }

    def appendByDefault[U, Z1 <: AdtCoProduct, Z2 <: AdtCoProduct](input: AdtCoProduct.UsePositive[U, Z1])(implicit
      u1: AppendTail2.AppenderAdt[U, Z1, Z2]
    ): Z2 = u1.inputAbs(input)
  }

}
