package com.example.demo.main.view

import com.example.demo.Styles
import com.example.demo.main.controller.MainController
import com.example.demo.main.model.toInt
import javafx.geometry.Pos
import javafx.scene.input.MouseEvent
import tornadofx.*

class BoardView : View("Board") {
    private val controller: MainController by inject()

    override val root = hbox {
        alignment = Pos.CENTER

        datagrid(controller.cells) {
            alignment = Pos.CENTER
            maxCellsInRow = controller.rows
            maxRows = controller.columns
            prefHeight = controller.columns * 22.0
            prefWidth = controller.rows * 22.0
            usePrefSize = true
            addClass(Styles.lifeGrid)

            cellCache { cell ->
                pane {
                    addClass(Styles.lifeClass)
                    toggleClass(Styles.livingLifeClass, cell.aliveProperty)

                    addEventHandler(MouseEvent.MOUSE_CLICKED) {
                        controller.performClick(cell.x, cell.y)
                    }

                }
            }
        }
    }
}
