/**
 * @author: Antony
 * @description Populates screen with open threads for user
 */

import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from "../../../environments/environment";
import { shared } from "../../../shared/shared";

@Component({
  selector: 'app-threads',
  templateUrl: './threads.component.html',
  styleUrls: ['./threads.component.css']
})

export class ThreadsComponent {
  threads = [];


  // TODO : pull IM-Threads for user to interact with 
  constructor(private http: HttpClient)  {
    debugger;
    console.log(shared.data.userData);
    this.http.get(environment.url + "merlinserver/rest/threads/get/all").subscribe(data => this.threads.push(data));
  }
}

