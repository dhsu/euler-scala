package org.krayne.euler.from020

import org.krayne.euler.Problem

object Problem025 extends Problem[BigInt] {
  override val value: BigInt = fibFrom(1, 1).indexWhere(_.toString.length >= 1000) + 1
  private def fibFrom(a: BigInt, b: BigInt): Stream[BigInt] = a #:: fibFrom(b, a + b)
}