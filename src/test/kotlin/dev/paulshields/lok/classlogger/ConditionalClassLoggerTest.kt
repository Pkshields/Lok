package dev.paulshields.lok.classlogger

import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.internalLogMessage
import dev.paulshields.lok.logger
import io.mockk.verify
import org.junit.jupiter.api.Test

class ConditionalClassLoggerTest : BaseLoggerTest() {
    private val className = this::class.qualifiedName ?: ""

    private val target by logger()

    @Test
    fun `should output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        target.logIfEqual(item1, item2, message, LogLevel.INFO)

        verify { internalLogMessage(className, LogLevel.INFO, message) }
    }

    @Test
    fun `should not output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        target.logIfEqual(item1, item2, message, LogLevel.INFO)

        verify(exactly = 0) { internalLogMessage(any(), any(), any()) }
    }

    @Test
    fun `should output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        target.logIfNotEqual(item1, item2, message, LogLevel.INFO)

        verify { internalLogMessage(className, LogLevel.INFO, message) }
    }

    @Test
    fun `should not output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        target.logIfNotEqual(item1, item2, message, LogLevel.INFO)

        verify(exactly = 0) { internalLogMessage(any(), any(), any()) }
    }

    @Test
    fun `should output log line if item is null`() {
        target.logIfNull(null, message, LogLevel.INFO)

        verify { internalLogMessage(className, LogLevel.INFO, message) }
    }

    @Test
    fun `should not output log line if item is not null`() {
        target.logIfNull(1, message, LogLevel.INFO)

        verify(exactly = 0) { internalLogMessage(any(), any(), any()) }
    }

    @Test
    fun `should output log line if item is not null`() {
        target.logIfNotNull(1, message, LogLevel.INFO)

        verify { internalLogMessage(className, LogLevel.INFO, message) }
    }

    @Test
    fun `should not output log line if item is null`() {
        target.logIfNotNull(null, message, LogLevel.INFO)

        verify(exactly = 0) { internalLogMessage(any(), any(), any()) }
    }
}
