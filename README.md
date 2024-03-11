# How to use this Sample plugin code projects.
1. In this development branch, there are two folders one is mapsted-sample-capacitor and another one is mapsted-sample-cordova. If you are using it by just downloading or git clone the branch in your local system then follow below steps-


## Firstly download this both folders separately.
1. You can use Cordova plugin and Capacitor plugin locally in your Ionic cordova project and Ionic capacitor project.
2. The Cordova plugin and Capacitor plugin are also having git repository.

## Ionic Capacitor Sample App For installing capacitor plugin mapsted-sample-capacitor, After downloading the code in your system folder.
This project serves as a sample of how to integrate the Mapsted SDK into an project Ionic.

The sample Ionic App calls the Mapsted Native SDK for Android and iOS.

## Setup

Clone the repo, then install the packages using:
```sh
npm install
```

Sync files just in case:
Run the app with ionic cli:
```sh
npx cap sync
```

# Integrating into Existing Apps (Android)

* For implementing Mapsted Sdk in Ionic project you need to add some files.

1. Install mapsted plugin

# If you use publish mapsted plugin
Run - npm install maspted

# If you use git code for plugin code locally
Run - npm install file:///path to your plugin folder

2. You need to add some permissions for locations in your AndroidManifest.xml,
path – your-ionic-project\android\app\src\main\AndroidManifest.xml

3. You need to add licence file in your ionic project platform folder.
Path- your-ionic-project\android\app\src\main\assets\demo_android_licence.key

4. You need to implement sdk in build gradle file in android folder.
Path - your-ionic-project\android\build.gradle
Path - your-ionic-project\android\app\build.gradle


# Integrating into Existing Apps (iOS)

1. Install mapsted plugin

# If you use publish mapsted plugin
Run - npm install maspted

# If you use git code for plugin code locally
Run - npm install file:///path to your plugin folder

2. Add licence key.
Path - your-ionic-project\ios\App\App\Resources\ios_licence.key

3. Add sdk in podfile.
Path- your-ion-project\ios\App\Podfile

4. You need to add some permissions for locations in your Info.plist file.
Path- your-ionic-project\ios\App\App\Info.plist

## Ionic Cordova Sample App For installing cordova plugin mapsted-sample-cordova.

## For Android Platform

1. You need to install both cordova plugin wrapper and awesome plugin in your ionic cordova project 
Example - 
2. Create the project
Run - ionic start yourIonicCordovaProject --cordova

Run - npm install

3. Add android platform
Run - ionic cordova platform add android

4. Install the plugin using plain local folder path
Run - ionic cordova plugin add "path to/YourCordovaPLuginFolder"

5. In your AwesomePluginFolder after git clone install node modules
Run - npm install

6. After npm install you have to run below command before install it in your ionic cordova project
Run - npm run build

7. After you run command "npm run build" you will get dist folder then install then awesome cordova plugin code to your ionic cordova project. 

8 Install awesome cordova plugin
Run - npm install "path to /AwesomePluginFolder/dist"

## You need to add permissions in AndroidManifest and some modifications in build.gradle, styles.xml and repositories.gradle files in ionic cordova project.

1. You can check the sample cordova project code for how to add the dependencies in this files.

permissions - 
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    

In build.gradle you can check the sample code for how to add the dependencies in this file. -

Path for build.gradle -
yourIonicCordovaProject\platforms\android\app\build.gradle

android {
    <!-- other dependencies -->
    packagingOptions {
      exclude 'META-INF/LICENSE.md'
      exclude 'META-INF/NOTICE.md'
      exclude 'META-INF/gradle/incremental.annotation.processors'
    }
    dataBinding {
      enabled = true
    }
    other dependencies
        buildTypes {
            release {
                signingConfig signingConfigs.release
            }
            create("staging") {
                multiDexEnabled true
                debuggable true
                versionNameSuffix "-staging"
                signingConfig signingConfigs.getByName("debug")
            }
        }
        packagingOptions {
            resources.excludes.add("META-INF/gradle/*")
            resources.excludes.add("META-INF/*")
        }
        buildFeatures {
            dataBinding true
            buildConfig true
        }
}

Path for Repository-
yourIonicCordovaProject\platforms\android\app\repositories.gradle
Example-

ext.repos = {
    google()
    mavenCentral()
    <!-- Add the below lines -->
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://mobilesdk.mapsted.com:8443/artifactory/gradle-mapsted") }
}

Path for styles.xml (Add this below file code if you face crash issue in your app)-
yourIonicCordovaProject\platforms\android\app\src\main\res\values\styles.xml
Example -

<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
     Customize your theme here 
</style>

after adding style file code add below in AndroidManifest file-

<activity
    android:name="com.mapsted.ui.map.MapstedMapActivity"
    android:theme="@style/AppTheme">
</activity>

2. Add licence key file in Cordova project.
Path - 
yourIonicCordovaProject\platforms\android\app\src\main\assets\demo_android_licence.key

3. Generate android build
ionic cordova build android

4. Echo method is just for testing that you are able to access the cordova plugin or not.

