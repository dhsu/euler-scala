package org.krayne.euler.from040

import org.krayne.euler.Problem

object Problem044 extends Problem[Long] {
  private val pentagonals: Stream[Long] = Stream.from(1).map(n => n * (3L*n - 1L) / 2L)
  override val value: Long = Stream.from(2).map(minPentagonalPairDiff).collect({case Some(diff) => diff}).head
  
  private def pentagonalPairs(n: Int): Seq[(Long, Long)] = for {
    pj <- pentagonals.take(n-1)
    val pk = pentagonals(n-1)
    if isPentagonalPair(pj, pk)
  } yield (pj, pk)
  
  private def minPentagonalPairDiff(n: Int): Option[Long] = {
    println(n)
    val diffs = pentagonalPairs(n).map(t => (t._2 - t._1).abs)
    if(diffs.isEmpty) None else Some(diffs.min)
  }
  
  private def isPentagonal(n: Long) = pentagonals.dropWhile(_ < n).head == n
  private def isPentagonalPair(pj: Long, pk: Long) = isPentagonal(pj+pk) && isPentagonal((pk-pj).abs)
}