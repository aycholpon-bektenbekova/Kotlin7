plugins {
    id(Plugins.Application.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.example.kotlin7.data"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //module
    implementation(project(":domain"))

    //android
    implementation(Deps.UI.androidCore)

    //test
    testImplementation(Deps.UI.jUnit)
    androidTestImplementation(Deps.UI.extJUnit)

    //room
    implementation(Deps.Room.room)
    kapt(Deps.Room.compiler)
    implementation(Deps.Room.ktx)

    //coroutines
    implementation(Deps.Coroutines.android)

    //javax
    implementation(Deps.Javax.inject)
}