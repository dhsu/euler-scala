package org.krayne.euler.from040

import org.krayne.euler.Problem

object Problem041 extends Problem[Long] {
  override val value: Long = Stream.from(9, -1).map(maxPandigitalPrime).collect({case Some(p) => p}).apply(0)
  private def maxPandigitalPrime(numDigits: Int): Option[Long] = (numDigits to 1 by -1).permutations.map(_.mkString.toLong).find(isPandigitalPrime)
  private def isPandigitalPrime(n: Long) = isPandigital(n) && isPrime(n)
  private def isPandigital(n: Long) = n.toString.sorted == (1 to n.toString.size).mkString
  private def isPrime(n: Long) = !(2L to math.sqrt(n).toLong).exists(n % _ == 0)
}