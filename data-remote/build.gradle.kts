plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation("com.squareup.retrofit2:retrofit:${property("retrofit.version")}")
    implementation("com.squareup.retrofit2:converter-gson:${property("retrofit.version")}")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.okhttp3:okhttp:${property("okhttp.version")}")
    implementation("com.squareup.okhttp3:logging-interceptor:${property("okhttp.version")}")

    testImplementation("junit:junit:${property("junit.version")}")
    testImplementation("io.mockk:mockk:${property("mockk.version")}")
}
