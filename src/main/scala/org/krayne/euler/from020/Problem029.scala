package org.krayne.euler.from020

import org.krayne.euler.Problem

object Problem029 extends Problem[Int] {
  override val value: Int = numDistinct(2 to 100, 2 to 100)
  private def numDistinct(a: Range, b: Range): Int = (for(x <- a; y <- b) yield math.pow(x, y)).distinct.size
}