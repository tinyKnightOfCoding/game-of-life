package ch.tinyknightofcoding.gol.core

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isFalse
import strikt.assertions.isTrue

class GameOfLifeDeadCellTest {
  @Test fun `dead cell is born given three neighbours`() {
    expectThat(GameOfLife(3).withAliveAt(0, 1).withAliveAt(1, 2).withAliveAt(0, 2).nextGeneration()) {
      get { isAlive(1, 1) }.isTrue()
    }
  }

  @Test fun `dead cell stays dead given zero neighbours`() {
    expectThat(GameOfLife(3).nextGeneration()) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test fun `dead cell stays dead given one neighbour`() {
    expectThat(GameOfLife(3).withAliveAt(0, 0).nextGeneration()) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test fun `dead cell stays dead given two neighbours`() {
    expectThat(GameOfLife(3).withAliveAt(0, 0).withAliveAt(2, 2).nextGeneration()) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test fun `dead cell stays dead given four neighbours`() {
    expectThat(
      GameOfLife(3)
        .withAliveAt(0, 0)
        .withAliveAt(2, 2)
        .withAliveAt(0, 2)
        .withAliveAt(2, 0)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test fun `dead cell stays dead given five neighbours`() {
    expectThat(
      GameOfLife(3)
        .withAliveAt(0, 0)
        .withAliveAt(0, 1)
        .withAliveAt(0, 2)
        .withAliveAt(2, 0)
        .withAliveAt(2, 2)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test fun `dead cell stays dead given six neighbours`() {
    expectThat(
      GameOfLife(3)
        .withAliveAt(0, 0)
        .withAliveAt(0, 1)
        .withAliveAt(0, 2)
        .withAliveAt(1, 0)
        .withAliveAt(2, 0)
        .withAliveAt(2, 2)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test fun `dead cell stays dead given seven neighbours`() {
    expectThat(
      GameOfLife(3)
        .withAliveAt(0, 0)
        .withAliveAt(0, 1)
        .withAliveAt(0, 2)
        .withAliveAt(1, 0)
        .withAliveAt(1, 2)
        .withAliveAt(2, 0)
        .withAliveAt(2, 2)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }

  @Test fun `dead cell stays dead given eight neighbours`() {
    expectThat(
      GameOfLife(3)
        .withAliveAt(0, 0)
        .withAliveAt(0, 1)
        .withAliveAt(0, 2)
        .withAliveAt(1, 0)
        .withAliveAt(1, 2)
        .withAliveAt(2, 0)
        .withAliveAt(2, 1)
        .withAliveAt(2, 2)
        .nextGeneration()
    ) {
      get { isAlive(1, 1) }.isFalse()
    }
  }
}
