package ch.tinyknightofcoding.gol.gui

import ch.tinyknightofcoding.gol.core.GameOfLife
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

val SIZE_OPTIONS = arrayOf(10, 20, 30)

class SetupGameOfLifeView(private val stage: Stage) {

  private var selectedSize = SIZE_OPTIONS[0]

  private val group = Group().apply {
    children += VBox().apply {
      children += HBox().apply {
        alignment = Pos.BASELINE_LEFT
        padding = Insets(4.0, 4.0, 4.0, 4.0)
        children += Label("Size")
        val sizeToggleGroup = ToggleGroup()
        children += SIZE_OPTIONS.map { size ->
          RadioButton("$size").apply {
            userData = size
            isSelected = size == selectedSize
            toggleGroup = sizeToggleGroup
            padding = Insets(4.0, 4.0, 4.0, 4.0)
          }
        }
        sizeToggleGroup.selectedToggleProperty().addListener { ov, _, _ ->
          selectedSize = ov.value.userData as Int
        }
      }
      children += HBox().apply {
        children += Button("Create").apply {
          onMouseClicked = EventHandler<MouseEvent> { create() }
        }
        padding = Insets(4.0, 4.0, 4.0, 4.0)
      }
    }
  }

  init {
    stage.scene.root = group
    stage.sizeToScene()
    stage.centerOnScreen()
  }

  private fun create() {
    GameOfLifeView(stage, GameOfLife(selectedSize))
  }
}
