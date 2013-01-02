package org.krayne.euler

import org.scalatest.FunSuite
import org.krayne.euler.from001._

class From001 extends FunSuite {
  test("Problem 1") {assert(Problem001.value == 233168)}
  test("Problem 2") {assert(Problem002.value == 4613732)}
  test("Problem 3") {assert(Problem003.value == 6857)}
  test("Problem 4") {assert(Problem004.value == 906609)}
  test("Problem 5") {assert(Problem005.value == 232792560)}
  test("Problem 6") {assert(Problem006.value == 25164150)}
  test("Problem 7") {assert(Problem007.value == 104743)}
  test("Problem 8") {assert(Problem008.value == 40824)}
  test("Problem 9") {assert(Problem009.value == 31875000)}
}