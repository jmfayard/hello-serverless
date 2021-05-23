import de.fayard.refreshVersions.core.versionFor
import io.kotless.plugin.gradle.dsl.kotless
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

plugins {
    kotlin("jvm")
    id("io.kotless")
}

val packageName = "dev.jmfayard"
group = packageName
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.kotless", "kotless-lang", versionFor("plugin.io.kotless"))
}

tasks.withType<KotlinJvmCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        languageVersion = "1.3"
        apiVersion = "1.3"
    }
}

kotless {
    config {
        bucket = "jm.kotless.bucket"

        terraform {
            profile = "jm.kotless.user"
            region = "eu-west-1"
        }
    }
    webapp {
        lambda {
            kotless {
                packages = setOf(packageName)
            }
        }
    }
}
