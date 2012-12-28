package org.krayne.euler.from020

import org.krayne.euler.Problem

object Problem021 extends Problem[Int] {
  override val value: Int = (1 until 10000).filter(isAmicable).sum
  
  private def properDivisorSum(x: Int): Int = (1 to x/2).filter(x % _ == 0).sum
  private def isAmicable(x: Int): Boolean = {
    val dx = properDivisorSum(x)
    val ddx = properDivisorSum(dx)
    x == ddx && x != dx
  }
}