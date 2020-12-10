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
                        field("Width:") { spinner(5, 30, 10, 1, enableScroll = true, property = widthProperty) {addClass(Styles.menuButton)} }
                        field("Height:") { spinner(5, 30, 10, 1, enableScroll = true, property = heightProperty){addClass(Styles.menuButton)} }
                    }
                }
            }
            button("Start") {
                addClass(Styles.menuButton)
                action {
                    controller.lifeGoesOn = true
                }
            }
            button("Stop") {
                addClass(Styles.menuButton)
                action {
                    controller.lifeGoesOn = false
                }
            }
            button("Step") {
                addClass(Styles.menuButton)
                action {
                    controller.lifeGoesOn = false
                    controller.nextState()
                }
            }
            button("Clear") {
                addClass(Styles.menuButton)
                action {
                    controller.lifeGoesOn = false
                    controller.clear()
                }
            }
        }
    }
}
