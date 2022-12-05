package io.bnjns.puzzle

import io.bnjns.Puzzle
import io.bnjns.runAll

object Day03 : Puzzle {
    override val day: Int = 3
    override val answers: Map<Int, String> = mapOf(
        1 to "7872",
        2 to "2497"
    )
    
    override fun partOne(input: String): String = input
        .trim()
        .split("\n")
        .map { rucksack -> rucksack.intoCompartments() }
        .sumOf { rucksack -> rucksack.findCommonItem().toPriorityValue() }
        .toString()
    
    override fun partTwo(input: String): String = input
        .trim().split("\n")
        .intoGroups()
        .sumOf { it.findCommonItem().toPriorityValue() }
        .toString()
    
    private fun List<String>.intoGroups(): List<List<String>> = chunked(3)
    
    private fun String.intoCompartments(): List<String> {
        val compartmentSize = length / 2
        return listOf(substring(0, compartmentSize), substring(compartmentSize))
    }
    
    private fun List<String>.findCommonItem(): Char {
        val charArrays = map { it.toCharArray().toSet() }
        val intersect = charArrays.reduce { a, b -> a.intersect(b) }
        
        return when {
            intersect.isEmpty() -> throw IllegalStateException("No shared item")
            intersect.size == 1 -> intersect.first()
            else -> throw IllegalStateException("Multiple shared items found")
        }
    }
    
    private fun Char.toPriorityValue(): Int = when (code) {
        in 65..90 -> code - 38
        in 97..122 -> code - 96
        else -> throw IllegalArgumentException("Invalid character: $this")
    }
}

fun main() = Day03.runAll()
