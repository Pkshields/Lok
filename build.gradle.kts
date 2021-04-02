import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension

group = "dev.paulshields"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.4.32"

    id("io.gitlab.arturbosch.detekt").version("1.16.0")
    id("org.jlleitschuh.gradle.ktlint").version("10.0.0")
}

repositories {
    mavenCentral()
    jcenter()
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

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
    testImplementation("io.mockk:mockk:1.10.5")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.23")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}
