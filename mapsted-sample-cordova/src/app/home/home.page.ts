import { Component, OnInit } from '@angular/core';
import { AwesomeCordovaPluginMapsted } from 'awesome-cordova-plugins-example/ngx';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage implements OnInit{

  echoVal!: string;
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

  echo() {
    this.mapsted.echo("Hello Echo").then(
      (result: string) => {
        console.log(result);
        this.echoVal = result;
      },
      (error: any) => {
        console.error(error);
      }
    );
  }
}




