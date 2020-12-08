package com.example.demo.main.model

import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class Cell(val x: Int, val y: Int) {
    val aliveProperty = SimpleBooleanProperty()
    var alive by aliveProperty
}