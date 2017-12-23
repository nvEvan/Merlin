import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

@Injectable()
export class GetUserService {

  constructor(private http: Http) { }

  getUser(username: string) {
    return this.http.get('http://localhost:8085/MerlinRestNasir/rest/user/get/' + username)
    .map((response: Response) => response.json());
  }
}
