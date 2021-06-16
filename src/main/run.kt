package main

import main.logic.CellGrid

fun main() {
    val currentMap = CellGrid()
    currentMap.createNewCells(16,16,32)
    SwingTestWindow(currentMap)
}
