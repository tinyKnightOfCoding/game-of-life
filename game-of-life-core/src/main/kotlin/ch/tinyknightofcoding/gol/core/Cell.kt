package ch.tinyknightofcoding.gol.core

internal sealed class Cell {
  abstract val isAlive: Boolean

  abstract fun nextGeneration(neighbours: List<Cell>): Cell
}

internal object AliveCell : Cell() {

  override val isAlive = true

  override fun nextGeneration(neighbours: List<Cell>) = if (neighbours.count { it.isAlive } in (2..3)) AliveCell else DeadCell
}

internal object DeadCell : Cell() {

  override val isAlive = false

  override fun nextGeneration(neighbours: List<Cell>) = if (neighbours.count { it.isAlive } == 3) AliveCell else DeadCell
}
