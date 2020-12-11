package com.example.demo.main.controller

import javafx.animation.AnimationTimer

class MyTimer(var delay: Int, val action: () -> Unit) : AnimationTimer() {
    private var ticks = 0

    override fun handle(now: Long) {
        ticks = (ticks + 1) % delay
        if (ticks == 0) {
            action()
        }
    }
}