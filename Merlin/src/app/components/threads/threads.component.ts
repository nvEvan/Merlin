/**
 * @author: Antony
 * @description Populates screen with open threads for user
 */

import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-threads',
  templateUrl: './threads.component.html',
  styleUrls: ['./threads.component.css']
})

export class ThreadsComponent {
  threads = [];



  // TODO : pull IM-Threads for user to interact with 
  constructor(private http: HttpClient)  {
    this.http.get("http://localhost:8085/merlinserver/rest/threads/get/all").subscribe( data => this.threads.push(data));
  }
}

