package io.bnjns.puzzle

import io.bnjns.Puzzle
import io.bnjns.runAll

object Day05 : Puzzle {
    override val day: Int = 5
    override val answers: Map<Int, String> = mapOf(
        1 to "BZLVHBWQF",
        2 to "TDGJQTZSL"
    )
    
    override fun partOne(input: String): String {
        val (stacks, instructions) = input.parse()
        
        instructions.forEach { instruction -> stacks.process(instruction, keepOrder = false) }
        
        return stacks.toList()
            .joinToString(separator = "") { (_, crates) -> crates.first() }
    }
    
    override fun partTwo(input: String): String {
        val (stacks, instructions) = input.parse()
        
        instructions.forEach { instruction -> stacks.process(instruction, keepOrder = true) }
        
        return stacks.toList()
            .joinToString(separator = "") { (_, crates) -> crates.first() }
    }
    
    private fun String.parse(): Pair<Map<Int, MutableList<String>>, List<Instruction>> {
        val (stackDefinition, instructionString) = split("\n\n")
        
        return stackDefinition.parseStackDefinition() to instructionString.parseInstructions()
    }
    
    private fun String.parseStackDefinition(): Map<Int, MutableList<String>> {
        val lines = split("\n")
        val stackIds = lines[lines.size - 1]
            .trim()
            .replace("\\s".toRegex(), "")
            .split("")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
        
        val initialStack = lines.subList(0, lines.size - 1)
            .map { line ->
                line.chunked(4)
                    .map { it.trim().trimStart('[').trimEnd(']') }
                    .map {
                        when (it) {
                            "" -> null
                            else -> it
                        }
                    }
            }
        
        return stackIds.associateWith { id -> initialStack.mapNotNull { it.getOrNull(id - 1) }.toMutableList() }
    }
    
    private fun String.parseInstructions(): List<Instruction> = split("\n")
        .mapNotNull { instruction -> Instruction.REGEX.find(instruction) }
        .map { matchResult ->
            Instruction(
                num = matchResult.groups[1]!!.value.toInt(),
                from = matchResult.groups[2]!!.value.toInt(),
                to = matchResult.groups[3]!!.value.toInt(),
            )
        }
    
    private fun Map<Int, MutableList<String>>.process(instruction: Instruction, keepOrder: Boolean) {
        val toMove = this[instruction.from]!!.subList(
            fromIndex = 0,
            toIndex = instruction.num
        )
        
        this[instruction.to]!!.addAll(0, if (keepOrder) toMove else toMove.reversed())
        for (i in 0 until instruction.num) {
            this[instruction.from]!!.removeAt(0)
        }
    }
    
    data class Instruction(val num: Int, val from: Int, val to: Int) {
        companion object {
            val REGEX = Regex("move\\s(?<num>\\d+)\\sfrom\\s(?<from>\\d+)\\sto\\s(?<to>\\d+)")
        }
    }
}

fun main() = Day05.runAll()
