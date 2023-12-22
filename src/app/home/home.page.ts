import { Component } from '@angular/core';
import { MapstedIonicPlugin } from 'src/plugins/plugins';
import { IonItem, IonButton, IonContent, IonHeader, IonToolbar, IonTitle, IonLabel, IonInput } from '@ionic/angular/standalone';
import { FormsModule } from '@angular/forms';
declare var Mapsted: any;
import { App } from '@capacitor/app';
import { Geolocation } from '@capacitor/geolocation';



@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: true,
  imports: [IonItem, IonButton, IonContent, IonHeader, IonToolbar, IonTitle, IonLabel, IonInput, FormsModule]
})
export class HomePage {

  constructor() {
     MapstedIonicPlugin.initializeMapApis();
  }
  ionViewWillEnter(){
    this.checkPermission();
  }
  async checkPermission(){
    // // Check permissions
  const permission = await Geolocation.checkPermissions();
  
  if (permission.location === 'denied') {
    console.log('permissionRequest.location denied', permission.location);
    // Request permissions
    const permissionRequest = await Geolocation.requestPermissions();
    if (permissionRequest.location === 'granted') {
      // Permission granted, proceed with your logic
      console.log('permissionRequest.location if', permissionRequest.location);
      
    } else {
      // Permission denied, handle accordingly
    }
  } else if (permission.location === 'granted') {
    console.log('permissionRequest.location else if', permission.location);
    // Permission already granted, proceed with your logic
  }
  }

  async launchMapActivity() {
    // await MapstedIonicPlugin.initializeMapApis();
    try {
      await MapstedIonicPlugin.launchMapActivity();
    } catch (error) {
      console.error('Error launching Map Activity:', error);
    }
  }

}
