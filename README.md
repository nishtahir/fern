# Fern - FernFlower Gradle plugin

This is a wrapper around the Jetbrains FernFlower decompiler.

[![](https://jitpack.io/v/nishtahir/fern.svg)](https://jitpack.io/#nishtahir/fern)

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

While sensible defaults have been set for Java and Kotlin project class files, you may chose to specify your own
sources using the `classesDir` property in the `fern` configuration.

```
fern {
    classesDir = "my/classes/root"
}
```

By default the decompiler outputs to `$buildDir/decompiled-sources/` however you can specify your own output path
using the `outputDir` property.

```
fern {
    outputDir = "my/output/root"
}
```

To run the decompiler, simply use the decompile task

```
./gradlew decompile
```

If you are decompiling after compiling source, you should run your build step first

```
./gradlew build decompile
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
