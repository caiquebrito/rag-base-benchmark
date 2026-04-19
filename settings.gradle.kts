pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TakeHome"

include(
    ":app",
    ":main",
    ":presentation",
    ":design",
    ":common",
    ":commonKotlin",
    ":domain",
    ":data",
    ":data-remote"
)
