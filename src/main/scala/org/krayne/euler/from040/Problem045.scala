package org.krayne.euler.from040

import org.krayne.euler.Problem

object Problem045 extends Problem[Long] {
  case class Indices(tIndex: Int, pIndex: Int, hIndex: Int) {
    def isEqualValues = triangle(tIndex) == pentagonal(pIndex) && triangle(tIndex) == hexagonal(hIndex)
  }
  
  override val value: Long = triangle(indicesFrom(Indices(286, 165, 143)).find(_.isEqualValues).get.tIndex)
  
  private def triangle(n: Int): Long = n.toLong * (n.toLong + 1L) / 2L
  private def pentagonal(n: Int): Long = n.toLong * (3L*n.toLong - 1L) / 2L
  private def hexagonal(n: Int ): Long = n.toLong * (2L*n.toLong - 1L)
  private def indicesFrom(i: Indices): Stream[Indices] = i #:: {
    def next(i: Indices): Indices = {
      val nextTIndex = i.tIndex + 1
      val nextTValue = triangle(nextTIndex)
      def nextPIndex(p: Int): Int = if(pentagonal(p) < nextTValue) nextPIndex(p + 1) else p
      def nextHIndex(h: Int): Int = if(hexagonal(h) < nextTValue) nextHIndex(h + 1) else h
      Indices(nextTIndex, nextPIndex(i.pIndex), nextHIndex(i.hIndex))
    }
    indicesFrom(next(i))
  }
}