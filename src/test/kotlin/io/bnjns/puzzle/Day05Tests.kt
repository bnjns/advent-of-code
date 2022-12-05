package io.bnjns.puzzle

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day05Tests : FunSpec() {
    init {
        context("the example") {
            val input = """
                    [D]
                [N] [C]
                [Z] [M] [P]
                 1   2   3
                
                move 1 from 2 to 1
                move 3 from 1 to 3
                move 2 from 2 to 1
                move 1 from 1 to 2
            """.trimIndent()
            
            test("part 1 should return the correct answer") {
                Day05.partOne(input).shouldBe("CMZ")
            }
            
            test("part 2 should return the correct answer") {
                Day05.partTwo(input).shouldBe("MCD")
            }
        }
    }
}
