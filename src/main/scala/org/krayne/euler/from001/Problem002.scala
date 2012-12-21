package org.krayne.euler.from001

import org.krayne.euler.Problem

object Problem002 extends Problem[Int] {
  override val value: Int = fibFrom(0, 1).takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum
  private def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)
}