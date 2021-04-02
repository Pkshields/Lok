package dev.paulshields.lok.underlyinglogger

import assertk.assertThat
import assertk.assertions.isEmpty
import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.UnderlyingLogger
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.Test

class ConditionalUnderlyingLoggerTest : BaseLoggerTest() {
    private val target = UnderlyingLogger()

    @Test
    fun `should output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        target.logIfEqual(className, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        target.logIfEqual(className, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        target.logIfNotEqual(className, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        target.logIfNotEqual(className, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if item is null`() {
        target.logIfNull(className, null, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if item is not null`() {
        target.logIfNull(className, 1, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if item is not null`() {
        target.logIfNotNull(className, 1, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if item is null`() {
        target.logIfNotNull(className, null, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }
}
