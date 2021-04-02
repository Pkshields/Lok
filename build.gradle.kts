import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension

group = "dev.paulshields"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.4.32"

    id("io.gitlab.arturbosch.detekt").version("1.16.0-RC1")
    id("org.jlleitschuh.gradle.ktlint").version("10.0.0")
}

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

configure<KtlintExtension> {
    verbose.set(true)
}

detekt {
    config = files("detekt-config.yml")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))
}
