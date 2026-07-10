@file:Suppress("UnstableApiUsage")

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    id("com.gradleup.shadow") version "9.4.1"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(platform("org.slf4j:slf4j-bom:2.0.17"))
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.21.3")
    implementation("org.apache.commons:commons-text:1.15.0")
    implementation("com.palantir.javapoet:javapoet:0.15.0")
    implementation("org.slf4j:slf4j-api")
    implementation("org.slf4j:slf4j-simple")
}

java {
    toolchain {
        // the generator uses the Class-File API, which was finalised in JDK 24
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
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

tasks.withType<Jar>().configureEach {
    manifest {
        attributes("Enable-Native-Access" to "ALL-UNNAMED")
    }
}

application {
    mainClass = "vipsffm.Main"
    applicationDefaultJvmArgs = listOf(
        "--enable-native-access=ALL-UNNAMED"
    )
    tasks.run.get().workingDir = rootProject.projectDir
}