package com.example

import java.util.*

class UserGenerator {
    companion object {
        fun generate(count: Int): List<User> {
            val users = ArrayList<User>()
            for (i in 0..count) {
                val user = User(i, i.toString(), i.toString(), Date(), Role.ADMIN)
                users.add(user)
            }
            return users
        }
    }
}