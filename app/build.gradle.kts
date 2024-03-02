import java.util.regex.Pattern.compile

plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.monroysrecipes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.monroysrecipes"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        viewBinding = true
    }

}


dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    implementation("androidx.navigation:navigation-ui:2.7.6")
    implementation("com.android.car.ui:car-ui-lib:2.6.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.android.flexbox:flexbox:3.0.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("androidx.transition:transition:1.4.1")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("com.jsibbold:zoomage:1.3.1")
    implementation ("com.github.nirhart:parallaxscroll:1.0")
    implementation ("com.nex3z:toggle-button-group:1.2.3")
    implementation ("com.github.blackfizz:eazegraph:1.2.2@aar")
    implementation ("com.nineoldandroids:library:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.2.0")



}