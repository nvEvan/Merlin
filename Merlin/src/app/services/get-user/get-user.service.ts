import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { environment } from './../../../environments/environment';
import { MagicalUser } from '../../models/magical-user.model';
import { useAnimation } from '@angular/core/src/animation/dsl';

@Injectable()
export class GetUserService {

  constructor(private http: Http) { }

  // Generates a registered user based on a username
  getLogin(user: MagicalUser) {
    return this.http.post(environment.url + 'merlinserver/rest/login/MagicalUser', user);
  }
}
