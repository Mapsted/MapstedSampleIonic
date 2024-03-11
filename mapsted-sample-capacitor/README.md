# Ionic Sample App For installing capacitor plugin
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