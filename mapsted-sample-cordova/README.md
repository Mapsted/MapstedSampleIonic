# How to use Mapsted cordova plugin locally 

# For Android Platform

## You need to install both cordova plugin wrapper and awesome plugin in your ionic cordova project 
Example - 
## Create the project
ionic start yourIonicCordovaProject --cordova

Run - npm install

## Add android platform
Run - ionic cordova platform add android

## Install the plugin using plain local folder path
Run - ionic cordova plugin add "path to/YourCordovaPLuginFolder"

# In your AwesomePluginFolder after git clone install node modules
Run - npm install

# After npm install you have to run below command before install it in your ionic cordova project
Run - npm run build

# After you run command "npm run build" you will get dist folder then install then awesome cordova plugin code to your ionic cordova project. 


## Install awesome cordova plugin
npm install "path to /AwesomePluginFolder/dist"

## You need to add permissions in AndroidManifest and some modifications in build.gradle, styles.xml and repositories.gradle files in ionic cordova project.

### You can check the sample cordova project code for how to add the dependencies in this files.

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

# Add licence key file in Cordova project.
Path - 
yourIonicCordovaProject\platforms\android\app\src\main\assets\demo_android_licence.key

# Generate android build
ionic cordova build android

# Echo method is just for testing that you are able to access the cordova plugin or not.

