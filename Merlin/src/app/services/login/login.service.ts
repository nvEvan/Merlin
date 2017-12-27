import { Injectable } from '@angular/core';
import { AppComponent } from '../../app.component';
import { Http } from '@angular/http';

@Injectable()
export class LoginService {
  private username: string;

  constructor(private http: Http) { }

  // Returns the current user's name
  getUsername() {
    return this.username;
  }

  // Set the username 
  setUsername(username: string) {
    this.username = username;
  }

  // Sets the username to be undefined so that profile component will not
  // be able to see/interact with user data
  logout(){
    this.setUsername(undefined);
  }
  
}
