package com.example.generator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals

class UserGeneratorTest {

    @Test
    fun `Test generate`() {
        val users = UserGenerator.generate(5)

        assertNotNull(users)
        assertEquals(5, users.size)

        users.forEach {
            user -> assertNotNull(user)
        }
    }
}
