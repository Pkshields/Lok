package dev.paulshields.lok

import dev.paulshields.lok.internal.internalLogException
import dev.paulshields.lok.internal.internalLogMessage
import io.mockk.mockkStatic
import org.junit.jupiter.api.BeforeEach

open class BaseLoggerTest {
    protected val message = "Something might go wrong"
    protected val exception = IllegalAccessException("Something might go wrong")

    @BeforeEach
    fun `before each test`() {
        mockkStatic(::internalLogMessage)
        mockkStatic(::internalLogException)
    }
}
