import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension

val libraryGroupId = "dev.paulshields"
val libraryName = "lok"
val libraryVersion = "1.0"

group = "$libraryGroupId.$libraryName"
version = libraryVersion

plugins {
    kotlin("jvm") version "1.5.30"

    `maven-publish`

    id("io.gitlab.arturbosch.detekt").version("1.18.1")
    id("org.jlleitschuh.gradle.ktlint").version("10.2.0")
}

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = libraryGroupId
            artifactId = libraryName
            version = libraryVersion

            from(components["java"])
        }
    }
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

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
    testImplementation("io.mockk:mockk:1.12.0")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}
