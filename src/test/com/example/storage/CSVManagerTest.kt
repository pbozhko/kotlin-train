package com.example.storage

import com.example.model.Role
import com.example.model.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File
import java.io.FileNotFoundException

class CSVManagerTest {

    @Test
    fun `Test write`() {
        val timeStr1 = "2018-01-22T03:05:11"
        val user1 = User(1, "FName1", "LName1", LocalDateTime.parse(timeStr1), Role.ADMIN)

        val timeStr2 = "2008-01-22T03:05:11"
        val user2 = User(2, "FName2", "LName2", LocalDateTime.parse(timeStr2), Role.USER)

        val users = ArrayList<User>()
        users.add(user1)
        users.add(user2)

        val fileName = "users.test.csv"

        CSVManager.write(users, fileName)

        val expected = "1,FName1,LName1,2018-01-22T03:05:11,ADMIN" + "\n" + "2,FName2,LName2,2008-01-22T03:05:11,USER" + "\n"
        assertTrue(File(fileName).readText().equals(expected))
    }

    @Test
    fun `Test read`() {
        val csv = "1,FName1,LName1,2018-01-22T03:05:11,ADMIN" + "\n" + "2,FName2,LName2,2008-01-22T03:05:11,USER" + "\n"
        val fileName = "users.test.csv"

        val timeStr1 = "2018-01-22T03:05:11"
        val user1 = User(1, "FName1", "LName1", LocalDateTime.parse(timeStr1), Role.ADMIN)

        val timeStr2 = "2008-01-22T03:05:11"
        val user2 = User(2, "FName2", "LName2", LocalDateTime.parse(timeStr2), Role.USER)

        File(fileName).printWriter(Charsets.UTF_8).use { out ->
            out.print(csv)
        }

        val users = CSVManager.read(fileName)

        assertTrue(users.size == 2)

        assertEquals(user1, users.get(0))
        assertEquals(user2, users.get(1))
    }

    @Test
    fun `Test read if file not found`() {
        val fileName = "users.test.csv"
        val file = File(fileName)
        if(file.exists()) {
            file.delete()
        }
        Assertions.assertThrows(FileNotFoundException::class.java) {
            CSVManager.read(fileName)
        }
    }
}