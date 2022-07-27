import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun isNonStable(version: String): Boolean {
    return listOf("alpha", "beta", "dev").any { version.toLowerCase().contains(it) }
}

plugins {
    application
    kotlin("jvm")
    id("com.github.ben-manes.versions")
    id("com.github.johnrengelman.shadow")
}

group = "de.stefanbissell.pdf-easy-outline"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.itextpdf:itext7-core:7.2.3")
    implementation("org.slf4j:slf4j-nop:1.7.36")

    implementation(kotlin("stdlib"))
    runtimeOnly(kotlin("script-runtime"))
    runtimeOnly(kotlin("scripting-common"))
    runtimeOnly(kotlin("scripting-jvm"))
    runtimeOnly(kotlin("scripting-jvm-host"))
    runtimeOnly(kotlin("compiler-embeddable"))
    runtimeOnly(kotlin("scripting-compiler-embeddable"))
    runtimeOnly(kotlin("scripting-jsr223"))
}

application {
    mainClass.set("de.stefanbissell.pdfeasyoutline.MainKt")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    dependencyUpdates {
        rejectVersionIf {
            isNonStable(candidate.version)
        }
    }
}
