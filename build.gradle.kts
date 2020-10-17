import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    base
    kotlin("jvm") version KOTLIN_VERSION
    kotlin("plugin.spring") version KOTLIN_VERSION
    id("org.jlleitschuh.gradle.ktlint") version KTLINT_GRADLE_VERSION
    id("org.springframework.boot") version SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version SPRING_DEPENDENCY_MANAGEMENT_VERSION
}

tasks.wrapper {
    gradleVersion = GRADLE_VERSION
}

allprojects {
    group = "my.demo"
    version = "1.0"

    repositories {
        jcenter()
    }
}

apply(plugin = "org.jlleitschuh.gradle.ktlint-idea")

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    java {
        sourceCompatibility = JavaVersion.VERSION_12
        targetCompatibility = JavaVersion.VERSION_12
    }

    dependencyManagement {
        imports {
            mavenBom(SpringBootPlugin.BOM_COORDINATES)
        }
    }

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")

        testImplementation("io.kotest:kotest-runner-junit5-jvm:$KOTEST_VERSION")
        testImplementation("io.kotest:kotest-assertions-core-jvm:$KOTEST_VERSION")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "12"
        }
    }
}
