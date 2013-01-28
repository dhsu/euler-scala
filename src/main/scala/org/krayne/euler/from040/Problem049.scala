package org.krayne.euler.from040

import org.krayne.euler.Problem

object Problem049 extends Problem[String] {
  private val Gap = 3330
  override val value: String = (1000 to (10000- 2*Gap)).map(sequenceFrom).filter(isPrimePermutationSequence).last.mkString
  private def sequenceFrom(n: Int) = List(n, n + Gap, n + 2*Gap)
  private def isPrime(n: Int) = !(2 to math.sqrt(n).toInt).exists(n % _ == 0)
  private def isPermutation(a: Int, b: Int) = a.toString.sorted == b.toString.sorted
  private def isPrimePermutationSequence(s: List[Int]) = !s.isEmpty && !s.exists(n => !(isPrime(n) && isPermutation(s.head, n)))
}