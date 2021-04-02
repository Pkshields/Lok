package dev.paulshields.lok.underlyinglogger

import assertk.assertThat
import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.UnderlyingLogger
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.Test

class StandardUnderlyingLoggerTest : BaseLoggerTest() {
    private val target = UnderlyingLogger()

    @Test
    fun `should output trace message to stdout`() {
        target.log(className, LogLevel.TRACE, message)

        assertThat(stdOutOutput()).containsAll("TRACE", message)
    }

    @Test
    fun `should output debug message to stdout`() {
        target.log(className, LogLevel.DEBUG, message)

        assertThat(stdOutOutput()).containsAll("DEBUG", message)
    }

    @Test
    fun `should output info message to stdout`() {
        target.log(className, LogLevel.INFO, message)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should output warn message to stdout`() {
        target.log(className, LogLevel.WARN, message)

        assertThat(stdOutOutput()).containsAll("WARN", message)
    }

    @Test
    fun `should output error message to stderr`() {
        target.log(className, LogLevel.ERROR, message)

        assertThat(stdErrOutput()).containsAll("ERROR", message)
    }

    @Test
    fun `should output trace message with exception message to stdout`() {
        target.log(className, LogLevel.TRACE, message, exception)

        assertThat(stdOutOutput()).containsAll("TRACE", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output debug message with exception to stdout`() {
        target.log(className, LogLevel.DEBUG, message, exception)

        assertThat(stdOutOutput()).containsAll("DEBUG", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output info message with exception to stdout`() {
        target.log(className, LogLevel.INFO, message, exception)

        assertThat(stdOutOutput()).containsAll("INFO", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output warn message with exception to stdout`() {
        target.log(className, LogLevel.WARN, message, exception)

        assertThat(stdOutOutput()).containsAll("WARN", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output error message with exception to stderr`() {
        target.log(className, LogLevel.ERROR, message, exception)

        assertThat(stdErrOutput()).containsAll("ERROR", message)
        assertThatStdErrContainsExceptionLogs()
    }
}
