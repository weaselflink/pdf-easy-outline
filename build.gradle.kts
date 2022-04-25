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
    implementation("com.itextpdf:itext7-core:7.2.2")
    implementation("org.slf4j:slf4j-nop:1.7.36")

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation(kotlin("script-runtime"))
    implementation(kotlin("compiler-embeddable"))
    implementation(kotlin("script-util"))
    runtimeOnly(kotlin("scripting-compiler-embeddable"))
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
