package com.example.generator.reader

import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.collections.ArrayList

object FileReader {
    fun readRandomNames(file: File, count: Int): List<String> {

        if(!file.exists()) {
            throw FileNotFoundException()
        }

        val names = ArrayList<String>()
        val allNames = file.readLines(Charsets.UTF_8)

        repeat(count) {
            val randomNameIndex = (0..(allNames.size - 1)).random()
            names.add(allNames.get(randomNameIndex).trim())
        }

        return names
    }

    private fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start
}