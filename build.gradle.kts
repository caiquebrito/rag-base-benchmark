plugins {
    kotlin("android") version "1.9.24" apply false
    kotlin("jvm") version "1.9.24" apply false
    kotlin("plugin.serialization") version "1.9.24" apply false
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
}
