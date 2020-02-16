package ch.tinyknightofcoding.gol.gui

import ch.tinyknightofcoding.gol.core.GameOfLife
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

class SetupGameOfLifeView(private val stage: Stage) {

  private var size = 16

  private val group = Group().apply {
    children += VBox().apply {
      children += Label("Size")
      children += HBox().apply {
        val sizeToggleGroup = ToggleGroup()
        children += RadioButton("16").apply {
          userData = 16
          isSelected = size == 16
          toggleGroup = sizeToggleGroup
        }
        children += RadioButton("32").apply {
          userData = 32
          isSelected = size == 32
          toggleGroup = sizeToggleGroup
        }
        children += RadioButton("48").apply {
          userData = 48
          isSelected = size == 48
          toggleGroup = sizeToggleGroup
        }
        sizeToggleGroup.selectedToggleProperty().addListener { ov, _, _ ->
          size = ov.value.userData as Int
        }
      }
      children += Button("Create").apply {
        onMouseClicked = EventHandler<MouseEvent> { create() }
      }

    }
  }

  init {
    stage.scene.root = group
    stage.sizeToScene()
    stage.centerOnScreen()
  }

  private fun create() {
    GameOfLifeView(stage, GameOfLife(size))
  }
}
