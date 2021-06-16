package main.render

import main.logic.CellGrid
import main.logic.GridState

class MainWindow {
    private var window:Long = 0

    fun run(gridW:Int, gridH:Int, gridM:Int) {
        val grid = CellGrid()
        grid.createNewCells(gridW, gridH, gridM)
        GridState(grid.width, grid.height, grid.cells)
    }
}