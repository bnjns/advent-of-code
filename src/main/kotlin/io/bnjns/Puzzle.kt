package io.bnjns

interface Puzzle {
    val day: Int
    val answers: Map<Int, String>
    fun partOne(input: String): String
    fun partTwo(input: String): String
}

fun Puzzle.run(part: Int): String {
    val input = AdventOfCode.getInput(this.day)
    
    return when (part) {
        1 -> this.partOne(input)
        2 -> this.partTwo(input)
        else -> throw IllegalArgumentException("Invalid part: $part")
    }
}

fun Puzzle.check(part: Int, result: String): Boolean? = when (answers[part]) {
    null -> null
    result -> true
    else -> false
}

fun Boolean?.toCheckString(): String = when (this) {
    true -> "PASS"
    false -> "FAIL"
    null -> "UNKNOWN"
}

fun Puzzle.runAll() {
    println("Day: $day")
    
    listOf(1, 2).forEach { part ->
        val actual = run(part)
        val result = check(part, actual).toCheckString()
        
        println("  Part $part: $actual [$result]")
    }
}
