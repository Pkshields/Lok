package dev.paulshields.lok.internal

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

class LogFormatterTest {
    private val className = "dev.paulshields.lok.AlejandroAgag"
    private val message = "Extreme E"
    private val logLevel = "ERROR"
    private val nestedClassName = "$className\$InternalClass\$1"

    private val timestampRegex = Regex("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}")

    @Test
    fun `should correctly format a log message`() {
        val result = buildMessage(className, logLevel, message)

        assertThat(timestampRegex.containsMatchIn(result)).isTrue()
        assertThat(result).contains("$logLevel @ $className: $message")
    }

    @Test
    fun `should correctly extract the expected class name from a nested class name`() {
        val result = buildMessage(nestedClassName, logLevel, message)

        assertThat(result).contains("$logLevel @ $className: $message")
    }
}
