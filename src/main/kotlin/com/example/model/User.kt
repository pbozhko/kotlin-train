package com.example.model

import java.time.LocalDateTime

data class User(val id: Int, val fname: String, val lname: String, val dateOfBirth: LocalDateTime, val role: Role) {
}

enum class Role {
    USER,
    ADMIN
}