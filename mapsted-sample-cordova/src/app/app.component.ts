import { Component } from '@angular/core';
import { FirebaseCrash } from '@awesome-cordova-plugins/firebase-crash/ngx';
import { Platform } from '@ionic/angular';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  constructor(
    private firebaseCrashlytics: FirebaseCrash,
    private platform: Platform
  ) {
    this.initialize();
  }

  async initialize() {
    await this.platform.ready();
    // const firebaseConfig = {
    //   apiKey: "AIzaSyCZ2YnKUaIx7jUsmJjTV7UPoRsktYV_jOk",
    //   authDomain: "mapsted-crashlytics.firebaseapp.com",
    //   projectId: "mapsted-crashlytics",
    //   storageBucket: "mapsted-crashlytics.appspot.com",
    //   messagingSenderId: "918152133836",
    //   appId: "1:918152133836:web:6805af2ce02ee5c9ab5669",
    //   measurementId: "G-99WCFJ3FHW"
    // };
    
    // Initialize Firebase
    const result = await this.firebaseCrashlytics.log("test crash message")
    console.log('firebaseCrashlytics successfully init', result);
  }
}
