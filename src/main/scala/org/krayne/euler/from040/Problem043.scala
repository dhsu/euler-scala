package org.krayne.euler.from040

import org.krayne.euler.Problem

object Problem043 extends Problem[Long] {
  private val Primes = List(2, 3, 5, 7, 11, 13, 17)
  private val pandigitals: Iterator[String] = (0 to 9).permutations.map(_.mkString)
  override val value: Long = pandigitals.filter(isSubstringDivisible).map(_.toLong).sum
  private def isSubstringDivisible(s: String) = !s.sliding(3).toList.tail.zip(Primes).exists(t => t._1.toInt % t._2 != 0)
}