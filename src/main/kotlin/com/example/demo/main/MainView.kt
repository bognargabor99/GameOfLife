package com.example.demo.main

import com.example.demo.Styles
import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Orientation
import javafx.util.converter.NumberStringConverter
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    private val controller: MainController by inject()
    private var userName: String = ""
    private var userPsw: String = ""

    private val model = object : ViewModel() {
        val counter = SimpleIntegerProperty()
    }

    override val root = form {
        fieldset("Login", labelPosition = Orientation.VERTICAL) {
            field("Username") {
                textfield(userName)
            }
            field("Password") {
                passwordfield(userPsw)
            }
            buttonbar {
                button("Log in") {

                }
            }
        }
    }
}
