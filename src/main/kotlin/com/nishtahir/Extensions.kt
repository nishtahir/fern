package com.nishtahir

import org.gradle.api.plugins.ExtensionContainer
import kotlin.reflect.KClass

operator fun <T : Any> ExtensionContainer.get(type: KClass<T>): T {
    return getByType(type.java)!!
}

fun String.or(default : String): String {
    return if(isBlank()) { default } else { this }
}