package com.example.demo

import javafx.scene.paint.Color
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val menuButton by cssclass()
        val lifeClass by cssclass()
        val livingLifeClass by cssclass()
        val lifeGrid by cssclass()
        val spinner by cssclass()
    }

    init {
        menuButton {
            backgroundColor  += c("#aaaaaa")
            fontFamily = "Comic Sans MS"
            //startMargin = 10.px
            //endMargin = 10.px
            labelPadding = box(3.px)
            and(hover) {
                backgroundColor  += c("#dddddd")
            }
            and(pressed) {
               textFill = c("white")
            }
        }

        lifeClass {
            backgroundColor += c("#dddddd")
            borderColor += box(Color.BLACK)
        }

        livingLifeClass {
            backgroundColor += c("#333333")
            borderColor += box(Color.BLACK)
        }

        lifeGrid {
            cellWidth = 20.px
            cellHeight = 20.px
            verticalCellSpacing = 1.px
            horizontalCellSpacing = 1.px
            backgroundColor += c("#ddd")
        }

        spinner {
            maxWidth = 60.px
        }
    }
}
