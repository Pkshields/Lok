package dev.paulshields.lok

var lokLogLevel: LogLevel = getEnvironmentLokLevel()

private fun getEnvironmentLokLevel() =
    System.getenv("LOK_LEVEL")
        ?.let {
            try {
                LogLevel.valueOf(it)
            } catch (exception: Exception) {
                println("WARNING: Lok Level $it does not exist. Reverting to default.")
                null
            }
        } ?: LogLevel.DEBUG
