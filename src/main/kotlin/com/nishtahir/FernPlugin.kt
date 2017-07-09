package com.nishtahir

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler
import org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences
import java.io.File

class FernPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        if (!hasKotlinPlugin()) {
            return@with
        }

        extensions.create("fern", FernPluginExtension::class.java)
        task(mapOf("type" to DecompileTask::class.java), "decompile")
    }

    private fun Project.hasKotlinPlugin() = plugins.hasPlugin("kotlin") || plugins.hasPlugin("kotlin-android")
}