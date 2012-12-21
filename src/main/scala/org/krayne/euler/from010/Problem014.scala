package org.krayne.euler.from010

import org.krayne.euler.Problem

object Problem014 extends Problem[Int] {
  override val value: Int = Stream.range(1L, 1000000L).map(collatzCount).zipWithIndex.maxBy(_._1)._2 + 1
  
  /*private def collatz(n: Int): Stream[Int] = n match {
    case 1 => Stream(1)
    case _ => n #:: collatz(if(n % 2 == 0) n/2 else 3*n + 1)
  }*/
  
  private def collatzCount(n: Long): Long = {
    def loop(n: Long, count: Long): Long = {
      if(n > 1L) loop(if(n%2L == 0) n/2 else 3L*n + 1L, count + 1L)
      else count + 1L
    }
    loop(n, 0L)
  }
}