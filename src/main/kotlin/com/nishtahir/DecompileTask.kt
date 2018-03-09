package com.nishtahir

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler
import org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences
import java.io.File

open class DecompileTask : DefaultTask() {

    @TaskAction
    fun decompile() = with(project) {
        val extension = extensions[FernPluginExtension::class]
        val options = mapOf(
                IFernflowerPreferences.REMOVE_BRIDGE to extension.removeBridge.binaryString(),
                IFernflowerPreferences.REMOVE_SYNTHETIC to extension.removeSynthetic.binaryString(),
                IFernflowerPreferences.DECOMPILE_INNER to extension.decompileInner.binaryString(),
                IFernflowerPreferences.DECOMPILE_CLASS_1_4 to extension.decompileClass14.binaryString(),
                IFernflowerPreferences.DECOMPILE_ASSERTIONS to extension.decompileAssertions.binaryString(),
                IFernflowerPreferences.HIDE_EMPTY_SUPER to extension.hideEmptySuper.binaryString(),
                IFernflowerPreferences.HIDE_DEFAULT_CONSTRUCTOR to extension.hideDefaultConstructor.binaryString(),
                IFernflowerPreferences.DECOMPILE_GENERIC_SIGNATURES to extension.decompileGenericSignatures.binaryString(),
                IFernflowerPreferences.NO_EXCEPTIONS_RETURN to extension.noExceptionsReturn.binaryString(),
                IFernflowerPreferences.DECOMPILE_ENUM to extension.decompileEnum.binaryString(),
                IFernflowerPreferences.REMOVE_GET_CLASS_NEW to extension.removeGetClassNew.binaryString(),
                IFernflowerPreferences.LITERALS_AS_IS to extension.literalsAsIs.binaryString(),
                IFernflowerPreferences.BOOLEAN_TRUE_ONE to extension.booleanTrueOne.binaryString(),
                IFernflowerPreferences.ASCII_STRING_CHARACTERS to extension.asciiStringCharacters.binaryString(),
                IFernflowerPreferences.SYNTHETIC_NOT_SET to extension.syntheticNotSet.binaryString(),
                IFernflowerPreferences.UNDEFINED_PARAM_TYPE_OBJECT to extension.undefinedParamTypeObject.binaryString(),
                IFernflowerPreferences.USE_DEBUG_VAR_NAMES to extension.useDebugVarNames.binaryString(),
                IFernflowerPreferences.REMOVE_EMPTY_RANGES to extension.removeEmptyRanges.binaryString(),
                IFernflowerPreferences.FINALLY_DEINLINE to extension.finallyDeinline.binaryString(),
                IFernflowerPreferences.IDEA_NOT_NULL_ANNOTATION to extension.ideaNotNullAnnotation.binaryString(),
                IFernflowerPreferences.LAMBDA_TO_ANONYMOUS_CLASS to extension.lambdaToAnonymousClass.binaryString(),
                IFernflowerPreferences.BYTECODE_SOURCE_MAPPING to extension.bytecodeSourceMapping.binaryString(),
                IFernflowerPreferences.LOG_LEVEL to extension.logLevel,
                IFernflowerPreferences.MAX_PROCESSING_METHOD to extension.maxProcessingMethod.binaryString(),
                IFernflowerPreferences.RENAME_ENTITIES to extension.renameEntities.binaryString(),
                IFernflowerPreferences.USER_RENAMER_CLASS to extension.userRenamerClass.binaryString(),
                IFernflowerPreferences.NEW_LINE_SEPARATOR to extension.newLineSeparator.binaryString(),
                IFernflowerPreferences.INDENT_STRING to extension.indentString,
                IFernflowerPreferences.BANNER to extension.banner,
                IFernflowerPreferences.DUMP_ORIGINAL_LINES to extension.dumpOriginalLines.binaryString(),
                IFernflowerPreferences.UNIT_TEST_MODE to extension.unitTestMode.binaryString()
        )

        val path = File(extension.classesDir.or {
            when {
                pluginManager.hasPlugin("kotlin-android") -> "$buildDir/intermediates/classes"
                pluginManager.hasPlugin("kotlin") -> "$buildDir/kotlin-classes"
                pluginManager.hasPlugin("java") -> "$buildDir/classes"
                else -> throw IllegalArgumentException("No classDir or compatible plugins found")
            }
        })


        val destination = File(extension.outputDir.or { "$buildDir/decompiled-sources" })
        val decompiler = FernDecompiler(destination, options).apply { addSource(path) }
        decompiler.decompileContext()
    }

    private fun Boolean.binaryString() = if (this) {
        "1"
    } else {
        "0"
    }

}