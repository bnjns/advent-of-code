package io.bnjns.puzzle

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day04Tests : FunSpec() {
    init {
        context("the example") {
            val input = """
                2-4,6-8
                2-3,4-5
                5-7,7-9
                2-8,3-7
                6-6,4-6
                2-6,4-8
            """.trimIndent()
            
            test("part 1 should return the correct answer") {
                Day04.partOne(input).shouldBe("2")
            }
            
            test("part 2 should return the correct answer") {
                Day04.partTwo(input).shouldBe("4")
            }
        }
    }
}
