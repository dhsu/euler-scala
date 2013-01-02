package org.krayne.euler.from020

import org.krayne.euler.Problem

object Problem026 extends Problem[Int] {
  // I didn't know the math behind this one. Followed the explanation at
  // http://blog.mycila.com/2009/05/project-euler-problem-26.html
  override val value: Int = (997 to 1 by -1).filter(isPrime).maxBy(numRepeating)
  private def isPrime(x: Int) = !(2 to math.sqrt(x).toInt).exists(x % _ == 0)
  private def numRepeating(p: Int): Int = (1 to (p-1)).find(i => (BigInt(10).pow(i)-1) % p == 0).getOrElse(0)
}