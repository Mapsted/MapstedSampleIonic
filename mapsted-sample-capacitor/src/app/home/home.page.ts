import { Component, Inject, OnInit, inject } from '@angular/core';
import { MapstedPlugin } from 'mapsted';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  echoedValue: any;

  constructor( 
    @Inject('MapstedPlugin') private mapstedPlugin: MapstedPlugin,
  ) {}

  ngOnInit() {
    this.someCordovaFunction();
  }

  async someCordovaFunction(){
    const valueToEcho = 'Hello, world!';

    // Call the method
    this.mapstedPlugin.echo({ value: valueToEcho }).then((response: { value: any; }) => {
      // Success callback
       this.echoedValue = response.value;
      console.log('Echoed value:', this.echoedValue);
    }).catch((error: any) => {
      // Error callback
      console.error('Failed to echo value:', error);
    });
  }
    async launchActivityCor(){
    console.log('launch map');
    await this.mapstedPlugin.launchMapActivity();
  }

}

