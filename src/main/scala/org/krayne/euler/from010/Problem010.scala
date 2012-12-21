package org.krayne.euler.from010

import org.krayne.euler.Problem

object Problem010 extends Problem[Long] {
  override val value: Long = (2L +: (3L until 2000000L by 2L)).filter(isPrime).sum
  private def isPrime(n: Long) = !(2L to math.sqrt(n).toLong).exists(n % _ == 0)
}