package org.krayne.euler.from030

import org.krayne.euler.Problem

object Problem031 extends Problem[Int] {
  override val value: Int = numCoinCombinationsFor(200, List(1, 2, 5, 10, 20, 50, 100, 200))
  
  private def numCoinCombinationsFor(amount: Int, coinValues: List[Int]): Int = {
    coinValues.sorted.reverse match {
      case Nil => 0
      case coinValue::Nil => if(amount % coinValue == 0) 1 else 0
      case maxCoinValue::remainingCoinValues => (0 to amount/maxCoinValue).map(c =>
        numCoinCombinationsFor(amount - c*maxCoinValue, remainingCoinValues)).sum
    }
  }
}