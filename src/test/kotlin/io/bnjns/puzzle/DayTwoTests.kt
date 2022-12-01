package io.bnjns.puzzle

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DayTwoTests : FunSpec() {
    init {
        context("the example") {
            val input = """
                forward 5
                down 5
                forward 8
                up 3
                down 8
                forward 2
            """.trimIndent()
            
            test("part 1 should return the correct answer") {
                DayTwo.partOne(input).shouldBe("150")
            }
            
            test("part 2 should return the correct answer") {
                DayTwo.partTwo(input).shouldBe("900")
            }
        }
    }
}
