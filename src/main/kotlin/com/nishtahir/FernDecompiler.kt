package com.nishtahir

import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler
import org.jetbrains.java.decompiler.main.decompiler.PrintStreamLogger
import org.jetbrains.java.decompiler.main.extern.IFernflowerLogger
import java.io.File

/**
 * Constructor is now protected in Decompiler package
 */
class FernDecompiler(
        destination: File,
        options: Map<String, Any>,
        logger: IFernflowerLogger = PrintStreamLogger(System.out)
) : ConsoleDecompiler(destination, options, logger)