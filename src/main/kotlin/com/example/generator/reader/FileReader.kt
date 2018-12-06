package com.example.generator.reader

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class FileReader {
    companion object {
        fun readRandomFNames(count: Int): List<String> {
            val file = File(ClassLoader.getSystemResource("fnames").file)
            return this.readRandomNames(file, count)
        }

        fun readRandomLNames(count: Int): List<String> {
            val file = File(ClassLoader.getSystemResource("lnames").file)
            return this.readRandomNames(file, count)
        }

        private fun readRandomNames(file: File, count: Int): List<String>  {
            val names = ArrayList<String>()
            val allNames = file.readLines(Charsets.UTF_8)

            repeat(count) {
                val randomNameIndex = (0..(allNames.size - 1)).random()
                names.add(allNames.get(randomNameIndex).trim())
            }

            return names
        }

        private fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) +  start
    }
}