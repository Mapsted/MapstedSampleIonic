# Ionic Sample App For installing capacitor plugin
This project serves as a sample of how to integrate the Mapsted SDK into an Ionic Capacitor project.

The sample Ionic App calls the Mapsted Native SDK for Android and iOS.

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