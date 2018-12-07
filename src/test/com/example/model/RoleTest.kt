package com.example.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class RoleTest {

    @Test
    fun `Test valueOf`() {
        assertEquals(Role.ADMIN, Role.valueOf("ADMIN"))
        assertEquals(Role.USER, Role.valueOf("USER"))
    }
}