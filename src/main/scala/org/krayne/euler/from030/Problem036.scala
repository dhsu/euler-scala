package org.krayne.euler.from030

import org.krayne.euler.Problem

object Problem036 extends Problem[Int] {
  override val value: Int = (1 until 1000000) filter isDoubleBasePalindrome sum
  private def isDoubleBasePalindrome(x: Int) = isPalindrome(x.toString) && isPalindrome(x.toBinaryString)
  private def isPalindrome[T](s: Seq[T]) = s == s.reverse
}