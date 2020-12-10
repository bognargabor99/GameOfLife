package com.example.demo.main.controller

import javafx.animation.AnimationTimer

class MyTimer(var delay: Long, val action: (Long) -> Unit) : AnimationTimer() {
    var ticks = 0

    override fun handle(now: Long) {
        ticks = (ticks + 1) % delay.toInt()
        if (ticks == 0)
            action(now)
    }
}