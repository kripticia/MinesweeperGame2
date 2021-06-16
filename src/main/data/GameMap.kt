package main.data

import kotlin.random.Random

data class GameMap (var width:Int = 0, var height:Int = 0, var mines:Int = 0,
                    var map:Array<Array<String>> = Array(0){Array(0){""} }) {
    fun createNewMap(newW:Int, newH:Int, newM:Int) {
        // Set attributes to entered parameters
        width = newW
        height = newH
        mines = newM

        /* Create 2D array of empty cells (str "empty", not actually null/empty)
        Largest array holds columns, sub-arrays hold the cells for each column, and each cell is a
        pair with (first) a cell's content and (second) whether it is checked, flagged or unchecked */
        val newMap = Array(width){Array(height){""}}

        // Place mines into the map
        // First pair of coords before iteration
        var xPlace:Int = Random.nextInt(1,width)
        var yPlace:Int = Random.nextInt(1,height)
        for (x in 1..newM) {
            // Don't allow mines to be placed on the same cells
            while (newMap[xPlace][yPlace] == "mine") {
                xPlace = Random.nextInt(1,width)
                yPlace = Random.nextInt(1,height)
            }
            newMap[xPlace][yPlace] = "mine"
        }

        // Edit tiles near mines to give numbers
        for (cellX in 0 until width) {
            for (cellY in 0 until height) {
                val cell = newMap[cellX][cellY]
                // Skip if cell is a mine
                if (cell == "mine") {continue}

                var mineCount = 0
                // Iterate through x coords (columns)
                for (i:Int in -1..1){
                    val xCheck = cellX + i
                    // Skip if x index is out of range
                    if (xCheck !in 0 until width) {continue}
                    // Iterate through y coords (cells in columns)
                    for (j in -1..1){
                        val yCheck = cellY + j
                        // Skip if y index is out of range
                        if (yCheck !in 0 until height) {continue}
                        val cellToCheck = newMap[xCheck][yCheck]

                        // Check tile for mine, add count if present
                        if (cellToCheck == "mine") {mineCount += 1}
                    }
                }
                // Set the tile to its adjacent mine count,
                // or skip if no mines are adjacent
                if (mineCount == 0) {continue}
                newMap[cellX][cellY] = mineCount.toString()
            }
        }

        // Set object's map attribute after map generation
        map = newMap
    }
}