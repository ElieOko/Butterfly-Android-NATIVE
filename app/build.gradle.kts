//import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension

plugins {
    alias(libs.plugins.android.application)
 //   alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
//    id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
//    id("com.google.firebase.crashlytics")
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "elieoko.me.butterfly"
    compileSdk  { version = release(36) }
    defaultConfig {
        applicationId = "elieoko.me.butterfly"
        minSdk { version = release(25) }
        targetSdk { version = release(36) }
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas"
                )
            }
        }
    }
    sourceSets.named("debug") {
        java.directories += mutableSetOf(
            "build/generated/ksp/debug/kotlin",
            "build/generated/ksp/debug/java"
        )
    }

    sourceSets.named("release") {
        java.directories +=mutableSetOf(
            "build/generated/ksp/release/kotlin",
            "build/generated/ksp/release/java"
        )
    }

    sourceSets.named("main") {
        java.directories += mutableSetOf("additionalSourceDirectory/kotlin")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_21
//        targetCompatibility = JavaVersion.VERSION_21
//    }
    buildFeatures {
        compose = true
    }
}
ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}
kotlin {
    compilerOptions {
        languageVersion = org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_3
        // Optional: Set jvmTarget
        // jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    //constraint-layout
    implementation(libs.androidx.constraintlayout.compose)
    //navigation
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
    implementation(libs.androidx.material3.adaptive.navigation3)
    implementation(libs.kotlinx.serialization.core)
    //icon
    implementation(libs.androidx.material.icons.extended)
    //gson
    implementation(libs.gson)
    // datastore
    implementation(libs.androidx.datastore.preferences)
    //ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.logging.jvm)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    //auth
    implementation(libs.ktor.client.auth)
    //Coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.kotlinx.coroutines.play.services)
    // lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation (libs.androidx.lifecycle.extensions)
    implementation( libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.activity.ktx)
    // room
    implementation(libs.androidx.room.runtime)
    //implementation(libs.firebase.crashlytics.gradle)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.paging)
    implementation(libs.androidx.room.ktx)
    // Accompanist Permissions
    implementation(libs.accompanist.permissions)
    //firebase
    //implementation(platform(libs.firebase.bom))
   // implementation(libs.firebase.analytics)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
