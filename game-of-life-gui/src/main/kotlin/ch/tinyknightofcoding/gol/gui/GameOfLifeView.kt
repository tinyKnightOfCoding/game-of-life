package ch.tinyknightofcoding.gol.gui

import ch.tinyknightofcoding.gol.core.GameOfLife
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.stage.Stage

const val TILE_SIZE = 20.0
const val GRID_LINE_SIZE = 1.0

class GameOfLifeView(stage: Stage, gameOfLife: GameOfLife) {

  private val size = (gameOfLife.size * TILE_SIZE) + ((gameOfLife.size + 1) * GRID_LINE_SIZE)

  private val canvas = Canvas(size, size).apply {
    addEventHandler(MouseEvent.MOUSE_CLICKED) {
      onClick(it)
    }
  }

  private var gameOfLife = gameOfLife
    set(value) {
      field = value
      canvas.graphicsContext2D.render()
    }

  init {
    stage.hide()
    stage.scene.root = Group().apply {
      children += VBox().apply {
        children += canvas
        children += HBox().apply {
          children += Button("Next").apply {
            onMouseClicked = EventHandler<MouseEvent> { next() }
          }
        }
      }
    }
    stage.sizeToScene()
    stage.centerOnScreen()
    canvas.graphicsContext2D.render()
    stage.show()
  }

  private fun GraphicsContext.render() {
    fill = Color.GREY
    fillRect(0.0, 0.0, canvas.width, canvas.height)
    renderGameOfLife()
    renderGrid()
  }

  private fun GraphicsContext.renderGameOfLife() {
    fill = Color.GREEN
    for (x in (0 until gameOfLife.size)) {
      for (y in (0 until gameOfLife.size)) {
        if (gameOfLife.isAlive(x, y))
          fillRect((x * (TILE_SIZE + GRID_LINE_SIZE)), (y * (TILE_SIZE + GRID_LINE_SIZE)), TILE_SIZE, TILE_SIZE)
      }
    }
  }

  private fun GraphicsContext.renderGrid() {
    stroke = Color.BLACK
    for (i in (0..gameOfLife.size)) {
      strokeLine((i * (TILE_SIZE + GRID_LINE_SIZE)), 0.0, (i * (TILE_SIZE + GRID_LINE_SIZE)), size)
      strokeLine(0.0, (i * (TILE_SIZE + GRID_LINE_SIZE)), size, (i * (TILE_SIZE + GRID_LINE_SIZE)))
    }
  }

  private fun onClick(event: MouseEvent) {
    val x = (event.x / (TILE_SIZE + GRID_LINE_SIZE)).toInt()
    val y = (event.y / (TILE_SIZE + GRID_LINE_SIZE)).toInt()
    gameOfLife = when {
      event.button == MouseButton.PRIMARY && gameOfLife.isAlive(x, y) -> gameOfLife.withDeadAt(x, y)
      event.button == MouseButton.PRIMARY && !gameOfLife.isAlive(x, y) -> gameOfLife.withAliveAt(x, y)
      else -> gameOfLife
    }
  }

  private fun next() {
    gameOfLife = gameOfLife.nextGeneration()
  }
}
