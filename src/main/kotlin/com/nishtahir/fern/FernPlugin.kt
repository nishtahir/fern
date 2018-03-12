package com.nishtahir.fern

import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project

open class FernPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        if(project.isCompatibleProject()) {
            project.extensions.create("fern", DecompilerOptionsExtension::class.java)
            project.task(mapOf("type" to DecompileTask::class.java), "decompile")
        } else {
            throw GradleException("Fern plugin *must* be applied after Kotlin or Java plugin")
        }

    }

    fun Project.isCompatibleProject(): Boolean = hasKotlin || hasJava
}

