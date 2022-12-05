package io.bnjns.puzzle

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day02Tests : FunSpec() {
    init {
        context("the example") {
            val input = """
                A Y
                B X
                C Z
            """.trimIndent()
            
            test("part 1 should return the correct answer") {
                Day02.partOne(input).shouldBe("15")
            }
            
            test("part 2 should return the correct answer") {
                Day02.partTwo(input).shouldBe("12")
            }
        }
    }
}
