package dev.paulshields.lok.internal.internallogger

import assertk.assertThat
import assertk.assertions.isEmpty
import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.internal.internalLogIfEqual
import dev.paulshields.lok.internal.internalLogIfNotEqual
import dev.paulshields.lok.internal.internalLogIfNotNull
import dev.paulshields.lok.internal.internalLogIfNull
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.Test

class ConditionalInternalLoggerTest : BaseInternalLoggerTest() {
    @Test
    fun `should output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        internalLogIfEqual(anyClassName, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        internalLogIfEqual(anyClassName, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if items are not equal`() {
        val item1 = 1
        val item2 = 2

        internalLogIfNotEqual(anyClassName, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if items are equal`() {
        val item1 = 1
        val item2 = 1

        internalLogIfNotEqual(anyClassName, item1, item2, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if item is null`() {
        internalLogIfNull(anyClassName, null, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if item is not null`() {
        internalLogIfNull(anyClassName, 1, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }

    @Test
    fun `should output log line if item is not null`() {
        internalLogIfNotNull(anyClassName, 1, message, LogLevel.INFO)

        assertThat(stdOutOutput()).containsAll("INFO", message)
    }

    @Test
    fun `should not output log line if item is null`() {
        internalLogIfNotNull(anyClassName, null, message, LogLevel.INFO)

        assertThat(stdOutOutput()).isEmpty()
    }
}
