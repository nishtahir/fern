package com.nishtahir.fern.internal

import com.nishtahir.fern.DecompilerOptionsExtension
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler
import org.jetbrains.java.decompiler.main.decompiler.PrintStreamLogger
import org.jetbrains.java.decompiler.main.extern.IFernflowerLogger
import java.io.File

/**
 * Constructor is now protected in Decompiler package
 */
open class FernDecompiler(
        sources: List<File>,
        outputPath: File,
        options: DecompilerOptionsExtension = DecompilerOptionsExtension(),
        logger: IFernflowerLogger = PrintStreamLogger(System.out)
) : ConsoleDecompiler(outputPath, options.asPreferencesMap(), logger) {

    init {
        sources.forEach(::addSource)
    }

    constructor(
            source: File,
            outputPath: File,
            options: DecompilerOptionsExtension = DecompilerOptionsExtension(),
            logger: IFernflowerLogger = PrintStreamLogger(System.out)
    ) : this(listOf(source), outputPath, options, logger)
}