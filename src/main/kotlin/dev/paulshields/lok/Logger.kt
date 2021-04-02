package dev.paulshields.lok

import java.time.LocalDateTime

@Suppress("TooManyFunctions")
class Logger(private val className: String) {
    fun log(logLevel: LogLevel, message: String) {
        if (logLevel == LogLevel.ERROR) {
            System.err.println(buildMessage(logLevel.name, message))
        } else {
            println(buildMessage(logLevel.name, message))
        }
    }

    fun log(logLevel: LogLevel, message: String, exception: Exception) {
        log(logLevel, message)
        exception.printStackTrace()
    }

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

    fun logIfEqual(item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
        if (item1 == item2) {
            log(logLevel, message)
        }
    }

    fun logIfNotEqual(item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
        if (item1 != item2) {
            log(logLevel, message)
        }
    }

    fun logIfNull(item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
        if (item == null) {
            log(logLevel, message)
        }
    }

    fun logIfNotNull(item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
        if (item != null) {
            log(logLevel, message)
        }
    }

    private fun buildMessage(logLevel: String, message: String) =
        "${LocalDateTime.now()} $logLevel @ $className: $message"
}
