package org.krayne.euler.from010

import org.krayne.euler.Problem

// this is a solution that does not use an built-in date functionality
object Problem019 extends Problem[Int] {
  override val value: Int = {
    // i is the day index with 0 representing jan 1, 1901
    def firstOfMonthsFrom(i: Int, my: MoYr): Stream[Int] = i #:: firstOfMonthsFrom(i + my.numDays, my.next)
    def isSunday(i: Int) = (i+2) % 7 == 0 // jan 1, 1901 was a tuesday
    firstOfMonthsFrom(0, MoYr(1, 1901)).take(100 * 12).filter(isSunday).length
  }
  
  case class MoYr(m: Int, y: Int) { // Jan is month 1
    lazy val isLeapYear: Boolean = y match {
      case y if y % 100 == 0 => y % 400 == 0
      case y => y % 4 == 0
    }
    lazy val next: MoYr = MoYr((m+1) % 12, y + (if(m == 12) 1 else 0))
    lazy val numDays = this match {
      case MoYr(m, _) if List(4, 6, 9, 11) contains m => 30
      case MoYr(2, y) => if(isLeapYear) 29 else 28
      case _ => 31
    }
  }
}