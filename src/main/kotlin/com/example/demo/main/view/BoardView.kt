package com.example.demo.main.view

import com.example.demo.Styles
import com.example.demo.main.controller.MainController
import javafx.geometry.Pos
import javafx.scene.input.MouseEvent
import tornadofx.*

class BoardView : View("Board") {
    private val controller: MainController by inject()

    val numbers = listOf(1, 2, 3, 4, 5, 6)

    override val root = hbox {
        alignment = Pos.CENTER

        datagrid(controller.cells) {
            maxCellsInRow = controller.rows
            maxRows = controller.columns
            prefHeight = controller.rows * 20.0
            prefWidth = controller.columns * 20.0
            usePrefSize = true
            addClass(Styles.lifeGrid)

            cellCache { cell ->
                pane {
                    useMaxSize = true
                    addClass(Styles.lifeClass)
                    toggleClass(Styles.livingLifeClass, cell.aliveProperty)
                    /*text("${cell.x}, ${cell.y}") {
                        autosize()
                    }*/
                    addEventHandler(MouseEvent.MOUSE_CLICKED) {
                        controller.performClick(cell.x, cell.y)
                        println("Oh shit!")
                    }

                }
            }
        }
    }
}
