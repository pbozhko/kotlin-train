package com.example.storage

import com.example.model.User
import java.io.File
import java.io.FileNotFoundException

object CSVManager {
    fun write(users: List<User>, file: String) {
        File(file).printWriter(Charsets.UTF_8).use { out ->
            users.forEach { user ->
                out.println(user.toCSVLine())
            }
        }
    }

    fun read(fileName: String): List<User> {
        val users = ArrayList<User>()
        val file = File(fileName)
        if(!file.exists()) {
            throw FileNotFoundException()
        }
        file.readLines(Charsets.UTF_8).forEach {
            line -> users.add(User.fromCSVLine(line))
        }
        return users
    }
}