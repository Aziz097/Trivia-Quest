buildscript {
    val agp_version by extra("7.4.2")
    val agp_version1 by extra("8.8.2")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "8.8.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.9.0" apply false
}