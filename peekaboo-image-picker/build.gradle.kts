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
plugins {
    id(libs.plugins.kotlin.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
//    id("module.publication")
}

kotlin {
    androidTarget {
        publishLibraryVariants("release")
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.compose.bom))
            implementation(project.dependencies.platform(libs.coroutines.bom))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(libs.androidx.annotations)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.exifinterface)
        }
    }
}

android {
    namespace = "com.preat.peekaboo.image.picker"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    publishing{
        singleVariant("release"){
            withSourcesJar()
            withJavadocJar()
        }
    }
//    publishing {
//        singleVariant("release") {
//            withSourcesJar()
//            withJavadocJar()
//        }
//    }
    compileOptions {
        sourceCompatibility =JavaVersion.toVersion(libs.versions.jvmTarget.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jvmTarget.get())
    }
}
