package dev.paulshields.lok.internal

import dev.paulshields.lok.LogLevel
import java.time.LocalDateTime

internal fun logMessage(className: String, logLevel: LogLevel, message: String) {
    if (logLevel == LogLevel.ERROR) {
        System.err.println(buildMessage(className, logLevel.name, message))
    } else {
        println(buildMessage(className, logLevel.name, message))
    }
}

internal fun logMessage(className: String, logLevel: LogLevel, message: String, exception: Exception) {
    logMessage(className, logLevel, message)
    exception.printStackTrace()
}

internal fun logIfEqual(className: String, item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (item1 == item2) {
        logMessage(className, logLevel, message)
    }
}

internal fun logIfNotEqual(className: String, item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (item1 != item2) {
        logMessage(className, logLevel, message)
    }
}

internal fun logIfNull(className: String, item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (item == null) {
        logMessage(className, logLevel, message)
    }
}

internal fun logIfNotNull(className: String, item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (item != null) {
        logMessage(className, logLevel, message)
    }
}

private fun buildMessage(className: String, logLevel: String, message: String) =
    "${LocalDateTime.now()} $logLevel @ $className: $message"
