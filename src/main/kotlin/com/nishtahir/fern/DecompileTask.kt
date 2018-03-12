package com.nishtahir.fern

import com.nishtahir.fern.internal.FernDecompiler
import com.nishtahir.fern.internal.FernTransform
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction
import java.io.File

open class DecompileTask : DefaultTask() {

    @TaskAction
    fun decompile() {
        with(project) {
                val extension = project.extensions[DecompilerOptionsExtension::class]
                when {
                    hasAndroid -> android.registerTransform(FernTransform(this, extension))
                    hasKotlin -> runDecompileTask(extension, File(extension.classesDir.or { "$buildDir/kotlin-classes" }))
                    hasJava -> runDecompileTask(extension, File(extension.classesDir.or { "$buildDir/classes" }))
                    else -> throw GradleException("No compatible project found...")
                }
        }
    }

    private fun runDecompileTask(decompilerOptions: DecompilerOptionsExtension, path: File) {
        FernDecompiler(path, File("${project.buildDir}/decompiled-sources/${project.name}"), decompilerOptions)
    }

}