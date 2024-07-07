import org.jetbrains.kotlin.js.translate.context.Namer.kotlin

/*
 * Copyright 2023 onseok
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
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.application)
}

kotlin{
    androidTarget()
}
android {
    namespace = "com.preat.peekaboo.android"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    sourceSets["main"].apply {
        manifest {
            srcFile("src/androidMain/AndroidManifest.xml")
        }
        res {
            srcDirs("src/androidMain/res")
        }
        resources {
            srcDirs("src/commonMain/resources")
        }
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.compileSdk.get().toInt()

        applicationId = "com.preat.peekaboo.android"
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jvmTarget.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jvmTarget.get())
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    dependencies {
        implementation(project(":sample:common"))
        implementation(libs.androidx.activity.compose)
        implementation(libs.appcompat)
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.material3)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.test.ext.junit)
    }
}
