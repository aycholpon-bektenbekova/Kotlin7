plugins {
    id (Plugins.Application.app)
    id (Plugins.Kotlin.android)
    id (Plugins.Kotlin.kapt)
    id (Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.kotlin7"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.kotlin7"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //module
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation (Deps.UI.androidCore)
    implementation (Deps.UI.appCompat)
    implementation (Deps.UI.material)
    implementation (Deps.UI.constraint)
    testImplementation (Deps.UI.jUnit)
    androidTestImplementation (Deps.UI.extJUnit)
    androidTestImplementation (Deps.UI.espresso)
    implementation (Deps.UI.fragment)

    //room
    implementation (Deps.Room.room)
    kapt (Deps.Room.compiler)
    implementation (Deps.Room.ktx)

    //hilt
    implementation (Deps.DaggerHilt.hilt)
    kapt (Deps.DaggerHilt.compiler)

    //coroutines
    implementation (Deps.Coroutines.android)

    //nav component
    implementation (Deps.NavComponent.navFragment)
    implementation (Deps.NavComponent.navUI)

    //viewBinding delegate
    implementation (Deps.ViewBindingDelegate.viewBindingDelegate)
}