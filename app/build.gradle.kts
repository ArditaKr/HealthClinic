import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.arditakrasniqi.healthclinic"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.arditakrasniqi.healthclinic"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation("androidx.navigation:navigation-compose:2.7.0")
    implementation("androidx.compose.material:material-icons-extended:1.5.0")

    implementation("androidx.compose.ui:ui:1.6.0-alpha03")
    implementation("androidx.compose.material:material:1.6.0-alpha03")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.0-alpha03")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")

    // Room
    implementation("androidx.room:room-ktx:2.5.2")
    implementation("androidx.compose.material3:material3:1.2.0-alpha05")
    implementation("com.google.firebase:firebase-components:17.1.0")
    kapt("androidx.room:room-compiler:2.5.2")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")
    implementation("androidx.hilt:hilt-work:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")

    // Google Maps
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    // Google Maps for Compose
    implementation("com.google.maps.android:maps-compose:2.8.0")

    // KTX for the Maps SDK for Android
    implementation("com.google.maps.android:maps-ktx:3.2.1")
    // KTX for the Maps SDK for Android Utility Library
    implementation("com.google.maps.android:maps-utils-ktx:3.2.1")

    // Permission Management
    implementation("com.google.accompanist:accompanist-permissions:0.30.1")

    // Camerax dependencies
    implementation("androidx.camera:camera-core:1.2.3")
    implementation("androidx.camera:camera-camera2:1.2.3")
    implementation("androidx.camera:camera-lifecycle:1.2.3")
    implementation("androidx.camera:camera-view:1.3.0-beta02")
    implementation("androidx.camera:camera-extensions:1.3.0-beta02")

    // Rx Ble
    implementation("com.polidea.rxandroidble3:rxandroidble:1.17.2")

    // Toasty
    implementation("com.github.GrenderG:Toasty:1.5.2")

    // Work Manager
    implementation("androidx.work:work-runtime-ktx:2.8.1")

    // Compress
    implementation("id.zelory:compressor:3.0.1")
    implementation("com.github.junrar:junrar:1.0.0")

    // Glide
    implementation("com.github.skydoves:landscapist-glide:1.5.1")
    implementation("com.google.accompanist:accompanist-flowlayout:0.17.0")

    //System UI Controller
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.17.0")


    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.0")
    implementation("androidx.compose.ui:ui-graphics:1.5.0")
    implementation("androidx.compose.foundation:foundation:1.5.0")
    implementation("org.json:json:20210307")

    // Jwt
    implementation("com.auth0:java-jwt:3.18.2")
    api("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-orgjson:0.11.5") {
        exclude(group = "org.json", module = "json") //provided by Android natively
    }

    // Loading Animations
    implementation("com.airbnb.android:lottie-compose:4.2.0")
    implementation("com.github.SimformSolutionsPvtLtd:SSJetPackComposeProgressButton:1.0.7")

    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
}