package com.example.model

import java.time.LocalDateTime

data class User(val id: Int, val fname: String, val lname: String, val dateOfBirth: LocalDateTime, val role: Role) {
    fun toCSVLine(): String {
        return String.format("%d,%s,%s,%s,%s", this.id, this.fname, this.lname, this.dateOfBirth, this.role)
    }

    companion object {
        fun fromCSVLine(line: String): User {
            val args = line.split(",")
            val user = User(args[0].trim().toInt(), args[1].trim(), args[2].trim(), LocalDateTime.parse(args[3].trim()), Role.valueOf(args[4].trim()))
            return user
        }
    }
}

enum class Role {
    USER,
    ADMIN
}