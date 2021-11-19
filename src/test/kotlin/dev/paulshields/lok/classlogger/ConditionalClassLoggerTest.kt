package dev.paulshields.lok.classlogger

import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.internalLogIfEqual
import dev.paulshields.lok.internal.internalLogIfNotEqual
import dev.paulshields.lok.internal.internalLogIfNotNull
import dev.paulshields.lok.internal.internalLogIfNull
import dev.paulshields.lok.logger
import io.mockk.verify
import org.junit.jupiter.api.Test

class ConditionalClassLoggerTest : BaseLoggerTest() {
    private val className = this::class.qualifiedName ?: ""

    private val target by logger()

    @Test
    fun `should delegate log if equal call to the internal log function`() {
        val item1 = 1
        val item2 = 1

        target.logIfEqual(item1, item2, message, LogLevel.INFO)

        verify { internalLogIfEqual(className, item1, item2, message, LogLevel.INFO) }
    }

    @Test
    fun `should delegate log if not equal call to the internal log function`() {
        val item1 = 1
        val item2 = 2

        target.logIfNotEqual(item1, item2, message, LogLevel.INFO)

        verify { internalLogIfNotEqual(className, item1, item2, message, LogLevel.INFO) }
    }

    @Test
    fun `should delegate log if null call to the internal log function`() {
        target.logIfNull(null, message, LogLevel.INFO)

        verify { internalLogIfNull(className, null, message, LogLevel.INFO) }
    }

    @Test
    fun `should delegate log if not null call to the internal log function`() {
        val item = 1

        target.logIfNotNull(1, message, LogLevel.INFO)

        verify { internalLogIfNotNull(className, item, message, LogLevel.INFO) }
    }
}
