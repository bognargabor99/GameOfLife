package com.example.demo.main.model

enum class Delay(private val i: Int) {
    SLOW(75),
    MEDIUM(35),
    FAST(1);

    fun getDelayRate() = i
}