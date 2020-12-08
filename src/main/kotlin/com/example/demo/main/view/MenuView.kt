package com.example.demo.main.view

import com.example.demo.Styles
import com.example.demo.main.controller.MainController
import javafx.beans.property.SimpleIntegerProperty
import tornadofx.*

class MenuView : View("Menu") {
    private val controller: MainController by inject()
    private val widthProperty = SimpleIntegerProperty(20)
    private var widthSet by widthProperty
    private val heightProperty = SimpleIntegerProperty(20)
    private var heightSet by heightProperty


    override val root = form {

        hbox(spacing = 10.0) {
             fieldset {
                 hbox(spacing = 10.0) {
                    button("New Game") {
                        addClass(Styles.menuButton)
                        controller.rows = widthSet
                        controller.columns = heightSet
                    }
                    vbox {
                        field("Width:") { spinner(10, 30, 20, 1, property = widthProperty) }
                        field("Height:") { spinner(10, 30, 20, 1, property = heightProperty) }
                    }
                }
            }
            button("Start") {
                addClass(Styles.menuButton)
                //TODO("Timer start")
            }
            button("Stop") {
                addClass(Styles.menuButton)
                //TODO("Timer stop")
            }
            button("Step") {
                addClass(Styles.menuButton)
                action { controller.nextState() }
                //TODO("Timer stop")
            }
            button("Clear") {
                addClass(Styles.menuButton)
                action { controller.clear() }
            }
        }
    }
}
