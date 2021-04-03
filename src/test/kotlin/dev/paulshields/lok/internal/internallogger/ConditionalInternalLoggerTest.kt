package dev.paulshields.lok.internal.internallogger

import assertk.assertThat
import assertk.assertions.isEmpty
import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.logIfEqual
import dev.paulshields.lok.internal.logIfNotEqual
import dev.paulshields.lok.internal.logIfNotNull
import dev.paulshields.lok.internal.logIfNull
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.Test

class ConditionalInternalLoggerTest : BaseLoggerTest() {
    @Test
    fun `should output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        logIfEqual(className, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        logIfEqual(className, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        logIfNotEqual(className, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        logIfNotEqual(className, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if item is null`() {
        logIfNull(className, null, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if item is not null`() {
        logIfNull(className, 1, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if item is not null`() {
        logIfNotNull(className, 1, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if item is null`() {
        logIfNotNull(className, null, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }
}
