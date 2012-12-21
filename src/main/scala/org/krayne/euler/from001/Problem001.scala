package org.krayne.euler.from001

import org.krayne.euler.Problem

object Problem001 extends Problem[Int] {
  override val value: Int = (1 until 1000).filter(i => i % 3 == 0 || i % 5 == 0).sum
}