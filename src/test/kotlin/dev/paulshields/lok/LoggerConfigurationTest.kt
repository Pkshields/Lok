package dev.paulshields.lok

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

/**
 * NOTE: The functionality associated with the logger configuration is tested in the internal.internallogger.Configured tests
 */
class LoggerConfigurationTest {
    @Test
    fun `should default to debug logging`() {
        assertThat(lokLogLevel).isEqualTo(LogLevel.DEBUG)
    }
}
