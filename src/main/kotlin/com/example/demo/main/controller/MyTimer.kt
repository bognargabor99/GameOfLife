package com.example.demo.main.controller

import javafx.animation.AnimationTimer

class MyTimer(private var delay: Long, val action: (Long) -> Unit) : AnimationTimer() {
    private var ticks = 0

    override fun handle(now: Long) {
        ticks = (ticks + 1) % delay.toInt()
        if (ticks == 0) {
            action(now)
        }
    }
}