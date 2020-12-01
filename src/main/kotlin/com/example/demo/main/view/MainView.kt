package com.example.demo.main.view

import com.example.demo.main.controller.MainController
import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.paint.Color
import tornadofx.*
import kotlin.concurrent.timer

class MainView : View("Hello TornadoFX") {
    private val controller: MainController by inject()
    val rows = SimpleIntegerProperty(20)
    val columns = SimpleIntegerProperty(20)

    override val root = vbox{
        hbox {
            button("Start") { }
            timer("Timer", true, 0, 500) {

            }

        }
        gridpane {

        for (i in 0 until rows.value)
            row {
                for (j in 0 until columns.value)
                    rectangle(width = 15.0, height =  15.0) {
                        fill = Color.TRANSPARENT
                        stroke = Color.GRAY
                        onLeftClick {
                            fill = if (fill==Color.BLACK) {Color.TRANSPARENT} else {Color.BLACK}
                        }
                    }
            }
        }
    }
}