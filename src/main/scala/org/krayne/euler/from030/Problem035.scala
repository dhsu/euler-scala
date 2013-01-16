package org.krayne.euler.from030

import org.krayne.euler.Problem

object Problem035 extends Problem[Int] {
  override val value: Int = (2 until 1000000) filter isCircularPrime size
  private def isCircularPrime(n: Int) = !shifted(n.toString).take(n.toString.length).map(_.mkString.toInt).exists(!isPrime(_))
  private def shifted[T](s: Seq[T]): Stream[Seq[T]] = s #:: shifted(s.tail :+ s.head)
  private def isPrime(n: Int) = !(2 to math.sqrt(n).toInt).exists(n % _ == 0)
}