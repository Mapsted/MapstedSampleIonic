# Ionic Sample App
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

1. Create a typescript file to use Mapsted Sdk in your ionic project in the src file 
for example the path will look like this –
Need to create this plugin.ts file in your Ionic project 
Path -your-ionic-project\src\plugins\plugins.ts

2. Create a Java file to use Mapsted Sdk in your ionic project in your android 
platform folder for example the path will look like this –
Your-application.java file – for example you can name it-MapstedApplication.java
Path - Your-ionic-project\android\app\src\main\java\io\ionic\starter\MapstedApplication.java

3. Create another Java file to use your plugin typescript file in your ionic project 
in your android platform folder for example the path will look like this –
Your-ionic-plugin.java file – for example you can name it – MapstedIonicPlugin.java
Path- Your-ionic-project\android\app\src\main\java\io\ionic\starter\MapstedIonicPlugin.java

4. Add some code in MainActivity.java file to use Mapsted sdk in your ionic 
project in your android platform folder for example the path will look like this –
MainActivity.java file – for example – MainActivity.java
Path -your-ionic-project\android\app\src\main\java\io\ionic\starter\MainActivity.java

5. You need to add some permissions for locations in your AndroidManifest.xml,
path – your-ionic-project\android\app\src\main\AndroidManifest.xml

6. You need to add licence file in your ionic project platform folder.
Path- your-ionic-project\android\app\src\main\assets\demo_android_licence.key

# Integrating into Existing Apps (iOS)

1. Create MapstedIonicPlugin files same as we created for android
Path -your-ionic-project\ios\App\App\ViewController\MapstedIonicPlugin.m
Path -Your-ionic-project\ios\App\App\ViewController\MapstedIonicPlugin.swift

2. Create design file For example you can name it - LaunchViewController.swift.
Path- your-ionic-project\ios\App\App\ViewController\LaunchViewController.swift

3. Add code in MainViewController.swift
path-your-ionic-project\ios\App\App\ViewController\MainViewController.swift

4. Add licence key.
Path - your-ionic-project\ios\App\App\Resources\ios_licence.key

5. Add sdk in podfile.
Path-your-ion-project\ios\App\Podfile