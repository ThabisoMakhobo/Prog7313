// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    kotlin("android") version "2.1.0" apply false
    id("com.android.application") version "8.10.0" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
}


buildscript {
    dependencies {
        classpath(libs.google.services) // ✅ Kotlin style
    }
}


