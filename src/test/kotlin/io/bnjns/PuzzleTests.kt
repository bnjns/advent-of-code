package io.bnjns

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.mockk.*

class ToCheckStringTests : FunSpec() {
    init {
        context("converting a result into a check string") {
            withData(
                mapOf(
                    "true -> PASS" to (true to "PASS"),
                    "false -> FAIL" to (false to "FAIL"),
                    "null -> UNKNOWN" to (null to "UNKNOWN"),
                )
            
            ) { (value, expectedString) ->
                value.toCheckString().shouldBe(expectedString)
            }
        }
    }
}

class PuzzleTests : FunSpec() {
    init {
        beforeSpec {
            mockkObject(AdventOfCode)
        }
        afterSpec {
            unmockkObject(AdventOfCode)
        }
        
        context("a puzzle") {
            val puzzle = mockk<Puzzle>()
            every { puzzle.day } returns 5
            every { AdventOfCode.getInput(any()) } returns "INPUT"
            
            beforeEach {
                clearMocks(puzzle, recordedCalls = true, answers = false)
            }
            
            test("running a part should fetch the input from advent of code") {
                every { puzzle.partOne(any()) } returns "ANSWER"
                
                puzzle.run(1)
                
                verify(exactly = 1) { AdventOfCode.getInput(5) }
            }
            
            test("running part 1 should call partOne") {
                every { puzzle.partOne(any()) } returns "ONE"
                
                puzzle.run(1)
                
                verify(exactly = 1) { puzzle.partOne(any()) }
            }
            
            test("running part 2 should call partTwo") {
                every { puzzle.partTwo(any()) } returns "TWO"
                
                puzzle.run(2)
                
                verify(exactly = 1) { puzzle.partTwo(any()) }
            }
            
            test("running an invalid part should throw an exception") {
                val exception = shouldThrow<IllegalArgumentException> {
                    puzzle.run(-1)
                }
                exception.message shouldContain "Invalid part"
                exception.message shouldContain "-1"
            }
            
            test("checking the right answer should return true") {
                every { puzzle.answers } returns mapOf(
                    1 to "ANSWER"
                )
                
                
                val result = puzzle.check(1, "ANSWER")
                result.shouldNotBeNull()
                result.shouldBeTrue()
            }
            
            test("checking the wrong answer should return false") {
                every { puzzle.answers } returns mapOf(
                    1 to "ANSWER"
                )
                
                val result = puzzle.check(1, "WRONG")
                result.shouldNotBeNull()
                result.shouldBeFalse()
            }
            
            test("checking an undefined answer should return null") {
                every { puzzle.answers } returns mapOf()
                
                puzzle.check(1, "ANSWER").shouldBeNull()
            }
        }
    }
}
