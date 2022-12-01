package io.bnjns

import io.bnjns.puzzle.DayOne
import io.bnjns.puzzle.DayTwo

val days = listOf(
    DayOne,
    DayTwo
)

fun main(args: Array<String>) = days.forEach(Puzzle::runAll)
