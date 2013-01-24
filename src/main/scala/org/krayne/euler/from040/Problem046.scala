package org.krayne.euler.from040

import org.krayne.euler.Problem

object Problem046 extends Problem[Int] {
  override val value: Int = oddCompositesFrom(2).find(c => !isGoldbachSum(c)).get
  
  private def isPrime(n: Int) = !(2 to math.sqrt(n).toInt).exists(n % _ == 0)
  private def primesFrom(n: Int): Stream[Int] = if(isPrime(n)) n #:: primesFrom(n + 1) else primesFrom(n + 1)
  private def twiceSquareFrom(n: Int): Stream[Int] = Stream.from(n).map(n => 2 * n * n)
  private def oddCompositesFrom(n: Int): Stream[Int] = Stream.from(n).filter(_ % 2 != 0).filterNot(isPrime)
  private def isGoldbachSum(n: Int) = {
    def isGoldbachPrime(p: Int) = twiceSquareFrom(1).takeWhile(_ + p <= n).exists(_ + p == n)
    primesFrom(2).takeWhile(_ < n).exists(isGoldbachPrime)
  }
}