package main

import main.logic.CellGrid
import java.awt.*
import javax.swing.*

/*
This file is simply a graphical way to test the GameMap generation.
This is not intended to be the final graphical solution for the project.
*/

class SwingTestWindow (currentMap: CellGrid, frame: JFrame = JFrame("Minesweeper"),
                       private val panel:JPanel = JPanel()){

    init {
        frame.setSize(512, 512+24)
        frame.layout = BorderLayout()
        frame.contentPane.background = Color.BLACK
        frame.isResizable = false
        frame.isVisible = true
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        panel.layout = GridLayout(currentMap.width, currentMap.height)
        frame.add(panel)
        //val cellPanel: GridPanel =
        createUICells(currentMap.cells)
        panel.revalidate()
        panel.repaint()
    }

    private fun createUICells(map: Array<Array<Int>>) {
        val cells = Array(map.size){arrayOfNulls<JLabel>(map[0].size)}
        for (i in map.indices) {
            for (j in map[i].indices) {
                val content = map[i][j]
                cells[i][j] = JLabel(content.toString())
                cells[i][j]?.isOpaque = true
                cells[i][j]?.background = Color.white
                cells[i][j]?.border = BorderFactory.createLineBorder(Color.BLACK, 1)
                cells[i][j]?.horizontalAlignment = SwingConstants.CENTER
                cells[i][j]?.verticalAlignment = SwingConstants.CENTER
                panel.add(cells[i][j])
            }
        }
    }
}