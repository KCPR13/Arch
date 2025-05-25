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

    signingConfigs{
        create("release") {
            keyAlias = "test-alias"
            keyPassword = "test123"
            storeFile = file("$rootDir/keystore.jks")
            storePassword = "test123"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
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

dependencies {
    implementation(project(":common:ui"))
    implementation(project(":common:util"))
    implementation(project(":core:database"))

    implementation(project(":data:dog"))
    implementation(project(":domain:dog"))
    implementation(project(":feature:dog"))


    implementation(project(":data:news"))
    implementation(project(":domain:news"))
    implementation(project(":feature:news"))


    implementation(project(":feature:onboarding"))

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.ktx)


    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}