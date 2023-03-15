plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {

    //coroutines
    implementation(Deps.Coroutines.core)

    //javax
    implementation(Deps.Javax.inject)
}