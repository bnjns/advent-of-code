package io.bnjns.puzzle

import io.bnjns.Puzzle
import io.bnjns.runAll

object Day02 : Puzzle {
    private const val LOSE = "X"
    private const val DRAW = "Y"
    private const val WIN = "Z"
    
    
    override val day: Int = 2
    override val answers: Map<Int, String> = mapOf(
        1 to "12458",
        2 to "12683"
    )
    
    override fun partOne(input: String): String = input
        .trim()
        .split("\n")
        .map { strategy ->
            val (opponent, move) = strategy.split(" ")
            opponent.identifyMove() to move.identifyMove()
        }
        .sumOf { (opponent, move) -> determineMoveScore(opponent, move) }
        .toString()
    
    override fun partTwo(input: String): String = input
        .trim()
        .split("\n")
        .map { strategy ->
            val (opponent, result) = strategy.split(" ")
            val opponentMove = opponent.identifyMove()
            opponentMove to opponentMove.identifyMoveForResult(result)
        }
        .sumOf { (opponent, move) ->
            determineMoveScore(
                opponent,
                move
            )
        } // Ideally we would just use the existing result but effort
        .toString()
    
    
    private enum class Move(val score: Int) {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);
    }
    
    private fun String.identifyMove(): Move = when (this.uppercase()) {
        "A", "X" -> Move.ROCK
        "B", "Y" -> Move.PAPER
        "C", "Z" -> Move.SCISSORS
        else -> throw IllegalArgumentException("Invalid move: $this")
    }
    
    private fun Move.identifyMoveForResult(result: String): Move = when (result.uppercase()) {
        WIN -> when (this) {
            Move.ROCK -> Move.PAPER
            Move.PAPER -> Move.SCISSORS
            Move.SCISSORS -> Move.ROCK
        }
        
        DRAW -> this
        LOSE -> when (this) {
            Move.ROCK -> Move.SCISSORS
            Move.PAPER -> Move.ROCK
            Move.SCISSORS -> Move.PAPER
        }
        
        else -> throw IllegalArgumentException("Invalid result: $result")
    }
    
    private fun Move.playAgainst(move: Move): Int {
        return when (move) {
            Move.ROCK -> when (this) {
                Move.ROCK -> 3
                Move.PAPER -> 0
                Move.SCISSORS -> 6
            }
            
            Move.PAPER -> when (this) {
                Move.ROCK -> 6
                Move.PAPER -> 3
                Move.SCISSORS -> 0
            }
            
            Move.SCISSORS -> when (this) {
                Move.ROCK -> 0
                Move.PAPER -> 6
                Move.SCISSORS -> 3
            }
        }
    }
    
    private fun determineMoveScore(opponent: Move, move: Move): Int = move.score + opponent.playAgainst(move)
    
}

fun main() = Day02.runAll()
