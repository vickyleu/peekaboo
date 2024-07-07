/*
 * Copyright 2023-2024 onseok
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("DSL_SCOPE_VIOLATION")

//import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//    id("root.publication")
    // trick: for the same plugin versions in all sub-modules
    id(libs.plugins.android.application.get().pluginId).apply(false)
    id(libs.plugins.android.library.get().pluginId).apply(false)
//    alias(libs.plugins.kotlinAndroid).apply(false)
    id(libs.plugins.kotlin.multiplatform.get().pluginId).apply(false)
    alias(libs.plugins.jetbrains.compose).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
//    alias(libs.plugins.spotless).apply(false)
}

allprojects {
//    apply(plugin = rootProject.libs.plugins.spotless.get().pluginId)
//    configure<SpotlessExtension> {
//        kotlin {
//            target("**/*.kt")
//            targetExclude("**/build/")
//            ktlint().setEditorConfigPath("${project.rootDir}/.editorconfig")
//            licenseHeaderFile(rootProject.file("spotless/copyright.txt"))
//        }
//        kotlinGradle {
//            target("**/*.gradle.kts")
//            targetExclude("**/build/")
//            ktlint().setEditorConfigPath("${project.rootDir}/.editorconfig")
//            licenseHeaderFile(rootProject.file("spotless/copyright.txt"), "(^(?![\\/ ]\\*).*$)")
//        }
//    }
    configurations.all {
        resolutionStrategy {
            eachDependency {
                if (requested.group.startsWith("io.ktor")) {
                    useVersion(libs.versions.ktor.bom.get())
                }
            }
        }
    }
    tasks.withType<KotlinCompile>().all {
        compilerOptions {
            freeCompilerArgs.add("-Xopt-in=kotlin.RequiresOptIn")
            freeCompilerArgs.add("-Xexpect-actual-classes")
        }
    }
}
