package io.bnjns.puzzle

import io.bnjns.Puzzle
import io.bnjns.runAll

object Day04 : Puzzle {
    override val day: Int = 4
    override val answers: Map<Int, String> = mapOf(
        1 to "456",
        2 to "808"
    )
    
    override fun partOne(input: String): String = input
        .trim()
        .split("\n")
        .countDuplicating { it.fullyContains() }
    
    
    override fun partTwo(input: String): String = input
        .trim()
        .split("\n")
        .countDuplicating { it.hasOverlap() }
    
    private fun String.parseSectionRanges(): Pair<IntRange, IntRange> {
        val ranges = split(",")
            .map {
                val (min, max) = it.split("-")
                min.toInt()..max.toInt()
            }
        
        return ranges[0] to ranges[1]
    }
    
    private fun List<String>.countDuplicating(fn: (Pair<IntRange, IntRange>) -> Boolean): String =
        map { it.parseSectionRanges() }
            .filter(fn)
            .size
            .toString()
    
    private fun Pair<IntRange, IntRange>.fullyContains(): Boolean {
        return first.first >= second.first && first.last <= second.last
            || second.first >= first.first && second.last <= first.last
    }
    
    private fun Pair<IntRange, IntRange>.hasOverlap(): Boolean {
        return first.intersect(second).isNotEmpty()
    }
}

fun main() = Day04.runAll()
