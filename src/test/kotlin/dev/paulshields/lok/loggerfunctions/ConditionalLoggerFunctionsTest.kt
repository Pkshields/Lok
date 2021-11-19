package dev.paulshields.lok.loggerfunctions

import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.internalLogIfEqual
import dev.paulshields.lok.internal.internalLogIfNotEqual
import dev.paulshields.lok.internal.internalLogIfNotNull
import dev.paulshields.lok.internal.internalLogIfNull
import dev.paulshields.lok.internal.internalLogMessage
import dev.paulshields.lok.logIfEqual
import dev.paulshields.lok.logIfNotEqual
import dev.paulshields.lok.logIfNotNull
import dev.paulshields.lok.logIfNull
import io.mockk.verify
import org.junit.jupiter.api.Test

class ConditionalLoggerFunctionsTest : BaseLoggerTest() {
    private val className = this::class.qualifiedName ?: ""

    @Test
    fun `should output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        logIfEqual(item1, item2, LogLevel.INFO) { message }

        verify { internalLogIfEqual(match { it.contains(className) }, item1, item2, message, LogLevel.INFO) }
    }

    @Test
    fun `should not output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        logIfEqual(item1, item2, LogLevel.INFO) { message }

        verify(exactly = 0) { internalLogMessage(any(), any(), any()) }
    }

    @Test
    fun `should output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        logIfNotEqual(item1, item2, LogLevel.INFO) { message }

        verify { internalLogIfNotEqual(match { it.contains(className) }, item1, item2, message, LogLevel.INFO) }
    }

    @Test
    fun `should not output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        logIfNotEqual(item1, item2, LogLevel.INFO) { message }

        verify(exactly = 0) { internalLogMessage(any(), any(), any()) }
    }

    @Test
    fun `should output log line if item is null`() {
        logIfNull(null, LogLevel.INFO) { message }

        verify { internalLogIfNull(match { it.contains(className) }, null, message, LogLevel.INFO) }
    }

    @Test
    fun `should not output log line if item is not null`() {
        logIfNull(1, LogLevel.INFO) { message }

        verify(exactly = 0) { internalLogMessage(any(), any(), any()) }
    }

    @Test
    fun `should output log line if item is not null`() {
        logIfNotNull(1, LogLevel.INFO) { message }

        verify { internalLogIfNotNull(match { it.contains(className) }, 1, message, LogLevel.INFO) }
    }

    @Test
    fun `should not output log line if item is null`() {
        logIfNotNull(null, LogLevel.INFO) { message }

        verify(exactly = 0) { internalLogMessage(any(), any(), any()) }
    }
}
