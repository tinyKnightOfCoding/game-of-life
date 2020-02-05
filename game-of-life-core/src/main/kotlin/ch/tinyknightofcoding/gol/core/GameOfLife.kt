package ch.tinyknightofcoding.gol.core

class GameOfLife(val size: Int) {

  init {
    if(size < 1) throw IllegalArgumentException("size must be strictly positive")
  }
}
