package org.krayne.euler.from030

import org.krayne.euler.Problem

/**
 * As an exercise, this solution actually calculates the range of numbers we
 * need to check. This could have easily been calculated by hand.
 * A good explanation of how to calculate the range we need to check is at:
 * http://duncan99.wordpress.com/2009/01/31/project-euler-problem-30/
 */
object Problem030 extends Problem[Int] {
  override val value: Int = sumsOfNthPower(5).sum
  
  private def sumOfPowersOfDigits(x: Int, pow: Int) = x.toString.map(d => math.pow(d.asDigit, pow).toInt).sum
  private def maxSumForDigits(numDigits: Int, pow: Int) = sumOfPowersOfDigits(("9"*numDigits).toInt, pow)
  private def maxToCheck(pow: Int) = Stream.from(2).map(d => (d, maxSumForDigits(d, pow))).takeWhile(t => t._2 >= math.pow(10, t._1-1)).last._2
  private def sumsOfNthPower(pow: Int): Seq[Int] = (2 to maxToCheck(pow)).filter(x => sumOfPowersOfDigits(x, pow) == x)
}