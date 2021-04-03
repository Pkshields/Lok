package dev.paulshields.lok.internal.internallogger

import assertk.assertThat
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.internalLogException
import dev.paulshields.lok.internal.internalLogMessage
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.Test

class StandardInternalLoggerTest : BaseInternalLoggerTest() {
    @Test
    fun `should output trace message to stdout`() {
        internalLogMessage(anyClassName, LogLevel.TRACE, message)

        assertThat(stdOutOutput()).containsAll("TRACE", message)
    }

    @Test
    fun `should output debug message to stdout`() {
        internalLogMessage(anyClassName, LogLevel.DEBUG, message)

        assertThat(stdOutOutput()).containsAll("DEBUG", message)
    }

    @Test
    fun `should output info message to stdout`() {
        internalLogMessage(anyClassName, LogLevel.INFO, message)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should output warn message to stdout`() {
        internalLogMessage(anyClassName, LogLevel.WARN, message)

        assertThat(stdOutOutput()).containsAll("WARN", message)
    }

    @Test
    fun `should output error message to stderr`() {
        internalLogMessage(anyClassName, LogLevel.ERROR, message)

        assertThat(stdErrOutput()).containsAll("ERROR", message)
    }

    @Test
    fun `should output trace message with exception message to stdout`() {
        internalLogException(anyClassName, LogLevel.TRACE, message, exception)

        assertThat(stdOutOutput()).containsAll("TRACE", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output debug message with exception to stdout`() {
        internalLogException(anyClassName, LogLevel.DEBUG, message, exception)

        assertThat(stdOutOutput()).containsAll("DEBUG", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output info message with exception to stdout`() {
        internalLogException(anyClassName, LogLevel.INFO, message, exception)

        assertThat(stdOutOutput()).containsAll("INFO", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output warn message with exception to stdout`() {
        internalLogException(anyClassName, LogLevel.WARN, message, exception)

        assertThat(stdOutOutput()).containsAll("WARN", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output error message with exception to stderr`() {
        internalLogException(anyClassName, LogLevel.ERROR, message, exception)

        assertThat(stdErrOutput()).containsAll("ERROR", message)
        assertThatStdErrContainsExceptionLogs()
    }
}
