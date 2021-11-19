package dev.paulshields.lok.internal.internallogger

import assertk.assertThat
import assertk.assertions.isEmpty
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.internalLogException
import dev.paulshields.lok.internal.internalLogMessage
import dev.paulshields.lok.lokLogLevel
import org.junit.jupiter.api.Test

class ConfiguredStandardInternalLoggerTest : BaseInternalLoggerTest() {
    @Test
    fun `should not output trace message to stdout if log level is too high`() {
        lokLogLevel = LogLevel.DEBUG

        internalLogMessage(anyClassName, LogLevel.TRACE, message)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output debug message to stdout if log level is too high`() {
        lokLogLevel = LogLevel.INFO

        internalLogMessage(anyClassName, LogLevel.DEBUG, message)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output info message to stdout if log level is too high`() {
        lokLogLevel = LogLevel.WARN

        internalLogMessage(anyClassName, LogLevel.INFO, message)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output warn message to stdout if log level is too high`() {
        lokLogLevel = LogLevel.ERROR

        internalLogMessage(anyClassName, LogLevel.WARN, message)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output trace message with exception message to stdout if log level is too high`() {
        lokLogLevel = LogLevel.DEBUG

        internalLogException(anyClassName, LogLevel.TRACE, message, exception)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output debug message with exception to stdout if log level is too high`() {
        lokLogLevel = LogLevel.INFO

        internalLogException(anyClassName, LogLevel.DEBUG, message, exception)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output info message with exception to stdout if log level is too high`() {
        lokLogLevel = LogLevel.WARN

        internalLogException(anyClassName, LogLevel.INFO, message, exception)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should not output warn message with exception to stdout if log level is too high`() {
        lokLogLevel = LogLevel.ERROR

        internalLogException(anyClassName, LogLevel.WARN, message, exception)

        assertThat(stdOutOutput()).isEmpty()
    }
}
