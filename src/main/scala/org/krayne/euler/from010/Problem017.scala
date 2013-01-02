package org.krayne.euler.from010

import org.krayne.euler.Problem

object Problem017 extends Problem[Long] {
  val value: Long = {
    val onesCounts = Vector(0, 3, 3, 5, 4, 4, 3, 5, 5, 4)
    val tensCounts = Vector(0, -1, 6, 6, 5, 5, 5, 7, 6, 6)
    val specialTensCounts = Map(10 -> (3-0), 11 -> (6-3), 12 -> (6-3), 13 -> (8-5), 14 -> (8-4),
                                15 -> (7-4), 16 -> (7-3), 17 -> (9-5), 18 -> (8-5), 19 -> (8-4))
    val hundredsCounts = onesCounts
    def letterCount(n: Int): Int = {
      def hundreds = hundredsCounts(n/100) + (if(n >= 100) "hundred".length else 0) + (if(n > 100 && n % 100 != 0) "and".length else 0)
      def tens = specialTensCounts.get(n % 100).getOrElse(tensCounts((n % 100)/10))
      def ones = onesCounts(n % 10)
      hundreds + tens + ones
    }
    
    "onethousand".length + (1 to 999).map(letterCount).sum
  }
  
  def main(args: Array[String]) {
    println(Problem017)
  }
}