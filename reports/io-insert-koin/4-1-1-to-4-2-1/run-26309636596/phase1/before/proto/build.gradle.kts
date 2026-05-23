plugins {
    id("org.jetbrains.kotlinx.kover")
    id("io.gitlab.arturbosch.detekt")
    kotlin("multiplatform")
    id("com.android.library")
    id("com.google.devtools.ksp")
    id("com.squareup.wire")
}

wire {
    kotlin {
    }
}

kotlin {
    jvmToolchain(17)

    androidTarget()
    jvm()

    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.androidx.datastore)
            }
        }
    }
}

android {
    compileSdk = AndroidSdk.compile
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = AndroidSdk.min
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }

    namespace = "dev.johnoreilly.confetti.proto"
}


dependencies {
    coreLibraryDesugaring(libs.desugar)
}

detekt {
    ignoreFailures = true
    buildUponDefaultConfig = true
    reports { xml { required.set(true) } }
}
