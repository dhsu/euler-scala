package org.krayne.euler.from030

import org.krayne.euler.Problem

object Problem039 extends Problem[Int] {
  case class Triangle(a: Int, b: Int, c: Int) {
    def isRightTriangle = (a*a + b*b == c*c) && (a > 0) && (b > 0) && (c > 0)
  }
  
  override val value: Int = (1 to 1000) maxBy (rightTrianglesFor(_).size)
  
  private def rightTrianglesFor(p: Int): Seq[Triangle] = {
    for {
      c <- p/3 until p
      b <- 1 until c
      val a = p - c - b if(a <= b)
      val triangle = Triangle(a, b, c) if(triangle.isRightTriangle)
    } yield triangle
  }
}