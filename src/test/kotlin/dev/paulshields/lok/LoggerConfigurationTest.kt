package dev.paulshields.lok

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class LoggerConfigurationTest {
    @Test
    fun `should default to debug logging`() {
        assertThat(lokLogLevel).isEqualTo(LogLevel.DEBUG)
    }
}
