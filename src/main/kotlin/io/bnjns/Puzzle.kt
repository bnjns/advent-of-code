package io.bnjns

interface Puzzle {
    val day: Int
    fun partOne(input: String): String
    fun partTwo(input: String): String
}

fun Puzzle.run(part: Int): String {
    val input = AdventOfCode.getInput(this.day)
    
    return when (part) {
        1 -> this.partOne(input)
        2 -> this.partTwo(input)
        else -> throw IllegalArgumentException("Illegal part: $part")
    }
}

fun Puzzle.runAll() {
    println("Day: $day")
    println("  Part 1: ${this.run(1)}")
    println("  Part 2: ${this.run(2)}")
}
