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

rootProject.name = "My Application"
include(":app")
include(":app:viewapp")
include(":viewoption")
include(":ch6_view")
include(":linearlayoutex")
include(":relativelayoutex")
include(":framelayoutex")
include(":gridlayoutex")
include(":constraintlayoutex")
include(":ch7_layout")
include(":userevent")
include(":ch8_event")
include(":ch9_resource")
include(":permissionex")
include(":alertex")
include(":ch10_notification")
include(":fragmentex")
include(":recyclerviewex")
include(":viewpage2ex")
include(":drawlayoutex")
include(":ch11_jetpack")
