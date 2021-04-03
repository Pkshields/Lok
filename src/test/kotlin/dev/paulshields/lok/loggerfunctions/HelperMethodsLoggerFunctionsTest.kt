package dev.paulshields.lok.loggerfunctions

import assertk.assertThat
import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.logDebug
import dev.paulshields.lok.logError
import dev.paulshields.lok.logInfo
import dev.paulshields.lok.logTrace
import dev.paulshields.lok.logWarn
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.Test

class HelperMethodsLoggerFunctionsTest : BaseLoggerTest() {
    @Test
    fun `should output trace message to stdout`() {
        logTrace { message }

        assertThat(stdOutOutput()).containsAll("TRACE", message)
    }

    @Test
    fun `should output debug message to stdout`() {
        logDebug { message }

        assertThat(stdOutOutput()).containsAll("DEBUG", message)
    }

    @Test
    fun `should output info message to stdout`() {
        logInfo { message }

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should output warn message to stdout`() {
        logWarn { message }

        assertThat(stdOutOutput()).containsAll("WARN", message)
    }

    @Test
    fun `should output error message to stderr`() {
        logError { message }

        assertThat(stdErrOutput()).containsAll("ERROR", message)
    }

    @Test
    fun `should output trace message with exception message to stdout`() {
        logTrace(exception) { message }

        assertThat(stdOutOutput()).containsAll("TRACE", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output debug message with exception to stdout`() {
        logDebug(exception) { message }

        assertThat(stdOutOutput()).containsAll("DEBUG", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output info message with exception to stdout`() {
        logInfo(exception) { message }

        assertThat(stdOutOutput()).containsAll("INFO", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output warn message with exception to stdout`() {
        logWarn(exception) { message }

        assertThat(stdOutOutput()).containsAll("WARN", message)
        assertThatStdErrContainsExceptionLogs()
    }

    @Test
    fun `should output error message with exception to stderr`() {
        logError(exception) { message }

        assertThat(stdErrOutput()).containsAll("ERROR", message)
        assertThatStdErrContainsExceptionLogs()
    }
}
