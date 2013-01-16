package org.krayne.euler.from030

import org.krayne.euler.Problem

/*
 * Slow... needs some optimization
 */
object Problem034 extends Problem[Long] {
  private val DigitFact = (0 to 9).map(fact)
  override val value: Long = (3L to DigitFact(9)*7L).filter(isSumOfDigitFact).sum
  private def isSumOfDigitFact(n: Long) = n == n.toString.map(d => DigitFact(d.asDigit)).sum
  private def fact(n: Int): Long = (1L to n).product
}