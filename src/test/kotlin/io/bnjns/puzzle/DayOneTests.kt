package io.bnjns.puzzle

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DayOneTests : FunSpec() {
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
                DayOne.partOne(input).shouldBe("7")
            }
    
            test("part 2 should return the correct answer") {
                DayOne.partTwo(input).shouldBe("5")
            }
        }
    }
}
