plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")// added -
// Without KAPT, the generated classes won't be created
// properly, and your data binding features (like the ones
// we just implemented for SearchFragment) will not work.


}

android {
    namespace = "com.example.thepokemonapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.thepokemonapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        packagingOptions {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true

    }
}

dependencies {
    // Core & UI Libraries
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.appcompat.v161)
    implementation(libs.material.v1100)
    implementation(libs.androidx.constraintlayout.v214)
    implementation(libs.androidx.adapters)
    implementation(libs.androidx.databinding.adapters)

    // Test Libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)

    // Lifecycle Components
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Room Database
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Retrofit for Networking
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    // Navigation Components
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Glide for Image Loading
    implementation(libs.glide)
    ksp(libs.compiler)

    // Gson for API parsing
    implementation(libs.gson)
}
