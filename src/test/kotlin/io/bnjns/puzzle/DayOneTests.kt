package io.bnjns.puzzle

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DayOneTests : FunSpec() {
    init {
        context("the example") {
            val input = """
                1000
                2000
                3000
                
                4000
                
                5000
                6000
                
                7000
                8000
                9000
                
                10000
            """.trimIndent()
            
            test("part 1 should return the correct answer") {
                DayOne.partOne(input).shouldBe("24000")
            }
            
            test("part 2 should return the correct answer") {
                DayOne.partTwo(input).shouldBe("45000")
            }
        }
    }
}
