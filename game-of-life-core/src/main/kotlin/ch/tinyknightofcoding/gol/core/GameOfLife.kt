package ch.tinyknightofcoding.gol.core

class GameOfLife private constructor(private val cells: List<List<Cell>>) {

  constructor(size: Int) : this((0 until size).map { _ -> (0 until size).map { DeadCell } })

  init {
    if (size < 1) throw IllegalArgumentException("size must be strictly positive")
  }

  val size: Int get() = cells.size

  fun isAlive(x: Int, y: Int) = cells[x][y].isAlive

  fun withAliveAt(x: Int, y: Int) = GameOfLife(cells.mapIndexed { _x, col -> col.mapIndexed { _y, cell -> if (x == _x && y == _y) AliveCell else cell } })

  fun withDeadAt(x: Int, y: Int) = GameOfLife(cells.mapIndexed { _x, col -> col.mapIndexed { _y, cell -> if (x == _x && y == _y) DeadCell else cell } })
}
