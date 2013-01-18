package org.krayne.euler.from040

import org.krayne.euler.Problem
import scala.io.Source

object Problem042 extends Problem[Int] {
  private val WordsFilePath = "/042_words.txt"
  private val triangleNums: Stream[Int] = Stream.from(1).map(n => n * (n+1) / 2)
  private lazy val words: Seq[String] = {
    val source = Source.fromURL(getClass.getResource(WordsFilePath))
    val contents = source.mkString
    source.close()
    contents.split(",").map(_.tail.init)
  }
  
  override val value: Int = words.filter(isTriangleWord).size
  
  private def wordValue(s: String): Int = s.toLowerCase.map(_ - 'a' + 1).sum
  private def isTriangleWord(s: String) = {
    val v = wordValue(s)
    triangleNums.dropWhile(_ < v).head == v
  }
}