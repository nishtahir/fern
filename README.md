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
