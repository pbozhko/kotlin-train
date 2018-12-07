package com.example.storage

import com.example.model.User
import java.io.File

object CSVManager {
    fun write(users: List<User>) {
        File("users.csv").printWriter(Charsets.UTF_8).use { out ->
            users.forEach { user ->
                out.println(user.toCSVLine())
            }
        }
    }

    fun read(): List<User> {
        val users = ArrayList<User>()
        File("users.csv").readLines(Charsets.UTF_8).forEach {
            line -> users.add(User.fromCSVLine(line))
        }
        return users
    }
}