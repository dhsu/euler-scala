package org.krayne.euler.from010

import org.krayne.euler.Problem

object Problem012 extends Problem[Long] {
  override val value: Long = trianglesFrom(0, 1).find(numFactors(_) > 500).get

  // using algorithm found on stackoverflow to find number of factors
  // http://stackoverflow.com/questions/110344/algorithm-to-calculate-the-number-of-divisors-of-a-given-number
  private def primeFactors(n: Long): List[Long] = {
    (2L to math.sqrt(n).toLong).find(n % _ == 0L) match {
      case Some(f) => f :: primeFactors(n/f)
      case None => List(n)
    }
  }
  
  private def numFactors(n: Long) = primeFactors(n).groupBy(identity).map(_._2.size + 1).product
  private def trianglesFrom(index: Long, value: Long): Stream[Long] = value #:: trianglesFrom(index + 1L, value + index + 2L)
}