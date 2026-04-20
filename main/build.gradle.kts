plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.ctb.main"
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
    implementation(project(":presentation"))
    implementation(project(":data-remote"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":common"))
    implementation(project(":commonKotlin"))
    implementation(project(":design"))

    implementation("io.insert-koin:koin-android:${property("koin.version")}")
    implementation("io.insert-koin:koin-core:${property("koin.version")}")
    implementation("io.insert-koin:koin-androidx-compose:${property("koin.version")}")

    implementation("com.squareup.okhttp3:okhttp:${property("okhttp.version")}")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${property("lifecycle.version")}")

    testImplementation("junit:junit:${property("junit.version")}")
    testImplementation("io.insert-koin:koin-test:${property("koin.version")}")
}
