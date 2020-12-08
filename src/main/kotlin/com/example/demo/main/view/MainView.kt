package com.example.demo.main.view

import tornadofx.*

class MainView : View("Game of Life") {
    override val root = borderpane {
        center(BoardView::class)
        top(MenuView::class)
    }
}