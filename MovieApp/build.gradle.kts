// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}


buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        var compose_ui_version = "1.3.1"
        var kotlin_version = "1.8.0"
        var nav_version = "2.5.3"
        var hilt_version = "2.48.1"
        var activity_compose_version = "1.6.1"
        var compose_material_version = "1.0.1"

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hilt_version")
    }
}