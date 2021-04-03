package dev.paulshields.lok

import dev.paulshields.lok.internal.internalLogException
import dev.paulshields.lok.internal.internalLogIfEqual
import dev.paulshields.lok.internal.internalLogIfNotEqual
import dev.paulshields.lok.internal.internalLogIfNotNull
import dev.paulshields.lok.internal.internalLogIfNull
import dev.paulshields.lok.internal.internalLogMessage

fun logTrace(message: () -> String) = internalLogMessage(message.className, LogLevel.TRACE, message.invoke())
fun logDebug(message: () -> String) = internalLogMessage(message.className, LogLevel.DEBUG, message.invoke())
fun logInfo(message: () -> String) = internalLogMessage(message.className, LogLevel.INFO, message.invoke())
fun logWarn(message: () -> String) = internalLogMessage(message.className, LogLevel.WARN, message.invoke())
fun logError(message: () -> String) = internalLogMessage(message.className, LogLevel.ERROR, message.invoke())

fun logTrace(exception: Exception, message: () -> String) = internalLogException(message.className, LogLevel.TRACE, message.invoke(), exception)
fun logDebug(exception: Exception, message: () -> String) = internalLogException(message.className, LogLevel.DEBUG, message.invoke(), exception)
fun logInfo(exception: Exception, message: () -> String) = internalLogException(message.className, LogLevel.INFO, message.invoke(), exception)
fun logWarn(exception: Exception, message: () -> String) = internalLogException(message.className, LogLevel.WARN, message.invoke(), exception)
fun logError(exception: Exception, message: () -> String) = internalLogException(message.className, LogLevel.ERROR, message.invoke(), exception)

fun logIfEqual(item1: Any?, item2: Any?, logLevel: LogLevel = LogLevel.INFO, message: () -> String) =
    internalLogIfEqual(message.className, item1, item2, message.invoke(), logLevel)

fun logIfNotEqual(item1: Any?, item2: Any?, logLevel: LogLevel = LogLevel.INFO, message: () -> String) =
    internalLogIfNotEqual(message.className, item1, item2, message.invoke(), logLevel)

fun logIfNull(item: Any?, logLevel: LogLevel = LogLevel.INFO, message: () -> String) =
    internalLogIfNull(message.className, item, message.invoke(), logLevel)

fun logIfNotNull(item: Any?, logLevel: LogLevel = LogLevel.INFO, message: () -> String) =
    internalLogIfNotNull(message.className, item, message.invoke(), logLevel)

private val (() -> String).className
    get() = this.javaClass.name
