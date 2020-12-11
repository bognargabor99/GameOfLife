package com.example.demo.main.view

import tornadofx.*

class MainView : View("Game of Life") {
    override val root = borderpane {
        top(MenuView::class)
        center(BoardView::class)
    }
}