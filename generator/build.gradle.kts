@file:Suppress("UnstableApiUsage")

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("jvm")
    id("com.gradleup.shadow") version "9.2.2"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(platform("org.slf4j:slf4j-bom:2.0.17"))
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.20.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.20.1")
    implementation("org.apache.commons:commons-text:1.14.0")
    implementation("com.palantir.javapoet:javapoet:0.8.0")
    implementation("org.slf4j:slf4j-api")
    implementation("org.slf4j:slf4j-simple")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("2.1.21")
        }
    }
}

tasks.withType<Test> {
    testLogging {
        events = TestLogEvent.values().toSet() - TestLogEvent.STARTED
        exceptionFormat = TestExceptionFormat.FULL
    }
    outputs.upToDateWhen { false }
}

tasks.withType<Jar>().configureEach {
    manifest {
        attributes("Enable-Native-Access" to "ALL-UNNAMED")
    }
}

application {
    mainClass = "vipsffm.MainKt"
    applicationDefaultJvmArgs = listOf(
        "--enable-preview",
        "--enable-native-access=ALL-UNNAMED"
    )
    tasks.run.get().workingDir = rootProject.projectDir
}