package com.example

import com.example.generator.UserGenerator
import com.example.storage.CSVManager

fun main(args: Array<String>) {
    //val users = UserGenerator.generate(10)
    //CSVManager.write(users)
    val users = CSVManager.read()
    println(users)
}