package org.krayne.euler.from010

import org.krayne.euler.Problem

object Problem016 extends Problem[Long] {
  override val value: Long = BigInt(2).pow(1000).toString.map(_.toString.toLong).sum
}