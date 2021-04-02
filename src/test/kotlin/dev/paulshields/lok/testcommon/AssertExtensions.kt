package dev.paulshields.lok.testcommon

import assertk.Assert
import assertk.assertions.contains

fun Assert<CharSequence>.containsAll(vararg needles: String) = needles.forEach { this.contains(it) }
