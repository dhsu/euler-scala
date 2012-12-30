package org.krayne.euler.from020

import org.krayne.euler.Problem

object Problem024 extends Problem[Long] {
  override val value: Long = (0 to 9).permutations.drop(999999).next.map(_.toString).reduce(_ + _).toLong
}