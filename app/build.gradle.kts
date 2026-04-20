plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.ctb.takehome"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ctb.takehome"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs += "-P"
        freeCompilerArgs += "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=1.9.24"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}

dependencies {
    implementation(project(":main"))
    implementation(project(":design"))
    implementation(project(":common"))
    implementation(project(":commonKotlin"))

    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.ui:ui:${property("compose.version")}")
    implementation("androidx.compose.ui:ui-graphics:${property("compose.version")}")
    implementation("androidx.compose.ui:ui-tooling-preview:${property("compose.version")}")
    implementation("androidx.compose.foundation:foundation:${property("compose.version")}")
    implementation("androidx.compose.material3:material3:${property("material3.version")}")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${property("lifecycle.version")}")
    implementation("androidx.navigation:navigation-compose:${property("navigation.version")}")

    implementation("io.insert-koin:koin-android:${property("koin.version")}")
    implementation("io.insert-koin:koin-androidx-compose:${property("koin.version")}")

    debugImplementation("androidx.compose.ui:ui-tooling:${property("compose.version")}")
}
