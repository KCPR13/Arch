plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.android.ksp)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "pl.kacper.misterski.arch"
    compileSdk = 35

    defaultConfig {
        applicationId = "pl.kacper.misterski.arch"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtensionVersion.get()
    }
}

//TODO K co jeśli location manager jest uzywany w kilku modułach
// TODO K bannerManager przykład w common util
dependencies {
    implementation(project(":common:ui"))

    implementation(project(":data:dog"))
    implementation(project(":domain:dog"))
    implementation(project(":feature:dog"))


    implementation(project(":data:news"))
    implementation(project(":domain:news"))
    implementation(project(":feature:news"))

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.ktx)


    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}