package org.krayne.euler.from001

import org.krayne.euler.Problem

object Problem003 extends Problem[Long] {
  override val value: Long = largestPrimeFactor(600851475143L)
  
  private def largestPrimeFactor(n: Long): Long = {
    def loop(n: Long, f: Long): Long = {
      if(f == n) f
      else if(n % f == 0L) loop(n / f, f)
      else loop(n, f + 1L)
    }
    loop(n, 2L)
  }
}