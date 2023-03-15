// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (Plugins.Application.app) version Versions.AGP apply false
    id (Plugins.Application.library) version Versions.AGP apply false
    id (Plugins.Kotlin.android) version Versions.kotlin apply false
    id (Plugins.DaggerHilt.hilt) version Versions.hilt apply false
    id(Plugins.Kotlin.jvm) version "1.7.10" apply false
}