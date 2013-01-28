package org.krayne.euler.from040

import org.krayne.euler.Problem

object Problem048 extends Problem[String] {
  override val value: String = (1 to 1000).map(n => BigInt(n).pow(n)).sum.toString.takeRight(10)
}