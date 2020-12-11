package com.example.demo.main.view

import com.example.demo.Styles
import com.example.demo.main.controller.MainController
import com.example.demo.main.model.Delay
import javafx.application.Platform
import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Pos
import javafx.scene.control.Alert
import tornadofx.*

class MenuView : View("Menu") {
    private val controller: MainController by inject()
    private val sizeSetProperty = SimpleIntegerProperty(16)
    private var sizeSet by sizeSetProperty

    override val root = form {
        hbox(spacing = 10.0) {
             fieldset {
                 vbox(spacing = 10.0) {
                     button("New Game") {
                         addClass(Styles.menuButton, Styles.textClass)
                         action {
                             controller.lifeGoesOn = false
                             controller.startNewGame(sizeSet)
                         }
                     }
                     field("Size:") {
                         addClass(Styles.textClass)
                         spinner(5,20, enableScroll = true, property = sizeSetProperty)
                     }
                }
            }
            vbox(spacing = 10.0) {
                alignment = Pos.TOP_CENTER
                button("Start") {
                    addClass(Styles.menuButton, Styles.textClass)
                    action {
                        controller.lifeGoesOn = true
                    }
                }
                button("Pause") {
                    addClass(Styles.menuButton, Styles.textClass)
                    action {
                        controller.lifeGoesOn = false
                    }
                }
            }
            vbox(spacing = 10.0) {
                alignment = Pos.TOP_CENTER
                button("Step") {
                    addClass(Styles.menuButton, Styles.textClass)
                    action {
                        controller.lifeGoesOn = false
                        controller.nextState()
                    }
                }
                button("Clear") {
                    addClass(Styles.menuButton, Styles.textClass)
                    action {
                        controller.lifeGoesOn = false
                        controller.clear()
                    }
                }
            }
            vbox(spacing = 10.0) {
                alignment = Pos.TOP_CENTER
                button("How to") {
                    addClass(Styles.menuButton, Styles.textClass)
                    action {
                        alert.show()
                    }
                }

                fieldset {
                    field("Speed:") {
                        addClass(Styles.textClass)
                        togglegroup {
                            for (d in 0..2)
                                togglebutton(Delay.values()[d].name) {
                                    addClass(Styles.menuButton)
                                    action {
                                        controller.updateDelayRate(Delay.values()[d].getDelayRate())
                                    }
                                }
                        }
                    }
                }
            }
        }


        shortcut("P") { // Pause
            controller.lifeGoesOn = false
        }

        shortcut("R") { // Resume
            controller.lifeGoesOn = true
        }

        shortcut("D") { // Delete, Clear
            controller.clear()
        }

        shortcut("Q") { // Quit
            Platform.exit()
        }
    }

    companion object {
        private val alert = Alert(Alert.AlertType.INFORMATION).apply {
            title = "How to"
            headerText = """
                |Revive cells by clicking on them.
                |To resize the board set the new size on the spinner and click 'New Game'.
                |The other buttons have pretty straightforward behaviour.
                """.trimMargin()
            contentText = """
                |Shortcuts:
                |R: Start/Resume simulation
                |P: Pause simulation
                |D: Clear map
                |Q: Quit
                """.trimMargin()
        }
    }
}
