package org.krayne.euler.from001

import org.krayne.euler.Problem

object Problem004 extends Problem[Int] {
  override val value: Int = {
    val palindromes = for {
      x <- (100 to 999)
      y <- (100 to 999)
      prod = x * y
      if(isPalindrome(prod))
    } yield prod
    palindromes.max
  }
  private def isPalindrome(n: Int) = n.toString == n.toString.reverse
}