package dev.paulshields.lok.classlogger

import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.internalLogException
import dev.paulshields.lok.internal.internalLogMessage
import dev.paulshields.lok.logger
import io.mockk.verify
import org.junit.jupiter.api.Test

class StandardClassLoggerTest : BaseLoggerTest() {
    private val className = this::class.qualifiedName ?: ""

    private val target by logger()

    @Test
    fun `should output trace message to stdout`() {
        target.log(LogLevel.TRACE, message)

        verify { internalLogMessage(className, LogLevel.TRACE, message) }
    }

    @Test
    fun `should output debug message to stdout`() {
        target.log(LogLevel.DEBUG, message)

        verify { internalLogMessage(className, LogLevel.DEBUG, message) }
    }

    @Test
    fun `should output info message to stdout`() {
        target.log(LogLevel.INFO, message)

        verify { internalLogMessage(className, LogLevel.INFO, message) }
    }

    @Test
    fun `should output warn message to stdout`() {
        target.log(LogLevel.WARN, message)

        verify { internalLogMessage(className, LogLevel.WARN, message) }
    }

    @Test
    fun `should output error message to stderr`() {
        target.log(LogLevel.ERROR, message)

        verify { internalLogMessage(className, LogLevel.ERROR, message) }
    }

    @Test
    fun `should output trace message with exception message to stdout`() {
        target.log(LogLevel.TRACE, message, exception)

        verify { internalLogException(className, LogLevel.TRACE, message, exception) }
    }

    @Test
    fun `should output debug message with exception to stdout`() {
        target.log(LogLevel.DEBUG, message, exception)

        verify { internalLogException(className, LogLevel.DEBUG, message, exception) }
    }

    @Test
    fun `should output info message with exception to stdout`() {
        target.log(LogLevel.INFO, message, exception)

        verify { internalLogException(className, LogLevel.INFO, message, exception) }
    }

    @Test
    fun `should output warn message with exception to stdout`() {
        target.log(LogLevel.WARN, message, exception)

        verify { internalLogException(className, LogLevel.WARN, message, exception) }
    }

    @Test
    fun `should output error message with exception to stderr`() {
        target.log(LogLevel.ERROR, message, exception)

        verify { internalLogException(className, LogLevel.ERROR, message, exception) }
    }
}
