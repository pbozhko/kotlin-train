package com.example.generator.reader

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertNotNull
import java.io.File
import java.io.FileNotFoundException

class FileReaderTest {

    @Test
    fun `Test readRandomNames if file not found`() {
        val fileName = "names.test"
        val file = File(fileName)
        if(file.exists()) {
            file.delete()
        }
        assertThrows(FileNotFoundException::class.java) {
            FileReader.readRandomNames(file, 3)
        }
    }

    @Test
    fun `Test readRandomNames`() {
        val fileName = "names.test"
        val file = File(fileName)

        val lines = ArrayList<String>()
        lines.add("line1")
        lines.add("line2")
        lines.add("line3")

        file.printWriter(Charsets.UTF_8).use { out ->
            lines.forEach {line ->
                out.println(line)
            }
        }

        val randomLines = FileReader.readRandomNames(file, 3)

        assertNotNull(randomLines)
        assertTrue(randomLines.size == 3)

        randomLines.forEach {
            randomLine -> assertTrue(lines.contains(randomLine))
        }
    }
}