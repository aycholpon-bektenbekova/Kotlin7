object Versions {
    const val AGP = "7.3.0"
    const val kotlin = "1.7.10"
    const val androidCore = "1.7.0"
    const val hilt = "2.44.2"
    const val appCompat = "1.6.1"
    const val material = "1.8.0"
    const val constraint = "2.1.4"
    const val jUnit = "4.13.2"
    const val extJUnit = "1.1.5"
    const val espresso = "3.5.1"
    const val room = "2.4.3"
    const val fragment = "1.5.5"
    const val coroutine = "1.6.4"
    const val navComponent = "2.5.3"
    const val vbd = "1.5.8"
}
object Deps{
    object UI {
        const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val extJUnit = "androidx.test.ext:junit:${Versions.extJUnit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }
    object DaggerHilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }
    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }
    object Room {
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
    }
    object Coroutines {
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    }
    object NavComponent {
        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navComponent}"
        const val navUI = "androidx.navigation:navigation-ui-ktx:${Versions.navComponent}"
    }
    object ViewBindingDelegate {
        const val viewBindingDelegate = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.vbd}"
    }
}
object Plugins{
    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }
    object Application {
        const val app = "com.android.application"
        const val library = "com.android.library"
    }
    object Kotlin {
        const val android = "org.jetbrains.kotlin.android"
        const val kapt = "kotlin-kapt"
        const val jvm = "org.jetbrains.kotlin.jvm"
    }
    object Java {
        const val library = "java-library"
    }
}