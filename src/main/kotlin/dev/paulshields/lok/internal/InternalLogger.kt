package dev.paulshields.lok.internal

import dev.paulshields.lok.LogLevel
import dev.paulshields.lok.lokLogLevel

internal fun internalLogMessage(className: String, logLevel: LogLevel, message: String) {
    if (!logLevelIsEnabled(logLevel)) return

    writeMessageToLog(className, logLevel, message)
}

internal fun internalLogException(className: String, logLevel: LogLevel, message: String, exception: Exception) {
    if (!logLevelIsEnabled(logLevel)) return

    writeMessageToLog(className, logLevel, message)
    exception.printStackTrace()
}

internal fun internalLogIfEqual(className: String, item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (!logLevelIsEnabled(logLevel)) return

    if (item1 == item2) {
        writeMessageToLog(className, logLevel, message)
    }
}

internal fun internalLogIfNotEqual(className: String, item1: Any?, item2: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (!logLevelIsEnabled(logLevel)) return

    if (item1 != item2) {
        writeMessageToLog(className, logLevel, message)
    }
}

internal fun internalLogIfNull(className: String, item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (!logLevelIsEnabled(logLevel)) return

    if (item == null) {
        writeMessageToLog(className, logLevel, message)
    }
}

internal fun internalLogIfNotNull(className: String, item: Any?, message: String, logLevel: LogLevel = LogLevel.INFO) {
    if (!logLevelIsEnabled(logLevel)) return

    if (item != null) {
        writeMessageToLog(className, logLevel, message)
    }
}

private fun writeMessageToLog(className: String, logLevel: LogLevel, message: String) {
    if (logLevel == LogLevel.ERROR) {
        System.err.println(buildMessage(className, logLevel.name, message))
    } else {
        println(buildMessage(className, logLevel.name, message))
    }
}

private fun logLevelIsEnabled(logLevel: LogLevel) = logLevel.level >= lokLogLevel.level
