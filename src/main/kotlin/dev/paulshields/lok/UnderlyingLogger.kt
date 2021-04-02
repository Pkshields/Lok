package dev.paulshields.lok

import java.time.LocalDateTime

internal class UnderlyingLogger {
    fun log(className: String, logLevel: LogLevel, message: String) {
        if (logLevel == LogLevel.ERROR) {
            System.err.println(buildMessage(className, logLevel.name, message))
        } else {
            println(buildMessage(className, logLevel.name, message))
        }
    }

    fun log(className: String, logLevel: LogLevel, message: String, exception: Exception) {
        log(className, logLevel, message)
        exception.printStackTrace()
    }

    fun logIfEqual(className: String, item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
        if (item1 == item2) {
            log(className, logLevel, message)
        }
    }

    fun logIfNotEqual(className: String, item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
        if (item1 != item2) {
            log(className, logLevel, message)
        }
    }

    fun logIfNull(className: String, item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
        if (item == null) {
            log(className, logLevel, message)
        }
    }

    fun logIfNotNull(className: String, item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
        if (item != null) {
            log(className, logLevel, message)
        }
    }

    private fun buildMessage(className: String, logLevel: String, message: String) =
        "${LocalDateTime.now()} $logLevel @ $className: $message"
}
