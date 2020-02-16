package ch.tinyknightofcoding.gol.core

internal sealed class Cell {
  abstract val isAlive: Boolean
}

internal object AliveCell : Cell() {

  override val isAlive = true
}

internal object DeadCell : Cell() {

  override val isAlive = false
}
