package com.example.demo.main.model


class LifeBoard(private var n: Int) {
    private var board = MutableList(n) { x -> MutableList(n) { y -> Cell(x, y) } }

    operator fun get(x: Int, y: Int) =
        if (x in 0 until n && y in 0 until n) board[x][y].alive
        else false

    operator fun set(x: Int, y: Int, value: Boolean) {
        if (x in 0 until n && y in 0 until n) board[x][y].alive = value
    }

    fun newGame(newN: Int) {
        n = newN
        board.clear()
        board.addAll(newBoard())
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

    private fun newBoard() = MutableList(n) { x -> MutableList(n) { y -> Cell(x, y) } }

    fun step() {
        val newBoard = newBoard()
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