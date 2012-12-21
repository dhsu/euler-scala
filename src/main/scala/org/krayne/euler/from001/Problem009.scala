package org.krayne.euler.from001

import org.krayne.euler.Problem

object Problem009 extends Problem[Int] {
  override val value: Int = {
    val sumsTo1000 = for {
      a <- (1 to 1000)
      b <- (1 to 1000)
      c <- (1 to 1000)
      if(a + b + c == 1000)
    } yield List(a, b, c)
    sumsTo1000.find(s => s(0)*s(0) + s(1)*s(1) == s(2)*s(2)) match {
      case Some(s: Seq[Int]) => s.product
      case None => throw new Exception("Fail")
    }
  }
}