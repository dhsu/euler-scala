package org.krayne.euler.from030

import org.krayne.euler.Problem

object Problem032 extends Problem[Int] {
  override val value: Int = pandigitalProducts.sum
  
  /*
   * Let x be a digit of a number. We only need to try:
   * 
   * xxx * xx = xxxx and
   * xxxx * x = xxxx
   * 
   * xx * xx  = xxxxx won't work because 99 * 99 = 9801, which doesn't even hit
   * 9 digits total
   */
  private def pandigitalProducts: List[Int] = {
    val pandigitalProducts = (1 to 9).combinations(5) map {
      _.permutations.collect {
        case d if pandigitalProduct(d.mkString) != None => pandigitalProduct(d.mkString).get
      }
    }
    pandigitalProducts.toList.flatten.distinct
  }
  
  private def pandigitalProduct(s: String): Option[Int] = pandigitalProduct(s.take(1).toInt, s.drop(1).toInt) match {
    case Some(p) => Some(p)
    case None => pandigitalProduct(s.take(2).toInt, s.drop(2).toInt)
  }
  
  private def pandigitalProduct(x: Int, y: Int): Option[Int] = {
    val s = x.toString + y.toString + (x*y).toString
    if(s == s.distinct && s.size == 9 && !(s contains "0")) Some(x * y) else None
  }
}