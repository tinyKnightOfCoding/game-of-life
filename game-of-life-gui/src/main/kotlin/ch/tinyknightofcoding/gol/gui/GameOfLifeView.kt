package ch.tinyknightofcoding.gol.gui

import ch.tinyknightofcoding.gol.core.GameOfLife
import javafx.scene.Group
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import javafx.stage.Stage

const val TILE_SIZE = 20.0
const val GRID_LINE_SIZE = 1.0

class GameOfLifeView(stage: Stage, private val gameOfLife: GameOfLife) {

  private val size = (gameOfLife.size * TILE_SIZE) + ((gameOfLife.size + 1) * GRID_LINE_SIZE)

  private val canvas = Canvas(size, size)

  init {
    stage.scene.root = Group().apply {
      children += canvas
    }
    stage.hide()
    stage.sizeToScene()
    stage.centerOnScreen()
    canvas.graphicsContext2D.render()
    stage.show()
  }

  private fun GraphicsContext.render() {
    fill = Color.GREY
    fillRect(0.0, 0.0, canvas.width, canvas.height)
    renderGrid()
  }

  private fun GraphicsContext.renderGrid() {
    stroke = Color.BLACK
    for (i in (0..gameOfLife.size)) {
        strokeLine((i * (TILE_SIZE + GRID_LINE_SIZE)), 0.0, (i * (TILE_SIZE + GRID_LINE_SIZE)), size)
        strokeLine(0.0, (i * (TILE_SIZE + GRID_LINE_SIZE)), size, (i * (TILE_SIZE + GRID_LINE_SIZE)))
    }
  }

}
