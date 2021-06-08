# Paypay : AI-Powered Mobile Self-Checkout App for Offline Shopping
Couldless - Capstone Projects ( Mobility & Smart City )
## About Application
A mobile self-checkout app that can be easily applied with minimal capital in almost every store. This app will be equipped with an image classifier algorithm that can classify products from the store only with phone camera photos. Using this app, consumers can just take photos, pay on the app, then leave without going to the cashier which ultimately solves queueing problems while also minimizing human interaction.
## Contributing
Machine Learning -> We use tflite model to classify 4 classes of sample products,\
Android -> As ui implementation for user, and integration between ML and Cloud as backend, using Kotlin and Java,\
Figma -> For MockUp UI/UX Design,\
Cloud Computing ->  Cloud iam, app engine sma computet engine,
## Depedency
```bash
//kotlin
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation "androidx.core:core-ktx:$coreVersion"
    api "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1"
    api "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1"
//ui
    implementation "androidx.appcompat:appcompat:$appCompatVersion"
    implementation "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    implementation "androidx.recyclerview:recyclerview:$recyclerViewVersion"
    implementation "com.google.android.material:material:$materialVersion"
    implementation "com.github.bumptech.glide:glide:$glideVersion"
    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.5'
    implementation 'androidx.navigation:navigation-ui-ktx:2.3.5'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'com.intuit.sdp:sdp-android:1.0.6'
    implementation 'com.intuit.ssp:ssp-android:1.0.6'
    implementation "androidx.viewpager2:viewpager2:1.0.0"
    implementation 'com.synnapps:carouselview:0.1.5'
    implementation 'com.mikhaellopez:circularimageview:4.2.0'
//httprequest
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
//database
    implementation "androidx.room:room-runtime:2.3.0"
    implementation 'org.tensorflow:tensorflow-lite-support:0.1.0-rc1'
    implementation 'org.tensorflow:tensorflow-lite-metadata:0.1.0-rc1'
    implementation 'org.tensorflow:tensorflow-lite-gpu:2.2.0'
    kapt "androidx.room:room-compiler:2.3.0"
    implementation "androidx.room:room-ktx:2.3.0"
//camera dan TFlite Classifier
    implementation 'com.wonderkiln:camerakit:0.13.1'
    implementation 'org.tensorflow:tensorflow-lite:+'
//lifecycle
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    implementation "androidx.lifecycle:lifecycle-common-java8:2.3.1"
    implementation "androidx.activity:activity-ktx:1.2.3"
//testing
    testImplementation "junit:junit:$junitVersion"
    androidTestImplementation "junit:junit:$junitVersion"
    androidTestImplementation "androidx.test.espresso:espresso-core:$espressoVersion"
    androidTestImplementation "androidx.test:runner:$androidTestVersion"
    androidTestImplementation "androidx.test:rules:$androidTestVersion"
    androidTestImplementation "androidx.test.ext:junit:$junitExtversion"
```
## Design
[MockUp Design in Figma](https://www.figma.com/file/Osh5oG320eGkT5FnMNOoIy/AI-Checkout?node-id=0%3A1)\
Colors : 03A9F4 & 2474A0 \
Font : Ranga & Roboto Condensed
## Sreenshot
<img src="https://user-images.githubusercontent.com/30284330/121230282-40681500-c8b9-11eb-95cf-057982558eb9.png" width="400" height="600" /> 
<p align="center">
<img src="https://user-images.githubusercontent.com/30284330/121230925-fdf30800-c8b9-11eb-8aa4-9f68eafd122f.png" width="400" height="600" /> 
<p> 
<img align="right" src="https://user-images.githubusercontent.com/30284330/121231654-d9e3f680-c8ba-11eb-9d72-c85e64800f35.png" width="400" height="600" />
