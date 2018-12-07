package com.example.generator

import com.example.generator.reader.FileReader
import com.example.model.Role
import com.example.model.User
import java.time.LocalDateTime
import java.util.*

object UserGenerator {

    val ids = ArrayList<Int>()

    fun generate(count: Int): List<User> {

        val users = ArrayList<User>()

        val fNames = FileReader.readRandomFNames(count)
        val lNames = FileReader.readRandomLNames(count)

        for (i in 0..(count - 1)) {
            val user = User(this.getRandomId(count), fNames.get(i), lNames.get(i), this.getRandomDateOfBirth(), this.getRandomRole())
            users.add(user)
        }

        return users
    }

    private fun getRandomId(count: Int): Int {

        var id: Int

        do {
            id = (1..count).random()
        } while (ids.contains(id))

        ids.add(id)

        return id
    }

    private fun getRandomDateOfBirth(): LocalDateTime {
        val year = (1900..2018).random()
        val month = (1..12).random()
        val day = (1..(if (intArrayOf(1, 3, 5, 7, 8, 10, 12).contains(month)) 31 else 30)).random()
        val hours = (0..23).random()
        val minutes = (0..23).random()
        val seconds = (0..23).random()

        return LocalDateTime.of(year, month, day, hours, minutes, seconds)
    }

    private fun getRandomRole(): Role {
        val isAdmin = (0..1).random()
        return if (isAdmin == 1) Role.ADMIN else Role.USER
    }

    private fun IntRange.random(): Int = Random().nextInt((endInclusive + 1) - start) + start
}