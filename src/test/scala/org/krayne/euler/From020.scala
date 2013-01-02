package org.krayne.euler

import org.scalatest.FunSuite
import org.krayne.euler.from020._

class From020 extends FunSuite {
  test("Problem 20") {assert(Problem020.value == 648)}
  test("Problem 21") {assert(Problem021.value == 31626)}
  test("Problem 22") {assert(Problem022.value == 871198282L)}
  test("Problem 23") {assert(Problem023.value == 4179871)}
  test("Problem 24") {assert(Problem024.value == 2783915460L)}
  test("Problem 25") {assert(Problem025.value == BigInt(4782))}
  test("Problem 26") {assert(Problem026.value == 983)}
}