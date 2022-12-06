package io.bnjns.puzzle

import io.bnjns.Puzzle
import io.bnjns.runAll

object Day06 : Puzzle {
    override val day: Int = 6
    override val answers: Map<Int, String> = mapOf(
        1 to "1876",
        2 to "2202"
    )
    
    override fun partOne(input: String): String = input
        .trim()
        .findMarkerIndex(numDistinct = 4)
        .toString()
    
    override fun partTwo(input: String): String = input
        .trim()
        .findMarkerIndex(numDistinct = 14)
        .toString()
    
    private fun String.findMarkerIndex(numDistinct: Int): Int {
        
        this.withIndex()
            .windowed(numDistinct)
            .forEach { group ->
                val numUnique = group.map { it.value }.toSet().size
                
                if (numUnique == group.size) {
                    return group.last().index + 1
                }
            }
        
        throw IllegalStateException("No marker found in: $this")
    }
}

fun main() = Day06.runAll()
