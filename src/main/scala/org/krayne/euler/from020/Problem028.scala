package org.krayne.euler.from020

import org.krayne.euler.Problem

object Problem028 extends Problem[Int] {
  override val value: Int = diagSum(1001)
  
  private def diagSum(size: Int): Int = {
    val increments: List[Int] = (2 to size by 2).flatMap(List.fill(4)(_)).toList
    def diags(acc: Int, increments: Seq[Int]): List[Int] = increments match {
      case x :: xs => acc :: diags(acc + x, xs)
      case _ => List(acc)
    }
    diags(1, increments).sum
  }
}