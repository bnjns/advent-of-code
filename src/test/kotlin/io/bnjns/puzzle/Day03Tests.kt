package io.bnjns.puzzle

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day03Tests : FunSpec() {
    init {
        context("the example") {
            val input = """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw
            """.trimIndent()
            
            test("part 1 should return the correct answer") {
                Day03.partOne(input).shouldBe("157")
            }
            
            test("part 2 should return the correct answer") {
                Day03.partTwo(input).shouldBe("70")
            }
        }
    }
}
