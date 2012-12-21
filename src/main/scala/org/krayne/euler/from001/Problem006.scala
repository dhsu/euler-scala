package org.krayne.euler.from001

import org.krayne.euler.Problem

object Problem006 extends Problem[Int] {
  override val value: Int = squareOfSumTo(100) - sumOfSquaresTo(100)
  private def sumOfSquaresTo(n: Int) = (1 to n).map(i => i * i).sum
  private def squareOfSumTo(n: Int) = {val sum = (1 to n).sum; sum * sum}
}