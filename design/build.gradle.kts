plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.ctb.design"
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
    implementation("androidx.compose.ui:ui:${property("compose.version")}")
    implementation("androidx.compose.ui:ui-graphics:${property("compose.version")}")
    implementation("androidx.compose.ui:ui-tooling-preview:${property("compose.version")}")
    implementation("androidx.compose.foundation:foundation:${property("compose.version")}")
    implementation("androidx.compose.material3:material3:${property("material3.version")}")

    implementation("androidx.navigation:navigation-compose:${property("navigation.version")}")

    debugImplementation("androidx.compose.ui:ui-tooling:${property("compose.version")}")

    testImplementation("junit:junit:${property("junit.version")}")
}
