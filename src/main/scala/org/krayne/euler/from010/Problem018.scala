package org.krayne.euler.from010

import org.krayne.euler.Problem

object Problem018 extends Problem[Int] {
  private type Triangle = Array[Array[Int]]
  private val TriangleString = """75
                                  95 64
                                  17 47 82
                                  18 35 87 10
                                  20 04 82 47 65
                                  19 01 23 75 03 34
                                  88 02 77 73 07 63 67
                                  99 65 04 28 06 16 70 92
                                  41 41 26 56 83 40 80 70 33
                                  41 48 72 33 47 32 37 16 94 29
                                  53 71 44 65 25 43 91 52 97 51 14
                                  70 11 33 28 77 73 17 78 39 68 17 57
                                  91 71 52 38 17 14 91 43 58 50 27 29 48
                                  63 66 04 68 89 53 67 30 73 16 69 87 40 31
                                  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"""
  private val Triangle = TriangleString.split('\n').map(_.trim.split("\\s+").map(_.toInt))
  
  override val value: Int = maxPathSum(Triangle)
  
  private def maxPathSum(triangle: Triangle): Int = {
    def nextSumRow(lastSumRow: Array[Int], valueRow: Array[Int]): Array[Int] = {
      val additions = lastSumRow match {
        case Array() => Array(0)
        case Array(v) => Array(v, v)
        case _ @ a => a.head +: a.sliding(2).map(_.max).toArray :+ a.last
      }
      valueRow.zip(additions).map(t => t._1 + t._2)
    }
    
    val Empty: Array[Int] = Array()
    val lastSumRow: Array[Int] = Triangle.foldLeft(Empty)(nextSumRow(_, _))
    lastSumRow.max
  }
}