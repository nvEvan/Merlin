import { Injectable } from '@angular/core';
import { AppComponent } from '../../app.component';
import { Http } from '@angular/http';
import { UserPrivateData } from '../../models/composite/user-private-data.composite';

@Injectable()
export class LoginService {
  user: UserPrivateData;

  constructor(private http: Http) { }

  // Returns the current user's name
  getUser() {
    return this.user;
  }

  // Set the username 
  setUser(user: UserPrivateData) {
    this.user = user;
  }

  // Sets the username to be undefined so that profile component will not
  // be able to see/interact with user data
  logout(){
    this.setUser(undefined);
  }
  
}
