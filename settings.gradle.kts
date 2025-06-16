pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Yurtify"
include(":app")
include(":other")
include(":auth")
include(":common")
include(":list")
include(":map")
include(":notification")
include(":profile")
include(":element")
include(":util")
include(":data")
include(":bottom_nav")
include(":root")
include(":domain")
