plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.ctb.common"
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
}

dependencies {
    implementation(project(":commonKotlin"))

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${property("lifecycle.version")}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${property("lifecycle.version")}")

    implementation("com.squareup.retrofit2:retrofit:${property("retrofit.version")}")
    implementation("com.squareup.retrofit2:converter-gson:${property("retrofit.version")}")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.okhttp3:okhttp:${property("okhttp.version")}")
    implementation("com.squareup.okhttp3:logging-interceptor:${property("okhttp.version")}")

    implementation("io.insert-koin:koin-android:${property("koin.version")}")
    implementation("io.insert-koin:koin-core:${property("koin.version")}")

    testImplementation("junit:junit:${property("junit.version")}")
    testImplementation("io.mockk:mockk:${property("mockk.version")}")
    testImplementation("io.insert-koin:koin-test:${property("koin.version")}")
}
