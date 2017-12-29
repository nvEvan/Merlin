import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
<<<<<<< HEAD
import { environment } from '../../../environments/environment';
import { MagicalUser } from '../../models/magical-user.model';
=======
import { environment } from './../../../environments/environment';
import { MagicalUser } from '../../models/magical-user.model';
import { useAnimation } from '@angular/core/src/animation/dsl';
>>>>>>> 1c0c2f4814b8bd55d94028a22b5c9b37b671e45d

@Injectable()
export class GetUserService {

  constructor(private http: Http) { }

  // Generates a registered user based on a username
<<<<<<< HEAD
  getLogin(data: MagicalUser) {
    return this.http.post(environment.url + 'merlinserver/rest/login/MagicalUser/', data);
  }

=======
  getLogin(user: MagicalUser) {
    return this.http.post(environment.url + 'merlinserver/rest/login/MagicalUser', user);
  }
>>>>>>> 1c0c2f4814b8bd55d94028a22b5c9b37b671e45d

}
