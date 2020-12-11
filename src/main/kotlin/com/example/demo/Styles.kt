package com.example.demo

import javafx.scene.paint.Color
import javafx.scene.text.FontPosture
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val menuButton by cssclass()
        val lifeClass by cssclass()
        val textClass by cssclass()
        val livingLifeClass by cssclass()
        val lifeGrid by cssclass()
        val spinner by cssclass()
    }

    init {
        menuButton {
            backgroundColor  += c("#aaaaaa")
            labelPadding = box(3.px)
            and(hover) {
                backgroundColor  += c("#dddddd")
            }
            and(pressed) {
               textFill = c("white")
            }
            and(selected) {
                backgroundColor  += c("#888888")
                textFill = c("#dddddd")
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
            cellWidth = 18.px
            cellHeight = 18.px
            verticalCellSpacing = 1.px
            horizontalCellSpacing = 1.px
            backgroundColor += c("transparent")
        }

        spinner {
            maxWidth = 60.px
        }

        textClass {
            fontFamily = "Comic Sans MS"
            fontStyle = FontPosture.ITALIC
        }
    }
}
