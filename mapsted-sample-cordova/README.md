# How to use Mapsted cordova plugin locally 

This project serves as a sample of how to integrate the Mapsted SDK into an Ionic Cordova project.

The sample Ionic App calls the Mapsted Native SDK for Android.

## Ionic requirements
You need to download below things

1. Node.js: https://nodejs.org/en/download/
2. NPM (Node Package Manager): Included with Node.js installation.
3. NVM (Node Version Manager): https://github.com/nvm-sh/nvm
4. Java JDK and JRE: https://www.oracle.com/java/technologies/javase-jdk15-downloads.html
5. Visual Studio Code: https://code.visualstudio.com/
6. Ionic CLI and Core (for both Cordova and Capacitor): https://ionicframework.com/docs/cli
7. Android Studio: https://developer.android.com/studio
8. Gradle: https://gradle.org/releases/
9. Xcode -version -15.0: Available through the Mac App Store or https://developer.apple.com/xcode/
10. CocoaPods: https://cocoapods.org/

## Setup

1. Clone the repo, then install the packages using:
```sh
npm install
```

2. You need to install both cordova plugin wrapper and awesome plugin in your ionic cordova project.
Cordova plugin Repository - 
https://github.com/Mapsted/mapsted-ionic-cordova-plugin/tree/master

3. Install the plugin using local folder path
```sh
ionic cordova plugin add <path to YourCordovaPLuginFolder>
```

4. Install awesome cordova plugin
```sh
npm install <path to /AwesomePluginFolder/dist>
```

# Integrating into Existing Apps (Android)

## Set minimum compile sdk version target in your project `config.xml` file
```sh
<preference name="android-compileSdkVersion" value="34" />
```

1. Add android platform in your ionic cordova project
```sh
ionic cordova platform add android
```

## Add permissions and file setup 
1. You need to add permissions in AndroidManifest and some modifications in build.gradle, styles.xml and repositories.gradle files in ionic cordova project.

2. You can check the sample cordova project code for how to add the dependencies in this files.
Path for AndroidManifest.xml file- yourIonicCordovaProject\platforms\android\app\src\main\AndroidManifest.xml    
permissions(If it's not there in AndroidManifest.xml file)- 
```sh
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```    
    

In build.gradle you can check the sample code for how to add the dependencies in this file(If you are facing build errors or crash). -

Path for build.gradle -
yourIonicCordovaProject\platforms\android\app\build.gradle
 <!-- other dependencies -->
```sh
apply from: 'src/main/build-extras.gradle'
```

Path for Repository-
yourIonicCordovaProject\platforms\android\app\repositories.gradle
Example-
<!-- Add the below lines --> in ext.repos
```sh
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://mobilesdk.mapsted.com:8443/artifactory/gradle-mapsted") }
```

Path for styles.xml (Add this below file code if you face crash issue in your app)-
yourIonicCordovaProject\platforms\android\app\src\main\res\values\styles.xml
Example -
```sh
<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
     Customize your theme here 
</style>
```

after adding style file code add below in AndroidManifest file-
(If it's not there in AndroidManifest.xml file)
```sh
<activity
    android:name="com.mapsted.ui.map.MapstedMapActivity"
    android:theme="@style/AppTheme">
</activity>
```

3. Add licence key file in Cordova project.
Path - 
yourIonicCordovaProject\platforms\android\app\src\main\assets\demo_android_licence.key

4. Generate android build
```sh
ionic cordova build android
```

5. Echo method in cordova plugin is just for testing that you are able to access the cordova plugin or not.

# Integrating into Existing Apps (IOS)

## File setup 
1. Add ios platform in your ionic cordova project
```sh
ionic cordova platform add ios
```

3. Add source file in Podfile
```sh
# To run in simulator add below source target
source 'https://github.com/Mapsted/podspec-simulator.git'

# To run in device add below source target
source 'https://github.com/Mapsted/podspec.git'
```

2. Add IOS licence key file in Cordova project.
Path - 
yourIonicCordovaProject\platforms\ios\yourIonicCordovaProject\Resources\ios_licence.key

3. Generate IOS build
```sh
ionic cordova build ios
```

