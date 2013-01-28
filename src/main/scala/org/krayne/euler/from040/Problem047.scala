package org.krayne.euler.from040

import org.krayne.euler.Problem

object Problem047 extends Problem[Int] {
  override val value: Int = Stream.from(2).find(isSpecial(_, 4)).get
  
  private def isSpecial(n: Int, numDistinctPrimeFactors: Int) = {
    !(n until (n + numDistinctPrimeFactors)).exists(primeFactors(_).distinct.size != numDistinctPrimeFactors)
  }
  
  private def primeFactors(n: Int): List[Int] = (2 to math.sqrt(n).toInt).find(n % _ == 0) match {
    case Some(p) => p :: primeFactors(n/p)
    case None => List(n)
  }
}