package com.example.demo

import com.sun.prism.Image
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val imageViewBlack by cssclass()
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.EXTRA_LIGHT
            fontStyle = FontPosture.ITALIC
        }

        imageViewBlack {
            //backgroundColor +=
        }
    }
}
