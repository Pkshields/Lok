package dev.paulshields.lok

import assertk.assertThat
import assertk.assertions.isInstanceOf
import org.junit.jupiter.api.Test

class DelegatedLoggerTest {
    @Test
    fun `should create a logger`() {
        val result by logger()

        assertThat(result).isInstanceOf(ClassLogger::class)
    }
}
