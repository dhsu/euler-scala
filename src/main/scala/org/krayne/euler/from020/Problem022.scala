package org.krayne.euler.from020

import org.krayne.euler.Problem
import scala.io.Source

object Problem022 extends Problem[Long] {
  private val NamesFilePath = "/022_names.txt"
  override val value: Long = names.sortWith(_ < _).zipWithIndex.map(t => (t._2+1L) * stringValue(t._1)).sum
  
  private def stringValue(s: String): Long = s.toUpperCase.map(_ - 'A' + 1L).sum
  private lazy val names: Array[String] = {
    val source = Source.fromURL(getClass.getResource(NamesFilePath))
    val contents = source.mkString
    source.close()
    contents.split(',').map(_.tail.init)
  }
}