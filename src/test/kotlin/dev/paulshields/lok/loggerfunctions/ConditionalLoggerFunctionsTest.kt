package dev.paulshields.lok.loggerfunctions

import assertk.assertThat
import assertk.assertions.isEmpty
import dev.paulshields.lok.BaseLoggerTest
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.logIfEqual
import dev.paulshields.lok.logIfNotEqual
import dev.paulshields.lok.logIfNotNull
import dev.paulshields.lok.logIfNull
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.Test

class ConditionalLoggerFunctionsTest : BaseLoggerTest() {
    @Test
    fun `should output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        logIfEqual(item1, item2, LogLevel.INFO) { message }

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        logIfEqual(item1, item2, LogLevel.INFO) { message }

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        logIfNotEqual(item1, item2, LogLevel.INFO) { message }

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        logIfNotEqual(item1, item2, LogLevel.INFO) { message }

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if item is null`() {
        logIfNull(null, LogLevel.INFO) { message }

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if item is not null`() {
        logIfNull(1, LogLevel.INFO) { message }

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if item is not null`() {
        logIfNotNull(1, LogLevel.INFO) { message }

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if item is null`() {
        logIfNotNull(null, LogLevel.INFO) { message }

        assertThat(stdOutOutput()).isEmpty()
    }
}
