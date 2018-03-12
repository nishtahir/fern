package com.nishtahir.fern.internal

import com.android.build.api.transform.*
import com.nishtahir.fern.DecompilerOptionsExtension
import org.gradle.api.Project
import org.gradle.api.logging.LogLevel
import java.io.File
import java.util.*

class FernTransform(private val project: Project, private val decompilerOptions: DecompilerOptionsExtension) : Transform() {

    override fun getName() = "fern-android"

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> = Collections.singleton(QualifiedContent.DefaultContentType.CLASSES)

    override fun isIncremental() = false

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> = Collections.singleton(QualifiedContent.Scope.PROJECT)

    override fun transform(invocation: TransformInvocation) {
        super.transform(invocation)

        invocation.context.logging.captureStandardOutput(LogLevel.INFO)

        val inputs = invocation.inputs.flatMap { it.jarInputs + it.directoryInputs }
        val outputs = inputs.map { input ->
            val format = if (input is JarInput) Format.JAR else Format.DIRECTORY
            invocation.outputProvider.getContentLocation(
                    input.name,
                    setOf(QualifiedContent.DefaultContentType.CLASSES),
                    EnumSet.of(QualifiedContent.Scope.PROJECT),
                    format
            )
        }

        if (decompilerOptions.enabled) {
            val decompiler = FernDecompiler(
                    sources = inputs.map { it.file },
                    outputPath = File("${project.buildDir}/decompiled-sources/${project.name}"),
                    options = decompilerOptions
            )

            decompiler.decompileContext()
        }

        inputs.zip(outputs) { input, output ->
            input.file.copyRecursively(output, true)
        }

    }
}