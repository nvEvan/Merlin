import { Injectable } from '@angular/core';
import { AppComponent } from '../app.component';

@Injectable()
export class LoginService {
  private username: string;
  
  constructor() { }

  login(username: string){
    this.username = username;
  }

  getUsername(){
    return this.username;
  }

  setUsername(username:string){
    this.username = username;
  }

}
