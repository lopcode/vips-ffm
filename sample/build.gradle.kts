@file:Suppress("UnstableApiUsage")

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    id("com.gradleup.shadow") version "9.6.1"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(platform("org.slf4j:slf4j-bom:2.0.20"))
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
        getByName<JvmTestSuite>("test") {
            useJUnitJupiter()
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

tasks.withType<JavaExec>().configureEach {
    javaLauncher.set(project.javaToolchains.launcherFor(java.toolchain))
}

// a fat jar runs on the class path, where every class is in the unnamed module
tasks.shadowJar {
    manifest {
        attributes("Enable-Native-Access" to "ALL-UNNAMED")
    }
}

application {
    mainModule = "vipsffm.sample"
    mainClass = "vipsffm.SampleRunner"
    applicationDefaultJvmArgs = listOf("--enable-native-access=app.photofox.vipsffm")
}