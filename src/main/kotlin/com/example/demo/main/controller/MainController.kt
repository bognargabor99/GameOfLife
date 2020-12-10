package com.example.demo.main.controller

import com.example.demo.main.model.LifeBoard
import javafx.application.Platform
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleLongProperty
import javafx.collections.FXCollections
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tornadofx.*

class MainController : Controller() {
    var board = LifeBoard(20, 20)
        set(value) {
            cells.clear()
            cells.addAll(value.toList())
            field = value
        }

    val cells = FXCollections.observableArrayList(board.toList())

    val lifeGoesOnProperty = SimpleBooleanProperty(false)
    var lifeGoesOn by lifeGoesOnProperty

    val delayProperty = SimpleLongProperty(10)
    var delayRate by delayProperty

    var timer = MyTimer(delayRate) {
        nextState()
    }

    init {
        lifeGoesOnProperty.onChange {
            if (it) {
                    GlobalScope.launch(Dispatchers.Main) {
                        while (lifeGoesOn) {
                            nextState()
                            delay(1000)
                        }
                    }
            }
            /*when {
                it -> timer.start()
                else -> timer.stop()
            }*/
        }
    }

    var rows = board.height
        get() = board.height
        set(value) {
            field = value
            board = LifeBoard(columns, rows)
            cells.clear()
            cells.addAll(board.toList())
        }
    var columns = board.width
        get() = board.width
        set(value) {
            field = value
            board = LifeBoard(columns, rows)
            cells.clear()
            cells.addAll(board.toList())
        }

    fun performClick(x: Int, y: Int) {
        board[x, y] = !board[x, y]
    }

    fun nextState() {
        cells.clear()
        cells.addAll(board.toList())
        board.step()
    }

    fun clear() {
        board.clear()
        cells.forEach {
            it.alive = false
        }
    }
}
