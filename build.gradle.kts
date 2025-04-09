// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()  // Add this repository to ensure all dependencies are available.
    }
    dependencies {
        val navVersion = "2.7.5"  // Make sure the Navigation version is correct
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
        classpath("com.android.tools.build:gradle:8.7.3")  // Ensure the latest AGP version is used
    }
}

plugins {
    // Plugin declarations for Kotlin, Android, and KSP
    id("com.android.application") version "8.7.3" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}
