import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.domain.acleda.domain"
    compileSdk = 35
    
    defaultConfig {
        minSdk = 21
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    
    buildTypes {
        val properties = Properties().apply {
            load(FileInputStream(File(rootProject.rootDir, "local.properties")))
        }
        
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("Boolean", "IS_PRODUCTION", "false")
            buildConfigField("String", "URL_UAT", properties.getProperty("URL_UAT"))
            buildConfigField("String", "URL_PRODUCTION", properties.getProperty("URL_PRODUCTION"))
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("Boolean", "IS_PRODUCTION", "true")
            buildConfigField("String", "URL_UAT", properties.getProperty("URL_UAT"))
            buildConfigField("String", "URL_PRODUCTION", properties.getProperty("URL_PRODUCTION"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    
    buildFeatures.buildConfig = true // build config (include local.properties...)
}

dependencies {
    implementation(project(":data"))
    
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    
    // retrofit 2
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.converter.moshi)
    
    // rxJava
    implementation(libs.rxjava)
    implementation(libs.rxandroid)
    
    // dagger hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)
}

kapt {
    correctErrorTypes = true // allow references to generated code
}