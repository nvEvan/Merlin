import { Injectable } from '@angular/core';
import { AppComponent } from '../../app.component';
import { Http } from '@angular/http';
import { MagicalUser } from '../../models/magical-user.model';

@Injectable()
export class LoginService {
  user: MagicalUser;

  constructor(private http: Http) { }

  // Returns the current user's name
  getUser() {
    return this.user;
  }

  // Set the username 
  setUser(user: MagicalUser) {
    this.user = user;
  }

  // Sets the username to be undefined so that profile component will not
  // be able to see/interact with user data
  logout(){
    this.setUser(undefined);
  }
  
}
