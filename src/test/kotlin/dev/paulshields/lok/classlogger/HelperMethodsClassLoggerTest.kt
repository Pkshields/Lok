package dev.paulshields.lok.classlogger

import assertk.assertThat
import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.logger
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.Test

class HelperMethodsClassLoggerTest : BaseLoggerTest() {
    private val target by logger()

    @Test
    fun `should output trace message to stdout`() {
        target.trace(message)

        assertThat(stdOutOutput()).containsAll("TRACE", message)
    }

    @Test
    fun `should output debug message to stdout`() {
        target.debug(message)

        assertThat(stdOutOutput()).containsAll("DEBUG", message)
    }

    @Test
    fun `should output info message to stdout`() {
        target.info(message)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should output warn message to stdout`() {
        target.warn(message)

        assertThat(stdOutOutput()).containsAll("WARN", message)
    }

    @Test
    fun `should output error message to stderr`() {
        target.error(message)

        assertThat(stdErrOutput()).containsAll("ERROR", message)
    }

    @Test
    fun `should output trace message with exception message to stdout`() {
        target.trace(message, exception)

        assertThat(stdOutOutput()).containsAll("TRACE", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output debug message with exception to stdout`() {
        target.debug(message, exception)

        assertThat(stdOutOutput()).containsAll("DEBUG", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output info message with exception to stdout`() {
        target.info(message, exception)

        assertThat(stdOutOutput()).containsAll("INFO", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output warn message with exception to stdout`() {
        target.warn(message, exception)

        assertThat(stdOutOutput()).containsAll("WARN", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output error message with exception to stderr`() {
        target.error(message, exception)

        assertThat(stdErrOutput()).containsAll("ERROR", message)
        assertThatStdErrContainsExceptionLogs()
    }
}
