import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class UserPrivateInfoService {

  constructor(private http: Http) { }

  getPrivateInfo(username: string) {
    return this.http.get('http://localhost:8085/MerlinRestNasir/rest/user/get/private/' + username).
    map((response: Response) => response.json());
  }

}
