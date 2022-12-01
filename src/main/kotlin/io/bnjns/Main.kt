package io.bnjns

import io.bnjns.puzzle.DayOne
val days = listOf(
    DayOne,
)

fun main(args: Array<String>) = days.forEach(Puzzle::runAll)
