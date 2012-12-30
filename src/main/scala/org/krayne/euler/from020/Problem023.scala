package org.krayne.euler.from020

import org.krayne.euler.Problem

object Problem023 extends Problem[Int] {
  override val value: Int = {
    val abundants = abundantsLessThan(28123 + 1)
    (1 to 28123).filterNot(isSumFrom(_, abundants)).sum
  }
  
  private def properDivisorSum(x: Int): Int = (1 to x/2).filter(x % _ == 0).sum
  private def isAbundant(x: Int): Boolean = properDivisorSum(x) > x
  private def abundantsLessThan(x: Int): Set[Int] = (1 until x).filter(isAbundant).toSet
  private def isSumFrom(x: Int, numbers: Set[Int]): Boolean = numbers.find(n => numbers.contains(x - n)).isDefined
}