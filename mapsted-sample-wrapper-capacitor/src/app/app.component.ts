import { Component } from '@angular/core';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import { Geolocation } from '@capacitor/geolocation';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  standalone: true,
  imports: [IonApp, IonRouterOutlet],
})
export class AppComponent {
  constructor() {
    this.checkPermission();
  }
  
  async checkPermission(){
  // Geolocation.checkPermissions().then((res: any)=>{
  //   console.log('check permission',res.location);
  //   if(res.location = 'granted'){
  //   }else{
  //     Geolocation.requestPermissions().then((re:any)=>{
  //       console.log("request", re);
  //     })
  //   }
  // })
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
