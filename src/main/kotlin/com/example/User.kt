package com.example

import java.util.*

data class User(val id: Int, val fname: String, val lname: String, val dateOfBirth: Date, val role: Role) {
}

enum class Role(name: String) {
    USER("user"),
    ADMIN( "admin")
}