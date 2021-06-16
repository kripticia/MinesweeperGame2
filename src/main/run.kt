package main

import main.data.GameMap
import main.graphics.SwingTestWindow

fun main() {
    val currentMap = GameMap()
    currentMap.createNewMap(16,16,32)
    SwingTestWindow(currentMap)
}