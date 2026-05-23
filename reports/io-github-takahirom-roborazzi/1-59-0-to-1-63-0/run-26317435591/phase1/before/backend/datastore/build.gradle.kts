import tapmoc.configureJavaCompatibility

plugins {
    id("org.jetbrains.kotlinx.kover")
    id("io.gitlab.arturbosch.detekt")
  kotlin("multiplatform")
}

configureJavaCompatibility(17)

kotlin {
  jvm()

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(libs.kotlinx.datetime)
      }
    }
    val jvmMain by getting {
      dependencies {
        api(libs.google.cloud.datastore)
        implementation(libs.bare.graphQL)
        implementation(libs.kotlinx.serialization)
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation(libs.kotlin.test)
      }
    }
  }
}
detekt {
    ignoreFailures = true
    buildUponDefaultConfig = true
    reports { xml { required.set(true) } }
}
