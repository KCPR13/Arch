plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.android.ksp)
    alias(libs.plugins.hilt.plugin)

}

android {
    namespace = "pl.kacper.misterski.news"
    compileSdk = 35

    defaultConfig {
        minSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":common:util"))
    implementation(project(":domain:news"))
    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.ktx)
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}