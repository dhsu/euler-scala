package org.krayne.euler.from030

import org.krayne.euler.Problem

object Problem033 extends Problem[Int] {
  override val value: Int = {
    val curiousFractions = for {
      d <- 10 to 99
      n <- 10 to d if !isTrivial(n, d) && isDigitCancelling(n, d)
    } yield (n, d)
    val product = curiousFractions.reduce((a, b) => (a._1 * b._1, a._2 * b._2))
    simplify(product._1, product._2)._2
  }
  
  private def isDigitCancelling(n: Int, d: Int) = try {
    val intersect = n.toString intersect d.toString
    val badSimplified = simplify(n.toString.diff(intersect).toInt, d.toString.diff(intersect).toInt)
    val simplified = simplify(n, d)
    badSimplified == simplified && !intersect.isEmpty
  } catch {
    case e: NumberFormatException => false
  }
  
  private def isTrivial(n: Int, d: Int) = (n % 10 == 0) && (d % 10 == 0)
  
  private def simplify(n: Int, d: Int): (Int, Int) = {
    val divisor = if(n == 0 || d == 0) 1 else gcd(n, d)
    (n/divisor, d/divisor)
  }
  
  private def gcd(a: Int, b: Int): Int = b % a match {
    case 0 => a
    case c => gcd(c, a)
  }
}