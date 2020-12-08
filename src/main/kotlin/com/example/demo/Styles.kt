package com.example.demo

import javafx.scene.paint.Color
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val menuButton by cssclass()
        val menuButtonHover by cssclass()
        val lifeClass by cssclass()
        val livingLifeClass by cssclass()
        val lifeGrid by cssclass()
    }

    init {
        menuButton {
            backgroundColor  += c("#aaaaaa")
            fontFamily = "Comic Sans MS"
            and(hover) {
                backgroundColor  += c("#dddddd")
            }
            and(pressed) {
               textFill = c("white")
            }
        }

        menuButtonHover {
            backgroundColor  += c("#dddddd")
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
    }
}
