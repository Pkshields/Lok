package dev.paulshields.lok

private val underlyingLogger by lazy { UnderlyingLogger() }

fun logTrace(message: () -> String) = underlyingLogger.log(message.className, LogLevel.TRACE, message.invoke())
fun logDebug(message: () -> String) = underlyingLogger.log(message.className, LogLevel.DEBUG, message.invoke())
fun logInfo(message: () -> String) = underlyingLogger.log(message.className, LogLevel.INFO, message.invoke())
fun logWarn(message: () -> String) = underlyingLogger.log(message.className, LogLevel.WARN, message.invoke())
fun logError(message: () -> String) = underlyingLogger.log(message.className, LogLevel.ERROR, message.invoke())

fun logTrace(exception: Exception, message: () -> String) = underlyingLogger.log(message.className, LogLevel.TRACE, message.invoke(), exception)
fun logDebug(exception: Exception, message: () -> String) = underlyingLogger.log(message.className, LogLevel.DEBUG, message.invoke(), exception)
fun logInfo(exception: Exception, message: () -> String) = underlyingLogger.log(message.className, LogLevel.INFO, message.invoke(), exception)
fun logWarn(exception: Exception, message: () -> String) = underlyingLogger.log(message.className, LogLevel.WARN, message.invoke(), exception)
fun logError(exception: Exception, message: () -> String) = underlyingLogger.log(message.className, LogLevel.ERROR, message.invoke(), exception)

fun logIfEqual(item1: Any?, item2: Any?, logLevel: LogLevel = LogLevel.INFO, message: () -> String) =
    underlyingLogger.logIfEqual(message.className, item1, item2, message.invoke(), logLevel)

fun logIfNotEqual(item1: Any?, item2: Any?, logLevel: LogLevel = LogLevel.INFO, message: () -> String) =
    underlyingLogger.logIfNotEqual(message.className, item1, item2, message.invoke(), logLevel)

fun logIfNull(item: Any?, logLevel: LogLevel = LogLevel.INFO, message: () -> String) =
    underlyingLogger.logIfNull(message.className, item, message.invoke(), logLevel)

fun logIfNotNull(item: Any?, logLevel: LogLevel = LogLevel.INFO, message: () -> String) =
    underlyingLogger.logIfNotNull(message.className, item, message.invoke(), logLevel)

private val (() -> String).className
    get() = this.javaClass.name
