package io.bnjns.puzzle

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class Day06Tests : FunSpec() {
    init {
        context("part 1") {
    
            withData(
                listOf(
                    "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 7,
                    "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
                    "nppdvjthqldpwncqszvftbrmjlhg" to 6,
                    "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
                    "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11,
                )
            ) { (input, expectedResult) ->
                Day06.partOne(input).shouldBe(expectedResult.toString())
            }
        }
        
        context("part 2") {
            withData(
                listOf(
                    "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 19,
                    "bvwbjplbgvbhsrlpgdmjqwftvncz" to 23,
                    "nppdvjthqldpwncqszvftbrmjlhg" to 23,
                    "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 29,
                    "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 26,
                )
            ) { (input, expectedResult) ->
                Day06.partTwo(input).shouldBe(expectedResult.toString())
            }
        }
    }
}
