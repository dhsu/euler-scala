package org.krayne.euler.from001

import org.krayne.euler.Problem

object Problem007 extends Problem[Int] {
  override val value: Int = Stream.from(2).filter(isPrime)(10000)
  private def isPrime(n: Int) = !(2 to math.sqrt(n).toInt).exists(n % _ == 0)
}