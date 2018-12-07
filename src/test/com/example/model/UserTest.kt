package com.example.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class UserTest {

    @Test
    fun `Test toCSVLine`() {
        val timeStr = "2008-01-22T03:05:11"
        val user = User(1, "FName", "LName", LocalDateTime.parse(timeStr), Role.ADMIN)
        val csv = String.format("1,FName,LName,2008-01-22T03:05:11,ADMIN")
        assertEquals(csv, user.toCSVLine())
    }

    @Test
    fun `Test fromCSVLine`() {
        val csv = String.format("1,FName,LName,2008-01-22T03:05:11,ADMIN")
        val userFromCSV = User.fromCSVLine(csv)
        val user = User(1, "FName", "LName", LocalDateTime.parse("2008-01-22T03:05:11"), Role.ADMIN)
        assertEquals(user, userFromCSV)
    }

    @Test
    fun `Test fromCSVLine with spaces`() {
        val csv = String.format("1 ,  FName , LName ,  2008-01-22T03:05:11  , ADMIN")
        val userFromCSV = User.fromCSVLine(csv)
        val user = User(1, "FName", "LName", LocalDateTime.parse("2008-01-22T03:05:11"), Role.ADMIN)
        assertEquals(user, userFromCSV)
    }
}