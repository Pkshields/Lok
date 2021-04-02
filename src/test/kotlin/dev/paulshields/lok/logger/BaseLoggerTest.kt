package dev.paulshields.lok.logger

import assertk.assertThat
import dev.paulshields.lok.logger
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

open class BaseLoggerTest {
    protected val target by logger()
    protected val message = "Something might go wrong"
    protected val exception = IllegalAccessException("Something might go wrong")

    protected val stdOutCapture = ByteArrayOutputStream()
    protected val stdErrCapture = ByteArrayOutputStream()

    @BeforeEach
    fun `before each test`() {
        System.setOut(PrintStream(stdOutCapture))
        System.setErr(PrintStream(stdErrCapture))
    }

    protected fun stdOutOutput() = String(stdOutCapture.toByteArray())
    protected fun stdErrOutput() = String(stdErrCapture.toByteArray())

    protected fun assertThatStdErrContainsExceptionLogs() {
        assertThat(stdErrOutput()).containsAll(exception.stackTraceToString())
    }
}
