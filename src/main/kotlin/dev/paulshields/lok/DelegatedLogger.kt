package dev.paulshields.lok

fun <TAnyClass : Any> TAnyClass.logger(): Lazy<Logger> {
    return lazy { Logger(this::class.qualifiedName ?: "") }
}
