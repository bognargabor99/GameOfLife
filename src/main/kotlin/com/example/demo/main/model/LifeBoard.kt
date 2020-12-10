package com.example.demo.main.model

class LifeBoard(val width: Int, val height: Int) {
    var board: MutableList<MutableList<Cell>> = MutableList(width) { x -> MutableList(height) { y -> Cell(x, y) } }

    operator fun get(x: Int, y: Int) : Boolean =
        if (x in 0 until width && y in 0 until height) board[x][y].alive
        else false

    operator fun set(x: Int, y: Int, value: Boolean) {
        if (x in 0 until width && y in 0 until height) board[x][y].alive = value
    }

    private fun neighboursCount(x: Int, y: Int) =
        this[x - 1, y - 1].toInt() +
        this[x - 1, y    ].toInt() +
        this[x - 1, y + 1].toInt() +
        this[x    , y - 1].toInt() +
        this[x    , y + 1].toInt() +
        this[x + 1, y - 1].toInt() +
        this[x + 1, y    ].toInt() +
        this[x + 1, y + 1].toInt()

    private fun copyBoard(): MutableList<MutableList<Cell>> = MutableList(width) { x -> MutableList(height) { y -> Cell(x, y) } }

    fun step() {
        val newBoard = copyBoard()
        newBoard.indices.forEach { i ->
            newBoard[i].indices.forEach { j ->
                val count = neighboursCount(i, j)
                newBoard[i][j].alive = when (this[i, j]) {
                    true -> count in 2..3
                    false -> count == 3
                }
            }
        }
        board = newBoard
    }

    fun clear() {
        board.forEach {
            it.forEach { cell ->
                cell.alive = false
            }
        }
    }

    fun toList() = board.flatten()
}

fun Boolean.toInt() = if (this) 1 else 0