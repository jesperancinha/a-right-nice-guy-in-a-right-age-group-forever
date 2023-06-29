import org.jetbrains.kotlin.cli.jvm.main

plugins {
    kotlin("jvm") version "1.8.21"
    application
}

group = "org.jesperancinha.experiments"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

kotlin {
    jvmToolchain(19)
}

application {
    mainClass.set("MainKt")
}
task("runWithJavaExec", JavaExec::class) {
    mainClass.set("MainJava")
    classpath = files(tasks.jar)
    jvmArgs ("--enable-preview")

}