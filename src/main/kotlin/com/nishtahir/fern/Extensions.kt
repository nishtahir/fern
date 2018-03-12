package com.nishtahir.fern

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionContainer
import kotlin.reflect.KClass

val Project.hasAndroid: Boolean
    get() = extensions.findByName("android") is BaseExtension

val Project.hasJava: Boolean
    get() = plugins.hasPlugin("java")

val Project.hasKotlin: Boolean
    get() = plugins.hasPlugin("kotlin")


val Project.android: BaseExtension
    get() = extensions.getByName("android") as BaseExtension

operator fun <T : Any> ExtensionContainer.get(type: KClass<T>): T {
    return getByType(type.java)
}

fun String.or(default: () -> String) = if (isBlank()) {
    default()
} else {
    this
}

