package ch.tinyknightofcoding.gol.gui

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.stage.Stage

fun main() {
  Application.launch(App::class.java)
}

class App : Application() {

  override fun start(primaryStage: Stage) {
    primaryStage.apply {
      title = "Game of Life"
      primaryStage.scene = Scene(Group())
      SetupGameOfLifeView(primaryStage)
      primaryStage.isResizable = false
      show()
    }
  }
}
