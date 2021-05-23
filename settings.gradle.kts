plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.10.0"
    // https://dev.to/jmfayard/the-one-gradle-trick-that-supersedes-all-the-others-5bpg
    id("com.gradle.enterprise").version("3.6.1")
}

gradleEnterprise {
    buildScan {
        // Accept the license agreement for com.gradle.build-scan plugin
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlways()
    }
}


rootProject.name = "hello-serverless"

