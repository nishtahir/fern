# Fern - FernFlower Gradle plugin

This is a wrapper around the Jetbrains FernFlower decompiler.

[![](https://jitpack.io/v/nishtahir/fern.svg)](https://jitpack.io/#nishtahir/fern)

## Requirements

Fern requires either the `kotlin` or `kotlin-android` plugin to be applied to your build script for
the plugin to take effect.

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

Customization options are exposed via fern extension.

```

fern {
     classesDir = "" // Directory to scan for class files
     outputDir = ""  // output directory

     removeBridge = true
     removeSynthetic = false
     decompileInner = true
     decompileClass14 = true
     decompileAssertions = true
     hideEmptySuper = true
     hideDefaultConstructor = true
     decompileGenericSignatures = false
     noExceptionsReturn = true
     decompileEnum = true
     removeGetClassNew = true
     literalsAsIs = false
     booleanTrueOne = true
     asciiStringCharacters = false
     syntheticNotSet = true
     undefinedParamTypeObject = true
     useDebugNames = true
     removeEmptyRanges = true
     finallyDeinline = true
     ideaNotNullAnnotation = true
     lambdaToAnonymousClass = false
     bytecodeSourceMapping = false
     logLevel = "info"
     maxProcessingMethod = false
     renameEntities = false
     userRenamerClass = false
     newLineSeparator = false
     indentString = "    "
     banner = ""
     dumpOriginalLines = false
     unitTestMode = false
}
```

## Sample

```
buildscript {
    ext.kotlin_version = "1.1.2"

    repositories {
        maven { url "https://jitpack.io" }
        mavenCentral()
    }
    dependencies {
        classpath "com.github.nishtahir:fern:7bd46db119"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}

apply plugin: "kotlin"
apply plugin: "com.nishtahir.fern"

fern {
    logLevel = "warn"
}

repositories {
    mavenCentral()
}

dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlin_version"
}

```
