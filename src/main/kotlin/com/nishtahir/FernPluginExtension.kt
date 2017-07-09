package com.nishtahir

import org.jetbrains.java.decompiler.util.InterpreterUtil

open class FernPluginExtension {
    var classesDir = ""
    var outputDir = ""

    var removeBridge = true
    var removeSynthetic = false
    var decompileInner = true
    var decompileClass14 = true
    var decompileAssertions = true
    var hideEmptySuper = true
    var hideDefaultConstructor = true
    var decompileGenericSignatures = false
    var noExceptionsReturn = true
    var decompileEnum = true
    var removeGetClassNew = true
    var literalsAsIs = false
    var booleanTrueOne = true
    var asciiStringCharacters = false
    var syntheticNotSet = true
    var undefinedParamTypeObject = true
    var useDebugVarNames = true
    var removeEmptyRanges = true
    var finallyDeinline = true
    var ideaNotNullAnnotation = true
    var lambdaToAnonymousClass = false
    var bytecodeSourceMapping = false
    var logLevel = "info"
    var maxProcessingMethod = false
    var renameEntities = false
    var userRenamerClass = false
    var newLineSeparator = InterpreterUtil.IS_WINDOWS
    var indentString = "    "
    var banner = ""
    var dumpOriginalLines = false
    var unitTestMode = false
}