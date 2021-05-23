import de.fayard.refreshVersions.core.versionFor
import io.kotless.plugin.gradle.dsl.Webapp.Route53
import io.kotless.plugin.gradle.dsl.kotless
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile
import io.kotless.resource.Lambda.Config.Runtime

plugins {
    kotlin("jvm")
    id("io.kotless")
}

val packageName = "dev.jmfayard"
group = packageName
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    //implementation("io.kotless", "ktor-lang-aws", versionFor("plugin.io.kotless"))
    implementation("io.kotless", "ktor-lang", versionFor("plugin.io.kotless"))
    implementation(KotlinX.html.jvm)
}

tasks.withType<KotlinJvmCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        languageVersion = "1.5"
        apiVersion = "1.5"
    }
}

kotless {
    config {
        bucket = "jm.kotless.bucket"
        prefix = "ktor-site"


        terraform {
            profile = "jm.kotless.user"
            region = "eu-west-1"
        }
    }
    webapp {
        route53 = Route53("ktor.site", "kotless.io")

        lambda {
            //runtime = Runtime.GraalVM
        }
    }
}
