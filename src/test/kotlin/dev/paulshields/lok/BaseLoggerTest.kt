package dev.paulshields.lok

import assertk.assertThat
import dev.paulshields.lok.testcommon.containsAll
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

open class BaseLoggerTest {
    protected val className = "GoodCodeClass"
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
