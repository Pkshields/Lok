package dev.paulshields.lok

fun <TAnyClass : Any> TAnyClass.logger(): Lazy<ClassLogger> {
    return lazy { ClassLogger(this::class.qualifiedName ?: "") }
}
