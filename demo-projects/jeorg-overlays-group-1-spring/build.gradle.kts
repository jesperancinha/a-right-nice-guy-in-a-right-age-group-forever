import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id ("org.springframework.boot") version "3.2.0"
	id ("io.spring.dependency-management") version "1.1.0"
	id ("org.jetbrains.kotlin.jvm") version "1.9.21"
	id ("org.jetbrains.kotlin.plugin.spring") version "1.9.21"
	jacoco
}

group = "org.jesperancinha.overlays"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation ("org.springframework.boot:spring-boot-starter-webflux")
	implementation ("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation ("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation ("org.jetbrains.kotlin:kotlin-reflect")
	implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("io.r2dbc:r2dbc-h2")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	testImplementation ("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jacocoTestReport {
	reports {
		xml.required.set(true)
	}
}

val gradleSysVersion = System.getenv("GRADLE_VERSION")

tasks.register<Wrapper>("wrapper") {
	gradleVersion = gradleSysVersion
}
