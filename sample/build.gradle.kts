@file:Suppress("UnstableApiUsage")

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("jvm") version "2.0.10"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(platform("org.slf4j:slf4j-bom:2.0.16"))
    implementation("org.slf4j:slf4j-api")
    implementation("org.slf4j:slf4j-simple")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22))
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("2.0.0")
            testType = TestSuiteType.UNIT_TEST
        }
    }
}

tasks.withType<Test> {
    testLogging {
        events = TestLogEvent.values().toSet() - TestLogEvent.STARTED
        exceptionFormat = TestExceptionFormat.FULL
    }
    environment(mapOf("DYLD_LIBRARY_PATH" to "native_libs"))
    outputs.upToDateWhen { false }
}

tasks.withType<JavaExec>().configureEach {
    environment(mapOf("DYLD_LIBRARY_PATH" to "native_libs"))
    javaLauncher.set(project.javaToolchains.launcherFor(java.toolchain))
}

tasks.withType<Jar>().configureEach {
    manifest {
        attributes("Enable-Native-Access" to "ALL-UNNAMED")
    }
}

application {
    mainClass = "vipsffm.VipsFfm"
    applicationDefaultJvmArgs = listOf("--enable-native-access=ALL-UNNAMED")
    // todo: figure out how to set DYLD_LIBRARY_PATH here
}