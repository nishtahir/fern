package com.nishtahir.fern

import com.nishtahir.fern.internal.FernTransform
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project


open class FernAndroidPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create("fern", DecompilerOptionsExtension::class.java)

        if (project.hasAndroid) {
            project.android.registerTransform(FernTransform(project, extension))
        } else {
            throw GradleException("Fern plugin must be applied *AFTER* Android plugin")
        }
    }

}