# Lok

A simple no-config logger for Kotlin.

## Getting Started

[TODO]

## Usage

Lok has a variety of top level functions you can use for your logging needs.

### Standard logging functions

```
package dev.paulshields.lok

logTrace { "Hello world" }
logDebug { "Hello world" }
logInfo { "Hello world" }
logWarn { "Hello world" }
logError { "Hello world" }

logTrace(exception) { "Hello world" }
logDebug(exception) { "Hello world" }
logInfo(exception) { "Hello world" }
logWarn(exception) { "Hello world" }
logError(exception) { "Hello world" }
```

### Conditional functions

```
logIfEqual(item1, item2, logLevel) { "Hello world" }

logIfNotEqual(item1, item2, logLevel) { "Hello world" }

logIfNull(item, logLevel) { "Hello world" }

logIfNotNull(item, logLevel) { "Hello world" }
```

### Output

Lok has one standard log output format used for all log messages

```2021-11-20T12:52:25.749879 INFO @ dev.paulshields.lok.Class: Something might go wrong!```

As expected, all logs are printed on stdout, except for errors which are printed to stderr.

#### Scope Warning

In Lok's output, you will notice that the library prints the name of the class that the log message is coming from. In most normal code execution situations this works well, however it can get problematic if you are trying to log in a block of code where the scope has been changed.

Examples of this includes when using certain Kotlin [Scope Functions](https://kotlinlang.org/docs/scope-functions.html) or when using [coroutines](https://kotlinlang.org/docs/coroutines-guide.html).

If you need to log within a scoped block of code, it's recommended you use a Logger Instance.

### Logger Instance

If you need to use an instance of a logger instead of the logger functions, you can do so by using the supplied delegate function.

```
val logger by logger()
```

Or, if you prefer some standard OOP code, you can instantiate the class directly.

```
val logger = ClassLogger("ClassName")
```

The API for the logger instance matches the available functions.

```
target.trace("Hello world")
target.debug("Hello world")
target.info("Hello world")
target.warn("Hello world")
target.error("Hello world")

target.trace("Hello world", exception)
target.debug("Hello world", exception)
target.info("Hello world", exception)
target.warn("Hello world", exception)
target.error("Hello world", exception)

target.logIfEqual(item1, item2, "Hello world", logLevel)

target.logIfNotEqual(item1, "Hello world", logLevel)

target.logIfNull(item1, "Hello world", logLevel)

target.logIfNotNull(item1, "Hello world", logLevel)
```

### Configuration

... Alright, fine, there is one piece of optional configuration. The minimum log level can be set using the `lokLogLevel` top level property.

```
import dev.paulshields.lok.lokLogLevel

lokLogLevel = LogLevel.TRACE
```

The minimum log level can also be set using a JVM environment variable.

```
java -DLOG_LEVEL=TRACE your-incredible-application.jar
```

The default minimum log level is DEBUG.

#### Available Log Levels

* TRACE
* DEBUG
* INFO
* WARN
* ERROR
