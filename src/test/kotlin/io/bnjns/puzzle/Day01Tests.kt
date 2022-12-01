package io.bnjns.puzzle

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day01Tests : FunSpec() {
    init {
        context("the example") {
            val input = """
                199
                200
                208
                210
                200
                207
                240
                269
                260
                263
            """.trimIndent()
    
            test("part 1 should return the correct answer") {
                Day01.partOne(input).shouldBe("7")
            }
    
            test("part 2 should return the correct answer") {
                Day01.partTwo(input).shouldBe("5")
            }
        }
    }
}
