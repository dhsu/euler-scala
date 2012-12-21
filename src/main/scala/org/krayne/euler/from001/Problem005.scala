package org.krayne.euler.from001

import org.krayne.euler.Problem

object Problem005 extends Problem[Int] {
  override val value: Int = Stream.from(20, 20).dropWhile(!divisibleUpTo(_, 20)).head
  private def divisibleUpTo(n: Int, d: Int): Boolean = !(1 to d).exists(n % _ != 0)
}