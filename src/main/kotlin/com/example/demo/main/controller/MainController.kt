package com.example.demo.main.controller

import com.example.demo.main.model.Delay
import com.example.demo.main.model.LifeBoard
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.collections.FXCollections
import tornadofx.Controller
import tornadofx.getValue
import tornadofx.onChange
import tornadofx.setValue

class MainController : Controller() {
    private val board = LifeBoard(16)

    val cells = FXCollections.observableArrayList(board.toList())!!

    private val sizeProperty = SimpleIntegerProperty(16)
    var size by sizeProperty

    private val lifeGoesOnProperty = SimpleBooleanProperty(false)
    var lifeGoesOn by lifeGoesOnProperty

    private val delayProperty = SimpleIntegerProperty(Delay.SLOW.getDelayRate())
    private var delayRate by delayProperty

    private var timer = MyTimer(delayRate) {
        nextState()
    }

    init {
        lifeGoesOnProperty.onChange {
            when {
                it -> timer.start()
                else -> timer.stop()
            }
        }
    }

    fun performClick(x: Int, y: Int) {
        board[x, y] = !board[x, y]
    }

    fun nextState() {
        board.step()
        cells.clear()
        cells.addAll(board.toList())
    }

    fun startNewGame(newSize: Int) {
        board.newGame(newSize)
        size = newSize
        cells.clear()
        cells.addAll(board.toList())
    }

    fun clear() {
        board.clear()
        cells.forEach {
            it.alive = false
        }
    }

    fun updateDelayRate(newDelay: Int) {
        timer.delay = newDelay
    }
}
