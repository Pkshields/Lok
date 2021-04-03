package dev.paulshields.lok.internal

import dev.paulshields.lok.LogLevel

internal fun internalLogMessage(className: String, logLevel: LogLevel, message: String) {
    if (logLevel == LogLevel.ERROR) {
        System.err.println(buildMessage(className, logLevel.name, message))
    } else {
        println(buildMessage(className, logLevel.name, message))
    }
}

internal fun internalLogException(className: String, logLevel: LogLevel, message: String, exception: Exception) {
    internalLogMessage(className, logLevel, message)
    exception.printStackTrace()
}

internal fun internalLogIfEqual(className: String, item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (item1 == item2) {
        internalLogMessage(className, logLevel, message)
    }
}

internal fun internalLogIfNotEqual(className: String, item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (item1 != item2) {
        internalLogMessage(className, logLevel, message)
    }
}

internal fun internalLogIfNull(className: String, item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (item == null) {
        internalLogMessage(className, logLevel, message)
    }
}

internal fun internalLogIfNotNull(className: String, item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (item != null) {
        internalLogMessage(className, logLevel, message)
    }
}
