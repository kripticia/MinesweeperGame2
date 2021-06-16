package main.logic

data class GridState (val width: Int, val height:Int, var cellContents:Array<Array<Int>>,
                      var cellStates:Array<Array<CellState>> = Array(width){Array(height){ CellState.COVERED }}) {

    enum class CellState {
        COVERED,
        UNCOVERED,
        FLAGGED
    }
}