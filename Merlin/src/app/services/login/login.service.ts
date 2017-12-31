import { Injectable } from '@angular/core';
import { AppComponent } from '../../app.component';
import { Http } from '@angular/http';
import { UserData } from '../../models/composite/user-data.composite';

@Injectable()
export class LoginService {
  private userData: UserData;

  constructor(private http: Http) { }

  // Returns the current user's name
  getUserData() {
    return this.userData;
  }

  // Set the username 
  setUserData(data: UserData) {
    this.userData = data;
  }

  // Sets the username to be undefined so that profile component will not
  // be able to see/interact with user data
  logout(){
    this.setUserData(undefined);
  }
}
