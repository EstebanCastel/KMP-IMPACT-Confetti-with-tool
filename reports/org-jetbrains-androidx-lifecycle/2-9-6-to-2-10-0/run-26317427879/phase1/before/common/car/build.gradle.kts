@file:Suppress("UnstableApiUsage")

import java.util.*

plugins {
    id("org.jetbrains.kotlinx.kover")
    id("io.gitlab.arturbosch.detekt")
    id("com.android.library")
    kotlin("android")
}

configureCompilerOptions()

android {
    compileSdk = AndroidSdk.compile
    defaultConfig {
        minSdk = AndroidSdk.min
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }

    buildFeatures {
        buildConfig = true
    }

    namespace = "dev.johnoreilly.confetti.car"
}

dependencies {
    implementation(projects.shared)

    implementation(libs.coil.compose)

    implementation(libs.car.app.auto)

    implementation(libs.play.services.auth)

    coreLibraryDesugaring(libs.desugar)
}

detekt {
    ignoreFailures = true
    buildUponDefaultConfig = true
    reports { xml { required.set(true) } }
}
