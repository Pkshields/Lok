package dev.paulshields.lok.internal.internallogger

import assertk.assertThat
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

open class BaseInternalLoggerTest {
    protected val anyClassName = "GoodCodeClass"
    protected val message = "Something might go wrong"
    protected val exception = IllegalAccessException("Something might go wrong")

    private val stdOutCapture = ByteArrayOutputStream()
    private val stdErrCapture = ByteArrayOutputStream()

    @BeforeEach
    open fun `before each test`() {
        System.setOut(PrintStream(stdOutCapture))
        System.setErr(PrintStream(stdErrCapture))
    }

    protected fun stdOutOutput() = String(stdOutCapture.toByteArray())
    protected fun stdErrOutput() = String(stdErrCapture.toByteArray())

    protected fun assertThatStdErrContainsExceptionLogs() {
        assertThat(stdErrOutput()).containsAll(exception.stackTraceToString())
    }
}
