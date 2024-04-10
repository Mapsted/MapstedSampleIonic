import { Component, OnInit } from '@angular/core';
import { AwesomeCordovaPluginMapsted } from 'awesome-cordova-plugins-example/ngx';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage implements OnInit{

  constructor(private mapsted: AwesomeCordovaPluginMapsted) {}

  ngOnInit(): void {
    console.log('ngOnInit');
    
  }

  async launchMap(){
    try {
      await this.mapsted.launchMapActivity();
    } catch (error) {
        console.error('Error launching map:', error);
        // Optionally, notify the user about the error
    }
  }

}




