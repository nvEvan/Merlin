import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

@Injectable()
export class GetUserService {

  constructor(private http: Http) { }

  // Generates a registered user based on a username
  getLogin(username: string) {
    return this.http.post('http://localhost:8085/merlinserver/rest/login/MagicalUser/' + username, {});
  }

  // Generate a json object holding information on a users private information based on there username
  getPrivateInfo(username: string) {
    return this.http.post('http://localhost:8085/merlinserver/rest/login/MagicalUser/info/' + username, {});
  }

}
