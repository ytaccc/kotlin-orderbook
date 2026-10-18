plugins {
    kotlin("jvm") version "2.4.0"
    id("org.jlleitschuh.gradle.ktlint") version "14.2.0"
}

group = "io.github.ytaccc.klob"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
