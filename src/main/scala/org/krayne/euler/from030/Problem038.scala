package org.krayne.euler.from030

import org.krayne.euler.Problem

object Problem038 extends Problem[Long] {
  override val value: Long = (1 to 5).map(d => concatenatedProducts(nDigitNumbers(d), (10/d).ceil.toInt).filter(isPandigital)).flatten.max.toLong
  private def nDigitNumbers(numDigits: Int) = math.pow(10, numDigits-1).toInt until math.pow(10, numDigits).toInt
  private def concatenatedProducts(values: Seq[Int], n: Int): Seq[String] = values.map(i => concatenatedProduct(i, n))
  private def concatenatedProduct(i: Int, n: Int): String = (1 to n).map(v => (v*i).toString).reduce(_+_)
  private def isPandigital(s: String) = !(1 to s.length).exists(n => !s.contains(n.toString))
}