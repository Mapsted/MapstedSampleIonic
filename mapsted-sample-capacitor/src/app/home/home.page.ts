import { Component, Inject, OnInit, inject } from '@angular/core';
import { MapstedPlugin } from 'mapsted';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor( 
    @Inject('MapstedPlugin') private mapstedPlugin: MapstedPlugin,
  ) {}

  ngOnInit() {

  }

    async launchActivityCor(){
    console.log('launch map');
    await this.mapstedPlugin.launchMapActivity();
  }

}

