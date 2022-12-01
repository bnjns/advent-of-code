package io.bnjns

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import java.nio.charset.Charset

object AdventOfCode {
    private const val YEAR = "2022"
    private val cache : MutableMap<Int, String> = mutableMapOf()
    
    init {
        FuelManager.instance.basePath = "https://adventofcode.com/$YEAR"
        FuelManager.instance.baseHeaders = mapOf(
            "Cookie" to "session=${System.getenv("ADVENT_OF_CODE_SESSION_ID")}"
        )
    }
    
    fun getInput(day: Int): String = cache.getOrPut(day) {
        "/day/$day/input".httpGet()
            .also { request -> println(request.toString()) }
            .responseString(Charset.defaultCharset())
            .third
            .get()
    }
}
