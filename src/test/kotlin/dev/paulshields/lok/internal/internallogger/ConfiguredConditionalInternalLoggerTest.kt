package dev.paulshields.lok.internal.internallogger

import assertk.assertThat
import assertk.assertions.isEmpty
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.internalLogIfEqual
import dev.paulshields.lok.internal.internalLogIfNotEqual
import dev.paulshields.lok.internal.internalLogIfNotNull
import dev.paulshields.lok.internal.internalLogIfNull
import dev.paulshields.lok.lokLogLevel
import org.junit.jupiter.api.Test

class ConfiguredConditionalInternalLoggerTest : BaseInternalLoggerTest() {
    @Test
    fun `should not output log line if items are equal if log level is too high`() {
        lokLogLevel = LogLevel.ERROR
        val item1 = 1
        val item2 = 1

        internalLogIfEqual(anyClassName, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output log line if items are not equal if log level is too high`() {
        lokLogLevel = LogLevel.ERROR
        val item1 = 1
        val item2 = 2

        internalLogIfNotEqual(anyClassName, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output log line if item is null if log level is too high`() {
        lokLogLevel = LogLevel.ERROR

        internalLogIfNull(anyClassName, null, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output log line if item is not null if log level is too high`() {
        lokLogLevel = LogLevel.ERROR

        internalLogIfNotNull(anyClassName, 1, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }
}
