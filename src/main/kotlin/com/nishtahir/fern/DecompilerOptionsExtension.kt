package com.nishtahir.fern

import org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences
import org.jetbrains.java.decompiler.util.InterpreterUtil

open class DecompilerOptionsExtension {
    var classesDir = ""
    var outputDir = ""

    var enabled = true

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

    internal fun asPreferencesMap(): Map<String, String> {
        return mapOf(
                IFernflowerPreferences.REMOVE_BRIDGE to removeBridge.binaryString(),
                IFernflowerPreferences.REMOVE_SYNTHETIC to removeSynthetic.binaryString(),
                IFernflowerPreferences.DECOMPILE_INNER to decompileInner.binaryString(),
                IFernflowerPreferences.DECOMPILE_CLASS_1_4 to decompileClass14.binaryString(),
                IFernflowerPreferences.DECOMPILE_ASSERTIONS to decompileAssertions.binaryString(),
                IFernflowerPreferences.HIDE_EMPTY_SUPER to hideEmptySuper.binaryString(),
                IFernflowerPreferences.HIDE_DEFAULT_CONSTRUCTOR to hideDefaultConstructor.binaryString(),
                IFernflowerPreferences.DECOMPILE_GENERIC_SIGNATURES to decompileGenericSignatures.binaryString(),
                IFernflowerPreferences.NO_EXCEPTIONS_RETURN to noExceptionsReturn.binaryString(),
                IFernflowerPreferences.DECOMPILE_ENUM to decompileEnum.binaryString(),
                IFernflowerPreferences.REMOVE_GET_CLASS_NEW to removeGetClassNew.binaryString(),
                IFernflowerPreferences.LITERALS_AS_IS to literalsAsIs.binaryString(),
                IFernflowerPreferences.BOOLEAN_TRUE_ONE to booleanTrueOne.binaryString(),
                IFernflowerPreferences.ASCII_STRING_CHARACTERS to asciiStringCharacters.binaryString(),
                IFernflowerPreferences.SYNTHETIC_NOT_SET to syntheticNotSet.binaryString(),
                IFernflowerPreferences.UNDEFINED_PARAM_TYPE_OBJECT to undefinedParamTypeObject.binaryString(),
                IFernflowerPreferences.USE_DEBUG_VAR_NAMES to useDebugVarNames.binaryString(),
                IFernflowerPreferences.REMOVE_EMPTY_RANGES to removeEmptyRanges.binaryString(),
                IFernflowerPreferences.FINALLY_DEINLINE to finallyDeinline.binaryString(),
                IFernflowerPreferences.IDEA_NOT_NULL_ANNOTATION to ideaNotNullAnnotation.binaryString(),
                IFernflowerPreferences.LAMBDA_TO_ANONYMOUS_CLASS to lambdaToAnonymousClass.binaryString(),
                IFernflowerPreferences.BYTECODE_SOURCE_MAPPING to bytecodeSourceMapping.binaryString(),
                IFernflowerPreferences.LOG_LEVEL to logLevel,
                IFernflowerPreferences.MAX_PROCESSING_METHOD to maxProcessingMethod.binaryString(),
                IFernflowerPreferences.RENAME_ENTITIES to renameEntities.binaryString(),
                IFernflowerPreferences.USER_RENAMER_CLASS to userRenamerClass.binaryString(),
                IFernflowerPreferences.NEW_LINE_SEPARATOR to newLineSeparator.binaryString(),
                IFernflowerPreferences.INDENT_STRING to indentString,
                IFernflowerPreferences.BANNER to banner,
                IFernflowerPreferences.DUMP_ORIGINAL_LINES to dumpOriginalLines.binaryString(),
                IFernflowerPreferences.UNIT_TEST_MODE to unitTestMode.binaryString()
        )
    }

    private fun Boolean.binaryString() = if (this) {
        "1"
    } else {
        "0"
    }

}