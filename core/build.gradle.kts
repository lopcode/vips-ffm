@file:Suppress("UnstableApiUsage")

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    `java-library`
}

repositories {
    mavenCentral()
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

        register<JvmTestSuite>("integrationTest") {
            useKotlinTest("2.0.0")
            testType = TestSuiteType.INTEGRATION_TEST

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
    }
}

tasks.withType<Test> {
    testLogging {
        events = TestLogEvent.values().toSet() - TestLogEvent.STARTED
        exceptionFormat = TestExceptionFormat.FULL
    }
    jvmArgs("--enable-native-access=ALL-UNNAMED")
    environment(mapOf("DYLD_LIBRARY_PATH" to "native_libs"))
    outputs.upToDateWhen { false }
}

tasks.named("check") {
    dependsOn(testing.suites.named("test"))
    dependsOn(testing.suites.named("integrationTest"))
}

tasks.named("integrationTest") {
    dependsOn(tasks.named("shadowJar"))
}


tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-native-access=ALL-UNNAMED")
    environment(mapOf("DYLD_LIBRARY_PATH" to "native_libs"))
    javaLauncher.set(project.javaToolchains.launcherFor(java.toolchain))
}

dependencies {}