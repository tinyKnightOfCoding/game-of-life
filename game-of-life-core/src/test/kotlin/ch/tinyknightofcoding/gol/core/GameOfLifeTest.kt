package ch.tinyknightofcoding.gol.core

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isEqualTo

internal class GameOfLifeTest {

  @ParameterizedTest
  @ValueSource(ints = [1, 2, 4, 5, 10])
  fun create(givenSize: Int) {
    expectThat(GameOfLife(givenSize)) {
      get { size }.isEqualTo(givenSize)
    }
  }

  @ParameterizedTest
  @ValueSource(ints = [0, -1, -2, -5 - 10, Int.MIN_VALUE])
  fun create_Throws(givenSize: Int) {
    expectThrows<IllegalArgumentException> { GameOfLife(givenSize) }
  }
}
