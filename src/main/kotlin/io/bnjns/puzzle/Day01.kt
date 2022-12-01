package io.bnjns.puzzle

import io.bnjns.Puzzle

object Day01 : Puzzle {
    override val day: Int = 1
    override val answers = mapOf(
        1 to "1184",
        2 to "1158"
    )
    
    override fun partOne(input: String): String {
        val measurements = input.toIntList()
        var numIncreased = 0
        
        for (i in 1 until measurements.size) {
            if (measurements[i] > measurements[i - 1]) {
                numIncreased++
            }
        }
        
        return numIncreased.toString()
    }
    
    override fun partTwo(input: String): String {
        val measurementWindows = input.toIntList().windowed(3)
        var numIncreased = 0
        
        for (i in 1 until measurementWindows.size) {
            if (measurementWindows[i].sum() > measurementWindows[i - 1].sum()) {
                numIncreased++
            }
        }
        
        return numIncreased.toString()
    }
    
    private fun String.toIntList() = trim().split("\n").map(String::toInt)
}
