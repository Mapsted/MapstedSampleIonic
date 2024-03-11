import { Component } from '@angular/core';
import { Geolocation } from '@capacitor/geolocation';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  constructor() {
    this.checkPermission();
  }

  async checkPermission() {
    // // Check permissions
    const permission = await Geolocation.checkPermissions();

    if (permission.location === 'denied') {
      console.log('permission denied', permission.location);

      // Request permissions
      const permissionRequest = await Geolocation.requestPermissions();
      if (permissionRequest.location === 'granted') {
        // Permission granted, proceed with your logic
      } else {
        // Permission denied, handle accordingly
      }
    } else if (permission.location === 'granted') {
      console.log('permission else if', permission.location);

      // Permission already granted, proceed with your logic
    }
  }
}


