plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.android.ksp)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.kotlin.serialization)

}

android {
    namespace = "pl.kacper.misterski.dog"
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
    implementation(project(":common:util"))
    implementation(project(":core:data"))
    implementation(project(":core:database"))
    implementation(project(":domain:dog"))

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.ktx)
    testImplementation(libs.mockk)
    testImplementation(libs.ktor.client.mock)

    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}