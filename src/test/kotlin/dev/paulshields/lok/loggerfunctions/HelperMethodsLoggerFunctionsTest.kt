package dev.paulshields.lok.loggerfunctions

import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.internalLogException
import dev.paulshields.lok.internal.internalLogMessage
import dev.paulshields.lok.logDebug
import dev.paulshields.lok.logError
import dev.paulshields.lok.logInfo
import dev.paulshields.lok.logTrace
import dev.paulshields.lok.logWarn
import io.mockk.verify
import org.junit.jupiter.api.Test

class HelperMethodsLoggerFunctionsTest : BaseLoggerTest() {
    private val className = this::class.qualifiedName ?: ""

    @Test
    fun `should output trace message to stdout`() {
        logTrace { message }

        verify { internalLogMessage(match { it.contains(className) }, LogLevel.TRACE, message) }
    }

    @Test
    fun `should output debug message to stdout`() {
        logDebug { message }

        verify { internalLogMessage(match { it.contains(className) }, LogLevel.DEBUG, message) }
    }

    @Test
    fun `should output info message to stdout`() {
        logInfo { message }

        verify { internalLogMessage(match { it.contains(className) }, LogLevel.INFO, message) }
    }

    @Test
    fun `should output warn message to stdout`() {
        logWarn { message }

        verify { internalLogMessage(match { it.contains(className) }, LogLevel.WARN, message) }
    }

    @Test
    fun `should output error message to stderr`() {
        logError { message }

        verify { internalLogMessage(match { it.contains(className) }, LogLevel.ERROR, message) }
    }

    @Test
    fun `should output trace message with exception message to stdout`() {
        logTrace(exception) { message }

        verify { internalLogException(match { it.contains(className) }, LogLevel.TRACE, message, exception) }
    }

    @Test
    fun `should output debug message with exception to stdout`() {
        logDebug(exception) { message }

        verify { internalLogException(match { it.contains(className) }, LogLevel.DEBUG, message, exception) }
    }

    @Test
    fun `should output info message with exception to stdout`() {
        logInfo(exception) { message }

        verify { internalLogException(match { it.contains(className) }, LogLevel.INFO, message, exception) }
    }

    @Test
    fun `should output warn message with exception to stdout`() {
        logWarn(exception) { message }

        verify { internalLogException(match { it.contains(className) }, LogLevel.WARN, message, exception) }
    }

    @Test
    fun `should output error message with exception to stderr`() {
        logError(exception) { message }

        verify { internalLogException(match { it.contains(className) }, LogLevel.ERROR, message, exception) }
    }
}
