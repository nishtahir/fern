package com.nishtahir

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler
import org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences
import java.io.File

class FernPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        if (hasKotlinPlugin()) {
            return@with
        }

        extensions.create("fern", FernPluginExtension::class.java)
        val extension = extensions[FernPluginExtension::class]

        tasks.create("decompile") {
            val destination = File(extension.outputDir.or("decompiled-sources"))
            val path = File(extension.classesDir.or("$buildDir/kotlin-classes"))
            val decompiler = ConsoleDecompiler(destination, IFernflowerPreferences.DEFAULTS).apply {
                addSpace(path, true)
            }
            decompiler.decompileContext()
        }
    }

    private fun Project.hasKotlinPlugin() = !plugins.hasPlugin("kotlin") || plugins.hasPlugin("kotlin-android")
}