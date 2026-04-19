plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${property("coroutines.version")}")

    testImplementation("junit:junit:${property("junit.version")}")
    testImplementation("io.mockk:mockk:${property("mockk.version")}")
    testImplementation("app.cash.turbine:turbine:${property("turbine.version")}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${property("coroutines.version")}")
}
