package com.example

import com.example.generator.UserGenerator

fun main(args: Array<String>) {
    val users = UserGenerator.generate(10)
    println(users)
}