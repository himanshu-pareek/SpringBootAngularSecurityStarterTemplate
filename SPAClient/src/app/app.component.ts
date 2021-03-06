import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

    constructor(private httpClient: HttpClient) {
    }

    handleButtonClick() {
        console.log("AppComponent:handleButtonClick");
        this.httpClient.get("/projects/0").subscribe(console.log);
    }
}
