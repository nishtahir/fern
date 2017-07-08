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
        val destination = File(extension.outputDir.or("${buildDir}/decompiled-sources"))
        val path = File(extension.classesDir.or("$buildDir/kotlin-classes"))
        val decompiler = ConsoleDecompiler(destination, IFernflowerPreferences.DEFAULTS).apply {
            addSpace(path, true)
        }
        decompiler.decompileContext()
    }
}