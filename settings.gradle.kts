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

rootProject.name = "arch"
include(":app")
include(":feature:dog")
include(":feature:news")
include(":data:news")
include(":data:dog")
include(":domain:dog")
include(":domain:news")
include(":core:data")
include(":core:domain")
include(":common:ui")
include(":common:util")
