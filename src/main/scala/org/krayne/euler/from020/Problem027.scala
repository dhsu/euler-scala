package org.krayne.euler.from020

import org.krayne.euler.Problem

object Problem027 extends Problem[Int] {
  override val value: Int = {
    val consecPrimesOver40 = for {
      a <- -999 to 999
      b <- (-999 to 999).filter(isAbsPrime)
      val numConsecPrimes = numConsecutivePrimes(a, b)
      if numConsecPrimes >= 40 // from the problem, we know we can find one of at least 40
    } yield ((a, b), numConsecPrimes)
    val (a, b) = consecPrimesOver40.maxBy(_._2)._1
    a * b
  }
  
  private def numConsecutivePrimes(a: Int, b: Int) = Stream.from(0).indexWhere(n => !isAbsPrime(n*n + a*n + b))
  private def isAbsPrime(x: Int) = !(2 to math.sqrt(x.abs).toInt).exists(x % _ == 0)
}