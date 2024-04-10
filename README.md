# How to use Sample plugin projects.
1. In this development branch, there are two folders one is mapsted-sample-capacitor and another one is mapsted-sample-cordova.
2. Firstly download this both folders separately.
3. You can use Cordova plugin and Capacitor plugin locally in your Ionic cordova project and Ionic capacitor project.

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

# mapsted-sample-capacitor setup
This project serves as a sample of how to integrate the Mapsted SDK into an project Ionic.

The sample Ionic App calls the Mapsted Native SDK for Android and iOS.

## Setup

Clone the repo, then install the packages using:
```sh
npm install
```

Sync files just in case:
```sh
npx cap sync
```

# Integrating into Existing Apps (Android)

* For implementing Mapsted Sdk in Ionic project you need to add some files.

## Install mapsted plugin

1. If you use publish mapsted plugin
Capacitor plugin - 
https://www.npmjs.com/package/mapsted
```sh
npm install maspted
```

or

2. If you use git code for plugin code locally
Capacitor plugin Repository - 
https://github.com/Mapsted/mapsted-ionic-capacitor-plugin
```sh
npm install file:///path to your plugin folder
```

3. You need to add some permissions for locations (GPS) in your AndroidManifest.xml,
path – your-ionic-project\android\app\src\main\AndroidManifest.xml

4. You need to add licence file in your ionic project platform folder.
Path- your-ionic-project\android\app\src\main\assets\demo_android_licence.key

5. You need to implement sdk in build gradle file in android folder.
Path - your-ionic-project\android\build.gradle
Path - your-ionic-project\android\app\build.gradle


# Integrating into Existing Apps (iOS)

* For implementing Mapsted Sdk in Ionic project you need to add some files.

## Install mapsted plugin

1. If you use publish mapsted plugin
```sh
npm install maspted
```

or

2. If you use git code for plugin code locally
```sh
npm install file:///path to your plugin folder
```

3. Add licence key.
Path - your-ionic-project\ios\App\App\Resources\ios_licence.key

4. Add sdk in podfile.
Path- your-ion-project\ios\App\Podfile

5. You need to add some permissions for locations (GPS) in your Info.plist file.
Path- your-ionic-project\ios\App\App\Info.plist

# mapsted-sample-cordova setup

This project serves as a sample of how to integrate the Mapsted SDK into an Ionic cordova project.

The sample Ionic App calls the Mapsted Native SDK for Android.

## Setup

1. Clone the repo, then install the packages using:
```sh
npm install
```
2. Add android platform in your ionic cordova project
```sh
ionic cordova platform add android
```

# Integrating into Existing Apps (Android)

1. You need to install both cordova plugin wrapper and awesome plugin in your ionic cordova project.
Cordova plugin Repository - 
https://github.com/Mapsted/mapsted-ionic-cordova-plugin/tree/development

2. Install the plugin using local folder path
```sh
ionic cordova plugin add <path to YourCordovaPLuginFolder>
```

3. In your AwesomePluginFolder after git clone install node modules
```sh
npm install
```

4. After npm install you have to run below command before install it in your ionic cordova project
```sh
npm run build
```

5. After you run command "npm run build" you will get dist folder then install then awesome cordova plugin code to your ionic cordova project. 

6. Install awesome cordova plugin
```sh
npm install <path to /AwesomePluginFolder/dist>
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

Path for App Repository-
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

# Integrating into Existing Apps (IOS)

1. Same as android folder you need to install both cordova plugin wrapper and awesome plugin in your ionic cordova project.
Cordova plugin Repository - 
https://github.com/Mapsted/mapsted-ionic-cordova-plugin/tree/development

2. Install the plugin using local folder path
```sh
ionic cordova plugin add <path to YourCordovaPLuginFolder>
```

3. In your AwesomePluginFolder after git clone install node modules
```sh
npm install
```

4. After npm install you have to run below command before install it in your ionic cordova project
```sh
npm run build
```

5. After you run command "npm run build" you will get dist folder then install then awesome cordova plugin code to your ionic cordova project. 

6. Install awesome cordova plugin
```sh
npm install <path to /AwesomePluginFolder/dist>
```

## File setup 
1. Add ios platform in your ionic cordova project
```sh
ionic cordova platform add ios
```

2. Add IOS licence key file in Cordova project.
Path - 
yourIonicCordovaProject\platforms\ios\yourIonicCordovaProject\Resources\ios_licence.key

3. Generate IOS build
```sh
ionic cordova build ios
```


