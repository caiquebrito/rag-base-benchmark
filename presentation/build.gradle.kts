plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.ctb.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}

dependencies {
    implementation(project(":design"))
    implementation(project(":common"))
    implementation(project(":commonKotlin"))
    implementation(project(":domain"))

    implementation("androidx.compose.ui:ui:${property("compose.version")}")
    implementation("androidx.compose.ui:ui-graphics:${property("compose.version")}")
    implementation("androidx.compose.ui:ui-tooling-preview:${property("compose.version")}")
    implementation("androidx.compose.foundation:foundation:${property("compose.version")}")
    implementation("androidx.compose.material3:material3:${property("material3.version")}")

    implementation("androidx.navigation:navigation-compose:${property("navigation.version")}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${property("lifecycle.version")}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${property("lifecycle.version")}")

    implementation("io.insert-koin:koin-android:${property("koin.version")}")
    implementation("io.insert-koin:koin-androidx-compose:${property("koin.version")}")

    debugImplementation("androidx.compose.ui:ui-tooling:${property("compose.version")}")

    testImplementation("junit:junit:${property("junit.version")}")
    testImplementation("io.mockk:mockk:${property("mockk.version")}")
    testImplementation("app.cash.turbine:turbine:${property("turbine.version")}")
    testImplementation("io.insert-koin:koin-test:${property("koin.version")}")
}
