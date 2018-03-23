# Fern - FernFlower Gradle plugin

This is a wrapper around the Jetbrains FernFlower decompiler.

[![](https://jitpack.io/v/nishtahir/fern.svg)](https://jitpack.io/#nishtahir/fern)

## Usage

```
buildscript {

    repositories {
        maven { url "https://jitpack.io" }
        mavenCentral()
    }

    dependencies {
	    classpath 'com.github.nishtahir:fern:0.3.1'

	    // or place the jar in <project-root/libs> folder
	    classpath 'libs/fern-0.3.1'
    }
}

apply plugin: "com.nishtahir.fern"

// or for Android projects
apply plugin: "com.nishtahir.fern-android"

```

Customization options are exposed via fern extension.

```

fern {
     classesDir = "" // Directory to scan for class files
     outputDir = ""  // output directory
     enabled = true  // false disables the decompiler - useful in android projects

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
A description on what these options do and how they work can be found in the official
FernFlower [documentation](https://github.com/JetBrains/intellij-community/tree/master/plugins/java-decompiler/engine).

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

## Android projects

For Android projects decompilation works by registering a transform step via the transform api, however decompiling during
every build phase can slow down development for this reason, `fern` exposes an `enabled` setting allow you
to skip the decompilation step.


```
fern {
    enabled = false
}
```

## Sample

```
buildscript {
    ext.kotlin_version = "1.2.30"

    repositories {
        maven { url "https://jitpack.io" }
        mavenCentral()
    }
    dependencies {
	    classpath 'com.github.nishtahir:fern:-SNAPSHOT'
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
