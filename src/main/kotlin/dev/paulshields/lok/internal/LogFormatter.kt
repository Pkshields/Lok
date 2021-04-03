package dev.paulshields.lok.internal

import java.time.LocalDateTime

internal fun buildMessage(className: String, logLevel: String, message: String) =
    "${LocalDateTime.now()} $logLevel @ ${formatClassName(className)}: $message"

private fun formatClassName(className: String) = className.split("$")[0]
