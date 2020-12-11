package com.example.demo.main.view

import com.example.demo.Styles
import com.example.demo.main.controller.MainController
import javafx.geometry.Pos
import javafx.scene.input.MouseEvent
import tornadofx.*

class BoardView : View("Board") {
    private val controller: MainController by inject()

    override val root = hbox {
        alignment = Pos.CENTER

        datagrid(controller.cells) {
            alignment = Pos.TOP_CENTER
            maxRows = controller.size
            maxCellsInRow = controller.size
            prefHeight = controller.size * 20.0
            prefWidth = controller.size * 20.0

            /**
             * I tried to bind maxRows, maxCellsInRow, prefWidth and prefHeight properties,
             * but I could not figure out the proper way to do it,
             * so I added items.onChange method. It's only for resizing the table.
             */
            items.onChange {
                maxRows = controller.size
                maxCellsInRow = controller.size
                prefHeight = controller.size * 20.0
                prefWidth = controller.size * 20.0
            }

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
