package dev.paulshields.lok

import dev.paulshields.lok.internal.internalLogException
import dev.paulshields.lok.internal.internalLogIfEqual
import dev.paulshields.lok.internal.internalLogIfNotEqual
import dev.paulshields.lok.internal.internalLogIfNotNull
import dev.paulshields.lok.internal.internalLogIfNull
import dev.paulshields.lok.internal.internalLogMessage

@Suppress("TooManyFunctions")
class ClassLogger(private val className: String) {
    fun log(logLevel: LogLevel, message: String) = internalLogMessage(className, logLevel, message)
    fun log(logLevel: LogLevel, message: String, exception: Exception) = internalLogException(className, logLevel, message, exception)

    fun trace(message: String) = log(LogLevel.TRACE, message)
    fun debug(message: String) = log(LogLevel.DEBUG, message)
    fun info(message: String) = log(LogLevel.INFO, message)
    fun warn(message: String) = log(LogLevel.WARN, message)
    fun error(message: String) = log(LogLevel.ERROR, message)

    fun trace(message: String, exception: Exception) = log(LogLevel.TRACE, message, exception)
    fun debug(message: String, exception: Exception) = log(LogLevel.DEBUG, message, exception)
    fun info(message: String, exception: Exception) = log(LogLevel.INFO, message, exception)
    fun warn(message: String, exception: Exception) = log(LogLevel.WARN, message, exception)
    fun error(message: String, exception: Exception) = log(LogLevel.ERROR, message, exception)

    fun logIfEqual(item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) =
        internalLogIfEqual(className, item1, item2, message, logLevel)

    fun logIfNotEqual(item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) =
        internalLogIfNotEqual(className, item1, item2, message, logLevel)

    fun logIfNull(item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) =
        internalLogIfNull(className, item, message, logLevel)

    fun logIfNotNull(item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) =
        internalLogIfNotNull(className, item, message, logLevel)
}
