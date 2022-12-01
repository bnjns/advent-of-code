package io.bnjns

import io.bnjns.puzzle.Day01
import io.bnjns.puzzle.Day02

val days = listOf(
    Day01,
    Day02
)

fun main(args: Array<String>) = days.forEach(Puzzle::runAll)
