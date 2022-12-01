package io.bnjns.puzzle

import io.bnjns.Puzzle

object Day02 : Puzzle {
    override val day: Int = 2
    
    override val answers = mapOf(
        1 to "1938402",
        2 to "1947878632"
    )
    
    override fun partOne(input: String): String {
        val finalPosition = input.trim()
            .split("\n")
            .fold(Position()) { acc, instruction -> acc.adjustPosition(instruction) }
        
        return (finalPosition.horizontal * finalPosition.depth).toString()
    }
    
    override fun partTwo(input: String): String {
        val finalPosition = input.trim()
            .split("\n")
            .fold(AimedPosition()) { acc, instruction -> acc.adjustPosition(instruction) }
    
        return (finalPosition.horizontal * finalPosition.depth).toString()
    }
    
    data class Position(val horizontal: Int = 0, val depth: Int = 0)
    data class AimedPosition(val horizontal: Int = 0, val depth: Int = 0, val aim: Int = 0)
    
    private fun Position.adjustPosition(instruction: String): Position {
        val (direction, size) = instruction.split(" ")
        
        return when (direction.lowercase()) {
            "forward" -> copy(horizontal = horizontal + size.toInt())
            "down" -> copy(depth = depth + size.toInt())
            "up" -> copy(depth = depth - size.toInt())
            else -> throw IllegalArgumentException("Unrecognised direction: $direction")
        }
    }
    
    private fun AimedPosition.adjustPosition(instruction: String): AimedPosition {
        val (direction, size) = instruction.split(" ")
        
        return when (direction.lowercase()) {
            "forward" -> copy(horizontal = horizontal + size.toInt(), depth = depth + aim * size.toInt())
            "down" -> copy(aim = aim + size.toInt())
            "up" -> copy(aim = aim - size.toInt())
            else -> throw IllegalArgumentException("Unrecognised direction: $direction")
        }
    }
}
