package org.krayne.euler.from020

import org.krayne.euler.Problem

object Problem020 extends Problem[Int] {
  override val value: Int = (1 to 100).foldLeft(BigInt(1))(_ * _).toString.map(_.asDigit).sum
}