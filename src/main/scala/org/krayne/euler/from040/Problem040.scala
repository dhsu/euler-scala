package org.krayne.euler.from040

import org.krayne.euler.Problem

object Problem040 extends Problem[Int] {
  private def concatenatedIntsFrom(n: Int): Stream[Int] = Stream(n.toString.map(_.asDigit):_*) #::: concatenatedIntsFrom(n+1)
  override val value: Int = {
    val s = concatenatedIntsFrom(1)
    (0 to 6) map (e => s(math.pow(10, e).toInt - 1)) product
  }
}