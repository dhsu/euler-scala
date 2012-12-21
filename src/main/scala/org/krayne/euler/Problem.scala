package org.krayne.euler

trait Problem[A] {
  def value: A
  override def toString: String = value.toString
}