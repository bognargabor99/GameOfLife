package com.example.demo.main.controller

import com.example.demo.main.model.Cell
import com.example.demo.main.model.LifeBoard
import javafx.collections.FXCollections
import tornadofx.*

class MainController : Controller() {
    var board = LifeBoard(20, 20)
        set(value) {
            cells.clear()
            cells.addAll(value.toList())
            field = value
        }

    val cells = FXCollections.observableArrayList(board.toList())

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
        board.step()
        cells.clear()
        cells.addAll(board.toList())
    }

    fun clear() {
        board.clear()
        cells.forEach {
            it.alive = false
        }
    }
}
