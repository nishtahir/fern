# Fern - FernFlower Gradle plugin

This is a wrapper around the Jetbrains FernFlower decompiler.

## Usage

```
buildscript {

    repositories {
        maven { url "https://jitpack.io" }
    }

    dependencies {
        classpath "com.nishtahir:fern:0.1"
    }
}

apply plugin: "com.nishtahir.fern"

```

