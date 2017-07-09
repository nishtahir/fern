package com.nishtahir

import org.gradle.api.Plugin
import org.gradle.api.Project

open class FernPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = with(project) {
        extensions.create("fern", FernPluginExtension::class.java)
        task(mapOf("type" to DecompileTask::class.java), "decompile")
    }
}