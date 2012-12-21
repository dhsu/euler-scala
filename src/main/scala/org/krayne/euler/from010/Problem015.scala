package org.krayne.euler.from010

import org.krayne.euler.Problem

object Problem015 extends Problem[Long] {
  override val value: Long = gridPaths(20)
  
  private def gridPaths(n: Int): Long = {
    def nextCounts(prev: Seq[Long]): Seq[Long] = prev match {
      case Seq() => Vector(2L)
      case Seq(v) => Vector(v+1L, v+1L)
      case _ => (prev.head+1) +: prev.sliding(2).map(_.sum).toSeq :+ (prev.last+1)
    }
    def loop(i: Int, gridSize: Int, counts: Seq[Long]): Seq[Long] = {
      if(i >= (n-1)*2) counts
      else if(i < n-1) loop(i+1, n, nextCounts(counts))
      else loop(i+1, n, nextCounts(counts).init.tail)
    }
    loop(0, n, Vector(2L)).head
  }
}