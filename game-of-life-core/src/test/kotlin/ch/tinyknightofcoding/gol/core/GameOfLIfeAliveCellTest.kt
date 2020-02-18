package ch.tinyknightofcoding.gol.core

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isFalse
import strikt.assertions.isTrue

class GameOfLIfeAliveCellTest {

  @Test fun `alive cell survives given three neighbours`() {
    expectThat(GameOfLife(3).withAliveAt(0, 0).withAliveAt(1, 0).withAliveAt(0, 1).withAliveAt(1, 1).nextGeneration()) {
      get { isAlive(1, 1) }.isTrue()
    }
    expectThat(GameOfLife(3).withAliveAt(1, 0).withAliveAt(1, 2).withAliveAt(0, 1).withAliveAt(1, 1).nextGeneration()) {
      get { isAlive(1, 1) }.isTrue()
    }
  }

  @Test fun `alive cell survives given two neighbours vertical`() {
    expectThat(GameOfLife(3).withAliveAt(1, 1).withAliveAt(1, 2).withAliveAt(1, 0).nextGeneration()) {
      get { isAlive(1, 1) }.isTrue()
    }
  }

  @Test fun `alive cell dies given two neighbours horizontal`() {
    expectThat(GameOfLife(3).withAliveAt(1, 1).withAliveAt(0, 1).withAliveAt(2, 1).nextGeneration()) {
      get { isAlive(1, 1) }.isTrue()
    }
  }

  @Test fun `alive cell dies given one neighbour to left`() {
    expectThat(GameOfLife(3).withAliveAt(1, 1).withAliveAt(0, 1).nextGeneration()) {
      get { isAlive(1, 1) }.isFalse()
      get { isAlive(0, 1) }.isFalse()
    }
  }

  @Test fun `alive cell dies given one neighbour diagonally`() {
    expectThat(GameOfLife(3).withAliveAt(1, 1).withAliveAt(0, 0).nextGeneration()) {
      get { isAlive(1, 1) }.isFalse()
      get { isAlive(0, 0) }.isFalse()
    }
  }

  @Test fun `alive cell dies given no neighbour`() {
    expectThat(GameOfLife(3).withAliveAt(1, 1).nextGeneration()) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test
  fun `alive cell dies given four neighbours`() {
    expectThat(
      GameOfLife(3).withAliveAt(1, 1)
        .withAliveAt(0, 0)
        .withAliveAt(2, 2)
        .withAliveAt(0, 2)
        .withAliveAt(2, 0)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test
  fun `alive cell dies given five neighbours`() {
    expectThat(
      GameOfLife(3)
        .withAliveAt(1, 1)
        .withAliveAt(0, 0)
        .withAliveAt(2, 2)
        .withAliveAt(0, 2)
        .withAliveAt(2, 0)
        .withAliveAt(1, 2)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test
  fun `alive cell dies given six neighbours`() {
    expectThat(
      GameOfLife(3)
        .withAliveAt(1, 1)
        .withAliveAt(0, 0)
        .withAliveAt(2, 2)
        .withAliveAt(0, 2)
        .withAliveAt(2, 1)
        .withAliveAt(1, 2)
        .withAliveAt(0, 1)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test
  fun `alive cell dies given seven neighbours`() {
    expectThat(
      GameOfLife(3)
        .withAliveAt(1, 1)
        .withAliveAt(0, 0)
        .withAliveAt(2, 2)
        .withAliveAt(0, 2)
        .withAliveAt(2, 1)
        .withAliveAt(1, 2)
        .withAliveAt(0, 1)
        .withAliveAt(1, 0)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test
  fun `alive cell dies given eight neighbours`() {
    expectThat(
      GameOfLife(3)
        .withAliveAt(1, 1)
        .withAliveAt(0, 0)
        .withAliveAt(2, 2)
        .withAliveAt(0, 2)
        .withAliveAt(2, 1)
        .withAliveAt(1, 2)
        .withAliveAt(0, 1)
        .withAliveAt(1, 0)
        .withAliveAt(2, 0)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

}
