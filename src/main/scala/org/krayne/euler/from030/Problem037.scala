package org.krayne.euler.from030

import org.krayne.euler.Problem

object Problem037 extends Problem[Long] {
  private val truncatablePrimes: Stream[Long] = Stream.from(1).map(_.toLong).filter(isTruncatablePrime)
  override val value: Long = truncatablePrimes.take(11).sum
  
  private def isPrime(n: Long) = (n != 1L) && !(2L to math.sqrt(n).toLong).exists(n % _ == 0)
  private def isTruncatablePrime(n: Long) = {
    val s = n.toString
    val truncated = (1 until s.length).map(s.drop(_)) ++ (1 until s.length).map(s.take(_))
    isPrime(n) && !truncated.exists(x => !isPrime(x.toLong)) && (n > 10)
  }
}
