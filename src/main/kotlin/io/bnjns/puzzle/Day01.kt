package io.bnjns.puzzle

import io.bnjns.Puzzle

object Day01 : Puzzle {
    override val day: Int = 1
    override val answers = mapOf(
        1 to "68787",
        2 to "198041"
    )
    
    override fun partOne(input: String): String  = input
        .groupCaloriesByElf()
        .sumOverTop(1)
        .toString()
    
    override fun partTwo(input: String): String = input
        .groupCaloriesByElf()
        .sumOverTop(3)
        .toString()
    
    private fun String.groupCaloriesByElf(): List<List<Int>> = trim()
        .split("\n\n")
        .map { it.split("\n").map(String::toInt) }
    
    private fun List<List<Int>>.sumOverTop(num: Int = 1): Int = this.asSequence()
        .map { it.sum() }
        .sortedDescending()
        .take(num)
        .sum()
}
