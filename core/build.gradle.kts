@file:Suppress("UnstableApiUsage")

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import java.net.URI

plugins {
    `java-library`
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
    sourceCompatibility = JavaVersion.VERSION_22 // intentionally kept at 22
    targetCompatibility = JavaVersion.VERSION_22
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<Javadoc> {
    this.options.overview = "../README.md"
    (options as StandardJavadocDocletOptions).tags("optionalArg:a:\"Optional arguments:\"")

    doLast {
        copy {
            from("build/docs/javadoc")
            into("../docs")
        }
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
    outputs.upToDateWhen { false }
}

tasks.named("check") {
    dependsOn(testing.suites.named("test"))
    dependsOn(testing.suites.named("integrationTest"))
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-native-access=ALL-UNNAMED")
    javaLauncher.set(project.javaToolchains.launcherFor(java.toolchain))
}

tasks.withType<Javadoc> {
    (options as StandardJavadocDocletOptions).tags("optionalArg")
}

dependencies {}

val githubVersion = System.getenv("GITHUB_VERSION") ?: null
val mavenVersion = githubVersion?.removePrefix("v") ?: "local"
val releasePath = "repos/release-${githubVersion}"

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "app.photofox.vips-ffm"
            artifactId = "vips-ffm-core"
            version = mavenVersion

            from(components["java"])

            pom {
                name = "vips-ffm-core"
                description = "libvips for JVM projects, using JDK 22's FFM and Class-File APIs to generate complete, safe, and fast bindings for image manipulation"
                url = "https://github.com/lopcode/vips-ffm"
                licenses {
                    license {
                        name = "Apache License, Version 2.0"
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                    }
                }
                developers {
                    developer {
                        name = "lopcode"
                        url = "https://github.com/lopcode"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/lopcode/vips-ffm.git"
                    developerConnection = "scm:git:https://github.com:lopcode/vips-ffm.git"
                    url = "https://github.com/lopcode/vips-ffm/tree/main"
                }
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = URI.create("https://maven.pkg.github.com/lopcode/vips-ffm")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            name = "Local"
            url = uri(layout.buildDirectory.dir(releasePath))
        }
    }
}

val signingKey = System.getenv("SIGNING_KEY_ID") ?: null
val signingKeyPassphrase = System.getenv("SIGNING_KEY_PASSPHRASE") ?: null

if (!signingKey.isNullOrBlank()) {
    project.ext["signing.gnupg.keyName"] = signingKey
    project.ext["signing.gnupg.passphrase"] = signingKeyPassphrase
    project.ext["signing.gnupg.executable"] = "/usr/local/bin/gpg"

    signing {
        useGpgCmd()
        sign(publishing.publications)
    }
}

tasks.register<Zip>("packageMavenCentralRelease") {
    dependsOn("publishMavenJavaPublicationToLocalRepository")

    archiveFileName.set("release-${githubVersion}.zip")
    destinationDirectory.set(layout.buildDirectory.dir("repos"))

    // exclude hidden files
    exclude("*/.*")

    from(layout.buildDirectory.dir(releasePath))
}