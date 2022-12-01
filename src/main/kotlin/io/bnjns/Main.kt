package io.bnjns

import io.bnjns.puzzle.Day01

val days = listOf<Puzzle>(
    Day01
)

fun main(args: Array<String>) = days.forEach(Puzzle::runAll)
